package suanfa.type10hafumantree;


import java.io.*;
import java.util.*;

/**
 * @ClassName: BHaFuManCoding
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/6/4 22:43
 */
public class BHaFuManCoding2 {
    public final static PrintStream out = null;

    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        //40 length
        byte[] contentBytes = content.getBytes();
        //压缩
        byte[] zip = getZip(contentBytes);
        //解压
        byte[] bytes = deCode(huffmanCodes, zip);

        System.out.println("原字符串 =   " + new String(contentBytes));
        System.out.println("经过压缩解压 =" + new String(bytes));

        //测试压缩文件
//        String srcFile = "E:\\cs\\2.docx";
//        String dstFile = "E:\\cs\\2.zip";
//        zipFile(srcFile,dstFile);
        //测试解压文件
//        String srcFile = "E:\\cs\\2.zip";
//        String dstFile = "E:\\cs\\3.docx";
//        unZipFile(srcFile,dstFile);
//        System.out.println("成功");

    }

    /**
     * @param srcFile 文件路径
     * @param dstFile 压缩后路径
     */
    public static void zipFile(String srcFile, String dstFile) {
        //创建文件输入流
        InputStream is = null;
        //创建输出流
        OutputStream os = null;
        ObjectOutputStream oos = null;
        try {
            is = new FileInputStream(srcFile);
            //is.available() 获取字节大小
            byte[] b = new byte[is.available()];
            //读取文件
            is.read(b);
            //队员文件压缩
            byte[] zip = getZip(b);
            //创建输出流
            os = new FileOutputStream(dstFile);
            //ObjectOutputStream
            oos = new ObjectOutputStream(os);
            //吧哈夫曼编码后的字节数组 写入压缩文件
            oos.writeObject(zip);
            //再将 哈夫曼编码 写入压缩文件
            oos.writeObject(huffmanCodes);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
                if (os != null) {
                    os.close();
                }
                if (is != null) {
                    is.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * @param zipFile 文件路径
     * @param dstFile 解压后路径
     */
    public static void unZipFile(String zipFile, String dstFile) {
        //创建文件输入流
        InputStream is = null;
        ObjectInputStream ois = null;
        //创建输出流
        OutputStream os = null;
        try {
            is = new FileInputStream(zipFile);
            ois = new ObjectInputStream(is);
            //读取 哈夫曼编码后的字节数组
            byte[] huffmanBytes = (byte[]) ois.readObject();
            //读取 哈夫曼编码
            Map<Byte, String> huffmanCodes = (Map<Byte, String>) ois.readObject();
            //解压
            byte[] bytes = deCode(huffmanCodes, huffmanBytes);
            //输出流
            os = new FileOutputStream(dstFile);
            //写入
            os.write(bytes);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {

                if (os != null) {
                    os.close();
                }
                if (ois != null) {
                    ois.close();
                }
                if (is != null) {
                    is.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * //封装方法方便调用
     *
     * @param contentBytes 传入一个对象的字节数组
     * @return 返回一个压缩后的字节数组
     */
    public static byte[] getZip(byte[] contentBytes) {
        //1)获取节点集合
        List<Node1> nodes = getNodes(contentBytes);
        //2)根据nodes 创建哈夫曼树
        Node1 hFMTree = creatHFMTree(nodes);
        //3)根据哈夫曼树 生成对应的哈夫曼编码
        Map<Byte, String> huffManTreeRoot = getCoding(hFMTree);
        //4)根据原来得字符得字节数组和生成的哈夫曼编码, 进行压缩  压缩后可以得到 哈夫曼编码字节数组
        byte[] huffManZip = zip(contentBytes, huffManTreeRoot);
        //5)返回
        return huffManZip;
    }

    //接收一个bytes数组  转化成Node List集合
    public static List<Node1> getNodes(byte[] bytes) {
        //用于存放Node1节点的集合
        ArrayList<Node1> nodes = new ArrayList<>();
        //用于记录字符和字符出现的次数
        Map<Byte, Integer> counts = new HashMap<>();
        //遍历  用map先存
        for (byte b : bytes) {
            //取出 看看Map中有无存放该key
            //    如果没有直接put(b,1);
            //    如果有就 put(b,cont+1);
            Integer cont = counts.get(b);
            if (cont == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, cont + 1);
            }
        }
        //到此 map 就记录了所有字符和字符出现得次数
        //遍历map  从map中取 在存入list
        for (Map.Entry<Byte, Integer> mapping : counts.entrySet()) {
            //将map中得key和value取出 存放在Node里  然后在放入集合中
            nodes.add(new Node1(mapping.getKey(), mapping.getValue()));
        }
        //返回Node1节点的集合
        return nodes;
    }


    /**
     * //创建哈夫曼树
     *
     * @param nodes
     * @return
     */
    public static Node1 creatHFMTree(List<Node1> nodes) {
        //每次都是循环 删除权值最低的两个  添加一个新的
        //所以nodes.size 剩一个时 哈夫曼树就创建好了
        while (nodes.size() > 1) {
            //3)排序 从小到大
            Collections.sort(nodes);
            //4)取出前两个
            Node1 leftNode = nodes.get(0);
            Node1 rightNode = nodes.get(1);
            //5)构建一个新的树 此parent节点为非叶子节点 data值为null
            Node1 parent = new Node1(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            //6)删除原来的两个  添加这个新的
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        //返回哈夫曼树
        return nodes.get(0);
    }

    //生生哈夫曼树对应的哈夫曼编码
    //1、将哈夫曼编码表存放在Map<Byte,String> 形式
    static Map<Byte, String> huffmanCodes = new HashMap<Byte, String>();
    //2、StringBuilder存储路径
    static StringBuilder stringBuilder = new StringBuilder();

    //重载
    public static Map<Byte, String> getCoding(Node1 node1) {
        return getCoding(node1, "", stringBuilder);
    }

    /**
     * @param node1         传入节点
     * @param code          路径 左子节点是 0 有子节点是 1
     * @param stringBuilder 用于拼接路径
     *                      编码样式 {32= 01, 97= 100, 100= 11000, 117= 11001, 101= 1110, 118= 11011, 105= 101, 121= 11010, 106= 0010, 107= 1111, 108= 000, 111= 0011}
     */
    protected static Map<Byte, String> getCoding(Node1 node1, String code, StringBuilder stringBuilder) {
        //用于保存当前路径
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        //将code路径 加入到 stringBuilder2
        stringBuilder2.append(code);
        //节点为空时 不进入递归
        if (node1 != null) {
            //非叶子节点
            if (node1.data == null) {
                //向左递归
                getCoding(node1.left, "0", stringBuilder2);
                //向右递归
                getCoding(node1.right, "1", stringBuilder2);
            } else {
                //叶子节点 存入hashMap中
                huffmanCodes.put(node1.data, stringBuilder2.toString());
            }
        }
        //将哈夫曼编码Map返回
        return huffmanCodes;
    }


    /**
     * //编写一个方法 ，将字符串对应的byte[]
     *
     * @param bytes        原始的字符串对应的 byte[]  byte[] contentBytes = content.getBytes(); //40 length
     * @param huffmanCodes 生成的哈夫曼编码
     * @return 返回一个处理后的 byte[]  返回的字符串"10101000101......."
     * 对应的 byte[] huffmanCodesBytes 即8位对应一个 byte,放入huffmanCodesBytes
     * huffmanCodesBytes[0] = 10101000 => byte
     * [10101000 => 高位 1 代表符号位负数 取反加一 => 11010111 + 1 => 1 1011000 = > -88]
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        //用于存储 哈夫曼编码
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            //取出字符对应的哈夫曼编码  追加到stringBuilder
            stringBuilder.append(huffmanCodes.get(b));
        }
        //1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000101111111100110001001010011011100
        // System.out.println(stringBuilder); 上面就是打印结果
        //转byte数组
        //统计返回的 byte[] huffmanCodesBytes的长度
        int len = (stringBuilder.length() + 7) / 8;
        //创建压缩后的数组
        byte[] huffmanCodeByte = new byte[len];
        //索引
        int index = 0;
        //每8位对应一个byte 所以 i += 8
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            String strByte;
            //判断数组越界
            if (i + 8 > stringBuilder.length()) {
                strByte = stringBuilder.substring(i);
            } else {
                strByte = stringBuilder.substring(i, i + 8);
            }
            //将strByte 转成byte 存入huffmanCodesBytes的长度
            huffmanCodeByte[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }
        //返回压缩后得字节数组
        return huffmanCodeByte;
    }
    //完成解压
    //1)先将 [-88, -65, -56, -65, -56, -65, -55, 77, -57, 6, -24, -14, -117, -4, -60, -90, 28]
    //转化为二进制得字符串 "10101000101111111100..." 然后在 ===> 对照哈夫曼编码 ===> "i like like ...   "

    /**
     * @param huffmanCodes 哈夫曼编码表
     * @param huffmanBytes 哈夫曼编码得到的字节数组
     * @return 二进制得字符串 "10101000101111111100..." 然后在 ===> 对照哈夫曼编码 ===> "i like like ...   "
     */
    private static byte[] deCode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {
        //用于拼接二进制字符串
        StringBuilder stringBuilder = new StringBuilder();
        //循环 huffmanBytes
        for (int i = 0; i < huffmanBytes.length; i++) {
            boolean flag = (i == huffmanBytes.length - 1);
            //调用 字节 转 二进制字符串得方法 返回一个二进制字符串
            stringBuilder.append(byteToString(!flag, huffmanBytes[i]));
        }
        //1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000101111111100110001001010011011100
        //吧哈夫曼编码表进行反转 因为反向查询 如 a -> 100 , 100 -> a
        Map<String, Byte> map = new HashMap<>();
        //遍历哈夫曼编码
        for (Map.Entry<Byte, String> mapping : huffmanCodes.entrySet()) {
            //反转 装进 map中
            map.put(mapping.getValue(), mapping.getKey());
        }
        //创建一个集合 存放byte 10101000101111111100100010111111......
        List<Byte> list = new ArrayList<>();
        //循环上面得到的 二进制字符串 stringBuilder
        for (int i = 0; i < stringBuilder.length(); ) {
            //第二个索引 用于截取和定位
            int count = 1;
            //标识
            boolean flag = true;
            //用于接收 二进制字符串 对应 字节
            Byte b;
            //循环 知道找到一个 二进制字符串 对应的字节
            while (flag) {
                //截取从第 i 个到 第 i + count 个
                String key = stringBuilder.substring(i, i + count);
                // 看看反转后的哈夫曼编码中是否存在 key
                b = map.get(key);
                //如果不存在 就 吧count 向右移动一个单位
                if (b == null) {
                    count++;
                } else {
                    //存在的话 标识改为false 退出 while 循环
                    flag = false;
                    //将 字节 存入 list 中
                    list.add(b);
                    //将 i 移动到 第二索引的位置 i + count    上面的for循环 不用 i++
                    i = i + count;
                }
            }
        }
        //结束后 list 中就装了对应 字节
        //这时创建一个字节数组 把 list中的字节 放入字节数组中
        byte[] bytes = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            bytes[i] = list.get(i);
        }
        //返回字节数组
        return bytes;
    }

    /**
     * 将一个byte 装成一个二进制的字符串
     *
     * @param b    传入得byte
     * @param flag 标志是否需要补高位 如果是 true则需要补高位 如果是 false表示不补
     * @return 该 b对应得二进制得字符串
     */
    private static String byteToString(boolean flag, byte b) {
        int temp = b;
        if (flag) {
            //如果是一个整数 就补高位
            temp |= 256;
        }
        //二进制补码
        String str = Integer.toBinaryString(temp);
        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }


    /**
     * //前序遍历
     *
     * @param root 根节点
     */
    public void preOrder(Node1 root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("空树");
        }
    }
}

class Node1 implements Comparable<Node1> {
    Byte data;
    int weight;
    Node1 left;
    Node1 right;

    public Node1(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node1{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Node1 o) {
        return this.weight - o.weight;
    }

    public void preOrder() {
        System.out.println(this);
        if (left != null) {
            left.preOrder();
        }
        if (right != null) {
            right.preOrder();
        }
    }
}
