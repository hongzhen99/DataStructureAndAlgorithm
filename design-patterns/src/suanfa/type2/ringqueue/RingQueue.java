package suanfa.type2.ringqueue;

/**
 * @ClassName: MyQueueDemo
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/13 22:09
 */
//自建 简单环形队列
public class RingQueue {
    private int size;//数组的最大容量
    private int front;//列表头
    private int rear;//列表尾
    private int[] queue;//用于存放数据 模拟队列

    public RingQueue(int size) {
        this.size = size;  //有效值 -1个  因为预留一个位置判断 是否存满
        queue = new int[size];
        front = 0;//指向队列头部，front第一个元素的位置
        rear = 0;// 它指向下一个入队元素的存储位置
    }
    //是否满
    public boolean isFull(){
        return (rear+1) % size == front;
    }
    //是否为空
    public boolean isEmpty(){
        return rear==front;
    }
    //添加数据到队列
    public void addQueue(int n){
        if(isFull())
            throw new RuntimeException("队列已满");

        queue[rear] = n; // 0   1
        //rear 向后移  这里考虑取模
        rear = (rear+1) % size; // 1 2
    }
    //出队列
    public int outQueue(){
        if (isEmpty())
            throw new RuntimeException("队列为空,不能取值");
        int a = queue[front];
        front = (front+1) % size;
        return a;
    }
    //遍历
    public void showQueue(){
        if (isEmpty())
            throw new RuntimeException("队列为空");
        for (int i=front;i<front+getSize();i++){
            System.out.printf("queue[%d]=%d\n",i % size,queue[i % size]);
        }
    }
    //显示队列的头部数据
    public int headQueue(){
        if (isEmpty())
            throw new RuntimeException("队列为空");
        return queue[front];
    }
    public int getSize(){
        return (rear -front +size) % size;
    }
}
