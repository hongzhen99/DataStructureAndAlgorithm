package suanfa.type2duilie.queue;

/**
 * @ClassName: MyQueueDemo
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/13 22:09
 */
//自建 简单的队列
public class MyQueueDemo {
    private int size;//数组的最大容量
    private int front;//列表头
    private int rear;//列表尾
    private int[] queue;//用于存放数据 模拟队列
    public MyQueueDemo(int size) {
        this.size = size;
        queue = new int[size];
        front = -1;//指向队列头部，front指向队列头前一个位置
        rear = -1;//它指向元素的存储位置
    }
    //是否满
    public boolean isFull(){
        return rear==size-1;
    }
    //是否为空
    public boolean isEmpty(){
        return rear==front;
    }
    //添加数据到队列
    public void addQueue(int n){
        if(isFull())
            throw new RuntimeException("队列已满");
        queue[++rear] = n;
    }
    //出队列
    public int outQueue(){
        if (isEmpty())
            throw new RuntimeException("队列为空,不能取值");
        return queue[++front];
    }
    //遍历
    public void showQueue(){
        if (isEmpty())
            throw new RuntimeException("队列为空");
        for (int i=front+1;i<queue.length;i++){
            System.out.printf("queue[%d]=%d\n",i,queue[i]);
        }
    }
    //显示队列的头部数据
    public int headQueue(){
        if (isEmpty())
            throw new RuntimeException("队列为空");
        return queue[front+1];
    }
}
