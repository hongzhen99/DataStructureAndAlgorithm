package com.thread;

/**
 * @ClassName: ThreadFirst02
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/4/26 21:39
 */
public class ThreadFirst02 {
    public static void main(String[] args) {

    }

    /**
     * 票的数量
     */
    static class Ticket{
        public static int num = 100;
    }
    /**
     * 买票 资源共享
     */
    public static void saleTicket(){
        /*
            资源共享的情况下  出现状况  数据不统一
         */
        Runnable runnable = () -> {
            while (Ticket.num>1){
                System.out.println(Thread.currentThread().getName()+"卖出1张票 还剩"+(--Ticket.num)+"张票");
            }
        };
        Thread t1 = new Thread(runnable,"T1");
        Thread t2 = new Thread(runnable,"T2");
        Thread t3 = new Thread(runnable,"T3");
        Thread t4 = new Thread(runnable,"T4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }


    /**
     * 线程礼让
     */
    public static void threadYield() {
        Runnable runnable = ()->{
            for (int i = 1 ; i < 10 ; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                if (i == 3) {
                    Thread.yield(); //礼让线程
                }
            }
        };
        Thread t1 = new Thread(runnable,"T1");
        Thread t2 = new Thread(runnable,"T2");
        t1.start();
        t2.start();
    }
    /**
     * 线程优先级
     */
    public static void createThread() {
        /*
            设置线程优先级只是去修改线程抢到CPU时间片的概率
            并不是优先级高的线程一点可以枪到 CPU时间片
            优先级设置,是一个整数 [0 , 10] 默认是5
         */
        Runnable runnable = ()->{
            for (int i = 1 ; i < 10 ; i++)
                System.out.println(Thread.currentThread().getName()+":"+i);
        };
        Thread t1 = new Thread(runnable,"T1");
        Thread t2 = new Thread(runnable,"T2");
        /*
            设置优先级必须放在start前
         */
        t1.setPriority(10);
        t2.setPriority(1);

        t2.start();
        t1.start();


    }
}
