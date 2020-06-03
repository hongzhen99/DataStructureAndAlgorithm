package suanfa.type3Linked.test;

import suanfa.type3Linked.linkeddemo1.LinkedListSimple;
import suanfa.type3Linked.linkeddemo1.NodeSimple;

/**
 * @ClassName: TwoLinkedList
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/15 19:27
 */
public class TwoLinkedList {


    public static void main(String[] args) {
        LinkedListSimple linked1 = new LinkedListSimple();
        NodeSimple n1 = new NodeSimple(1, "我是", "1");
        NodeSimple n3 = new NodeSimple(3, "我是", "3");
        NodeSimple n5 = new NodeSimple(5, "我是", "5");
        linked1.addByOrder(n1);
        linked1.addByOrder(n3);
        linked1.addByOrder(n5);
        LinkedListSimple linked2 = new LinkedListSimple();
        NodeSimple n2 = new NodeSimple(2, "我是", "2");
        NodeSimple n4 = new NodeSimple(4, "我是", "4");
        NodeSimple n6 = new NodeSimple(6, "我是", "6");
        linked2.addByOrder(n2);
        linked2.addByOrder(n4);
        linked2.addByOrder(n6);
        //两个链表 创建完成
        //合并两个有序的单链表,合并之后的链表依然 有序
        System.out.println("合并前");
        list(linked1.getHead());
        list(linked2.getHead());
        System.out.println("合并后");
        NodeSimple newNode = nodeMerge(linked1.getHead(), linked2.getHead());
        list(newNode);


    }
    //合并链表
    public static NodeSimple nodeMerge(NodeSimple n1, NodeSimple n2){
        //创建一个新的节点 用于合并两个单链表
        NodeSimple newNode = new NodeSimple(0,"","");
        NodeSimple temp1 = n1.next; //辅助n1节点
        NodeSimple temp2 = n2.next; //辅助n2节点
        NodeSimple temp3 = newNode; //辅助 newNode 节点
        while (true){
            if(temp1 == null){
                temp3.next = temp2;
                break;
            }
            if(temp2 ==null){
                temp3.next = temp1;
                break;
            }
            if(temp1.no < temp2.no){
                temp3.next = temp1; //先赋值
                temp3 = temp3.next; //在指向下一个节点
                temp1 = temp1.next; //链表n1指向下一个节点
            }else if (temp1.no > temp2.no){
                temp3.next = temp2; //先赋值
                temp3 = temp3.next; //在指向下一个节点
                temp2 = temp2.next; //链表n2指向下一个节点
            }
        }
        return newNode;

    }
    ////遍历
    public static void list(NodeSimple head){
        //判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        //头节点不能动  需要一个辅助头节点
        NodeSimple temp = head;
        while (temp.next != null){
            System.out.println(temp.next);
            temp = temp.next;
        }
    }

}
