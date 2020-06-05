package com.thread;

/**
 * @ClassName: SynchronizedDemo03
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/4/26 22:27
 */
public class SynchronizedDemo04 {
    public static void main(String[] args) {
        saleTicket();
    }

    /**
     * 买票 资源共享
     */
    public static void saleTicket(){
        /*
            资源共享的情况下  出现状况  数据不统一
              加锁!
         */
        Runnable runnable = () -> {

            while (ThreadFirst02.Ticket.num>0){
                sale();
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
     * 同步方法
     * 静态方法:同步锁就是 类锁 当前类的 .class
     * 非静态方法: 同步锁: 是this
     */
    public synchronized static void sale(){
        if (ThreadFirst02.Ticket.num==0)
            return;
        System.out.println(Thread.currentThread().getName()+"卖出1张票 还剩"+(--ThreadFirst02.Ticket.num)+"张票");
    }
    /**
     * 票的数量
     */
    static class Ticket{
        public static int num = 100;
    }
}