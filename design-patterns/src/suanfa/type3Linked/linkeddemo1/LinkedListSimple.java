package suanfa.type3Linked.linkeddemo1;

import jdk.nashorn.internal.ir.WhileNode;

/**
 * @ClassName: LinkedListSimple
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/15 15:17
 */
public class LinkedListSimple {
    //定义一个头节点
    private NodeSimple head = new NodeSimple(0,"","");

    public NodeSimple getHead() {
        return head;
    }

    //添加
    public void add(NodeSimple node){
        //临时节点 指向头部
        NodeSimple temp = head;
        //找到最后一个节点 当temp.next==null时 为最后一个节点
        while (temp.next != null){
            temp = temp.next;
        }
        //将最后一个节点的下一个指向为 新节点
        temp.next = node;
    }
    //
    public void addByOrder(NodeSimple node){
        //临时节点 指向头部
        NodeSimple temp = head;
        boolean flag = false;
        while (true){
            if(temp.next == null){//说明链表在最后一个
                break;
            } else if(temp.next.no > node.no){//位置找到  就在temp的后面插入
                break;
            } else if(temp.next.no == node.no){//已存在
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            System.out.println("编号已存在 "+ node.no);
        }else {
            //可以插入
            node.next = temp.next;  //将新节点指向 原来的下一个节点
            temp.next = node;  //将原来的节点的下一个 指向 新节点
        }
    }
    //修改
    public void update(NodeSimple nodeSimple){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        NodeSimple temp = head; //辅助节点
        boolean flag = false;//表示是否找到
        while(true){
            if (temp.next == null){
                break;
            }
            if (temp.next.no == nodeSimple.no){
                flag = true;  //相等时 说明找到目标节点为 temp.next   返回的是temp
                break;
            }
            temp = temp.next;
        }
        if (flag){
            nodeSimple.next = temp.next.next;  //使新节点 指向原节点的下一个
            temp.next = nodeSimple;            //使新节点的上一个指向新节点  进行替换
        } else {
            System.out.println("没有找到"+nodeSimple.no+"节点");
        }
    }
    //删除节点
    public void delNode(int no){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        NodeSimple temp = head; //辅助节点
        boolean flag = false;//表示是否找到
        while(true){
            if (temp.next == null){
                break;
            }
            if (temp.next.no == no){
                flag = true;  //相等时 说明找到目标节点为 temp.next   返回的是temp
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.next = temp.next.next; //跳过要删除的节点
        } else {
            System.out.println("没有找到"+no+"节点");
        }
    }
    //遍历
    public void list(){
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

    public int length(){
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
}
