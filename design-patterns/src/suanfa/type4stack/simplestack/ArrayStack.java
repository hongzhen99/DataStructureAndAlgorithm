package suanfa.type4stack.simplestack;

import java.util.AbstractList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

/**
 * @ClassName: ArrayStack
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/17 14:33
 */
public class ArrayStack {
    private int maxSize; //最大容量
    private int[] stack; //栈
    private int top = -1;//top表示栈顶

    //构造器
    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }
    //判断是否满
    public boolean isFull(){
        return top == maxSize-1;
    }
    //判断是否为空
    public boolean isEmpty(){
        return top == -1;
    }
    //入栈push
    public void push(int value){
        if(isFull()){
            System.out.println("栈已满");
            return;
        }
        top++;
        stack[top] = value;
    }
    //出栈pop
    public int pop(){
        if(isEmpty())
            throw  new RuntimeException("栈空");
        int val = stack[top];
        top--;
        return val;
    }
    //遍历
    public void list(){
        if (isEmpty())
            throw  new RuntimeException("栈空");
        for (int i = top; top>-1 ; top--)
            System.out.println(stack[top]);
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        int pop = arrayStack.pop();
        System.out.println(pop);
        arrayStack.list();

    }
}
