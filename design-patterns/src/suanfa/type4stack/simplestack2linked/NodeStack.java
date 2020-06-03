package suanfa.type4stack.simplestack2linked;

import suanfa.type3Linked.linkeddemo1.NodeSimple;

/**
 * @ClassName: LinkedList
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/17 15:04
 */
public class NodeStack {

    public int value;
    public NodeStack next;


    public NodeStack(int value){
        this.value = value;
    }

}
class Demo{
    private int maxSize;
    private NodeStack head = new NodeStack(-1);
    private int top = 0;

    public Demo(int maxSize){
        this.maxSize = maxSize;
    }

    public boolean isFull(){
        return top == maxSize;
    }
    public boolean isEmpty(){
        return top == 0;
    }
    //入栈
    public int push(int value){
        if(isFull()){
            throw new RuntimeException("栈满");
        }
        NodeStack newNode = new NodeStack(value);//新建一个节点
        NodeStack temp = head; //辅助节点
        if(temp.next != null ){
            newNode.next = temp.next;
        }
        temp.next = newNode;
        top++;
        return value;
    }
    //出栈
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        NodeStack temp = head.next;
        head.next = temp.next;
        top--;
        return temp.value;
    }
    //遍历
    public void list(){
        //判断链表是否为空
        if(isEmpty()){
            System.out.println("链表为空");
            return;
        }
        //头节点不能动  需要一个辅助头节点
        NodeStack temp = head;
        while (temp.next != null){
            System.out.println(temp.next.value);
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
//        Demo demo = new Demo(3);
//        System.out.println(demo.push(1));
//        System.out.println(demo.push(2));
//        System.out.println(demo.push(3));
//        demo.list();
//        System.out.println(demo.pop());
//        System.out.println(demo.pop());
//        System.out.println(demo.pop());
//        System.out.println(demo.pop());
        System.out.println('1');

    }
}
