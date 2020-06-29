package suanfa.type10hafumantree;


import java.util.*;

/**
 * @ClassName: AHaFuManTree
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/6/4 19:05
 */
public class AHaFuManTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node heFuManTree = creatHaFuManTree(arr);
        preOrder(heFuManTree);
    }

    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("空树");
        }
    }

    //创建赫夫曼树
    public static Node creatHaFuManTree(int[] arr) {
        //1、遍历arr数组
        //2、将arr的每个元素 构建成node
        //3、将Node放入ArrayList中 便于管理
        List<Node> nodes = new ArrayList<Node>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }
        //处理过程循环
        while (nodes.size() > 1) {
            //1)先排序  从小到大
            Collections.sort(nodes);
//            System.out.println(nodes);
            //2)取出权值最小的二叉树节点(二叉树)
            Node leftNode = nodes.get(0);
            //3)取出权值最第二小的二叉树节点(二叉树)
            Node rightNode = nodes.get(1);
            //4)构建一个新树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            //5)从ArrayList删除
            nodes.remove(parent.left);
            nodes.remove(parent.right);
            //6)将parent加入nodes
            nodes.add(parent);
        }
        //返回 赫夫曼树的root
        return nodes.get(0);
    }
}

class Node implements Comparable<Node> {
    int value;//节点权值
    Node left; //指向左子节点
    Node right;//指向有子节点

    public Node(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        //表示从小到大
        return this.value - o.value;
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

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}