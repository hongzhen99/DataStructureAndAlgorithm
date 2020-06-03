package suanfa.type3Linked.linkeddemo1;

import com.sun.istack.internal.NotNull;

import java.util.Stack;

/**
 * @ClassName: Run
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/15 15:44
 */
public class Run {
    public static void main(String[] args) {
        NodeSimple nodeSimple = new NodeSimple(1, "aaa", "aaa");
        NodeSimple nodeSimple1 = new NodeSimple(3, "bbb", "bbb");
        NodeSimple nodeSimple2 = new NodeSimple(2, "ccc", "ccc");
        NodeSimple nodeSimple3 = new NodeSimple(3, "ccc1", "ccc");
        LinkedListSimple linkedListSimple = new LinkedListSimple();
        //测试添加
        linkedListSimple.addByOrder(nodeSimple);
        linkedListSimple.addByOrder(nodeSimple1);
        linkedListSimple.addByOrder(nodeSimple2);
        System.out.println("反转前");
        linkedListSimple.list();

        //测试反转
        System.out.println("反转后");
        NodeSimple nodeSimple4 = linkedNodeReverse(linkedListSimple.getHead());
        list(nodeSimple4);
        //反转打印
        System.out.println("反转打印");
        listReverse(nodeSimple4);

        //测试修改
//        linkedListSimple.update(nodeSimple3);
        //测试删除
//        linkedListSimple.delNode(3);
//        linkedListSimple.list();
//        int length = linkedListSimple.length();
//        int length1 = getLength(linkedListSimple.getHead());
//
//        System.out.println(length);
//        System.out.println(length1);
//
//        NodeSimple lastIndexNode = getLastIndexNode(linkedListSimple.getHead(), 2);
//        System.out.println(lastIndexNode);
    }


    //获取倒数第 n 个节点  获取length  在采用length - lastIndex 获取正向遍历的次数
    public static NodeSimple getLastIndexNode(NodeSimple head , int lastIndex){
        if(head.next ==null)
            return null;
        //获取总长度length
        int length = getLength(head);
        //校验index
        if(lastIndex <=0 || lastIndex > length)
            return null;
        //在用 length-lastIndex 即可获取正向的index
        NodeSimple temp = head.next;
        for (int i = 0 ;i < length - lastIndex;i++){
            temp = temp.next;
        }
        return temp;
    }
    //传入一个头节点即可 获取单链表的长度
    public static int getLength(NodeSimple head){
            if (head.next == null)
                return 0;
            int length = 0;
            NodeSimple temp = head;
            while (temp.next != null){
                length++;
                temp = temp.next;
            }
            return length;
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
    //节点倒转   新建一个空节点   遍历原节点的同时 将原节点 挂载 空节点上 最后 将 原节点头指向 创建的节点
    public static NodeSimple linkedNodeReverse(NodeSimple head){
        if (head.next == null || head.next.next == null)
            return null;
        //获取节点长度
        int length = getLength(head);
        NodeSimple temp = head.next;//辅助节点
        NodeSimple node; //中间值 用于传递节点
        NodeSimple head1 = new NodeSimple(0,"","");//用该空节点 当新的头
        for (int i = 0 ; i < length; i++){
            node = temp; //保存当前节点 用当前节点操作
            temp = temp.next; //然后保存指向下一节点
            node.next = head1.next;//
            head1.next = node; //

        }
        head.next = head1.next;
        return head;
    }
    //逆序打印节点  采用 栈
    public static void listReverse(NodeSimple head){
        //判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        //头节点不能动  需要一个辅助头节点
        NodeSimple temp = head;
        Stack<NodeSimple> stack = new Stack<NodeSimple>();

        while (temp.next != null){
            stack.push(temp.next);
            temp = temp.next;
        }
        while (stack.size()>0)
            System.out.println(stack.pop());
    }
}
