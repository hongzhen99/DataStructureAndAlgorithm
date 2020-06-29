package suanfa.type1xishushuzu.xishushuzu;

import java.io.*;

/**
 * @ClassName: Test
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/12 22:40
 */
public class Test {

    public static void main(String[] args) {
        //创建原数组
        int[][] chessArr = creat();
        //原数组转化至稀疏数组
        int[][] sparseArr = zhuanhua(chessArr);
        //写文件
        write(sparseArr);
        //读取文件
        int[][] sparseArr2 = read();
        //稀疏数组恢复至原数组
        huifu(sparseArr2);

    }


    public static int[][] creat() {
        //原数组
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[2][4] = 2;
        System.out.println("原始二维数组");
        for (int[] chaArr1 : chessArr) {
            for (int c : chaArr1) {
                System.out.printf("%d\t", c);
            }
            System.out.println();
        }
        return chessArr;
    }

    //数组转稀疏数组
    public static int[][] zhuanhua(int[][] chessArr) {
        //计算 num个数
        int num = 0;
        for (int[] chaArr1 : chessArr) {
            for (int c : chaArr1) {
                if (c != 0) {
                    num++;
                }
            }
        }
        System.out.println("num=" + num);
        //创建稀疏数组 给稀疏数组赋值
        int[][] sparseArr = new int[num + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = num;
        //将非0得值存入稀疏数组中
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }
        System.out.println("稀疏数组展示");
        for (int[] chaArr1 : sparseArr) {
            for (int c : chaArr1) {
                System.out.printf("%d\t", c);
            }
            System.out.println();
        }
        return sparseArr;
    }

    /**
     * 写入map.data文件
     */
    public static void write(int[][] sparseArr) {
        try {
            System.out.println("写入F:/test.txt中...");
            FileWriter fw = new FileWriter("F:\\test.data");
            BufferedWriter bw = new BufferedWriter(fw);
            for (int[] v : sparseArr) {
                for (int d : v) {
                    bw.write(d + "\t");
                }
                bw.newLine();
            }
            bw.close();
            fw.close();
            System.out.println("写入完成");
            System.out.println("=======================");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取map.data文件
     */
    public static int[][] read() {
        System.out.println("读取文件准备恢复稀疏数组");
        BufferedReader br = null;
        int readRow = 0;//记录行数
        //建新的稀疏数组
        int[][] sparseArr2 = new int[4][3];
        try {
            br = new BufferedReader(new FileReader("F:\\test.data"));
            String line = null;
            //统计行数
            while ((line = br.readLine()) != null) {
                String[] temp = line.split("\t");
                for (int j = 0; j < temp.length; j++) {
                    sparseArr2[readRow][j] = Integer.parseInt(temp[j]);
                }
                readRow++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("恢复完成");
        for (int[] chaArr1 : sparseArr2) {
            for (int c : chaArr1) {
                System.out.printf("%d\t", c);
            }
            System.out.println();
        }
        return sparseArr2;
    }

    //将稀疏数组恢复为原始数组
    public static void huifu(int[][] sparseArr2) {
        //读出 行和列
        System.out.println("开始恢复数组");
        int chessArr2[][] = new int[sparseArr2[0][0]][sparseArr2[0][1]];
        for (int i = 1; i < sparseArr2[0][2] + 1; i++) {
            chessArr2[sparseArr2[i][0]][sparseArr2[i][1]] = sparseArr2[i][2];
        }
        System.out.println("恢复后得数组");
        for (int chaArr1[] : chessArr2) {
            for (int c : chaArr1) {
                System.out.printf("%d\t", c);
            }
            System.out.println();
        }
    }
}
