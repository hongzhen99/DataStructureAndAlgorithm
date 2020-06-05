package suanfa.type10hafumantree;

import java.util.*;

/**
 * @ClassName: BHaFuManCoding
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/6/4 22:43
 */
public class BHaFuManCoding {
    public static void main(String[] args) {
//        String str = "i like you because you are very cute";
        String str = "i like like like java do you like a java";
        Map<Character, Integer> hashMap = new TreeMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c1 = str.charAt(i);
            if (hashMap.containsKey(c1)) {
                int old = hashMap.get(c1);
                hashMap.put(c1, old + 1);
            } else {
                hashMap.put(c1, 1);
            }
        }
        /*
           要实现 将map中的value 升序排列
         */
        //这里将转换 map.entrySet()存入list
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(hashMap.entrySet());

        //升序排序  内部排序
//        list.sort(Map.Entry.comparingByValue());

        NodeChar nodeChar = creatHFMTree(list);

        preOrder(nodeChar);

    }
    public static NodeChar creatHFMTree(List<Map.Entry<Character,Integer>> list){

        List<NodeChar> nodes = new ArrayList<>();//用于管理NodeChar
        //1)
        for(Map.Entry<Character,Integer> mapping : list){
            NodeChar nodeChar = new NodeChar(mapping.getKey(), mapping.getValue());//将数据存入NodeChar
            nodes.add(nodeChar);
        }
        //2)
        while ( nodes.size() > 1) {
            //3)排序
            Collections.sort(nodes);
            //4)取出前两个
            NodeChar leftNode = nodes.get(0);
            NodeChar rightNode = nodes.get(1);
            //5)构建一个新的树
            NodeChar parent = new NodeChar(leftNode.value + rightNode.value);
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
    public static void preOrder(NodeChar root){
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("空树");
        }
    }
}

class NodeChar extends Node {

    char character = '-';//存放对应的字符

    public NodeChar(int value) {
        super(value);
    }

    public NodeChar(char character,int value) {
        super(value);
        this.character = character;
    }

    @Override
    public int compareTo(Node o) {
        //表示从小到大
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "character="+ character+","+
                "value=" + value +
                '}';
    }
}
