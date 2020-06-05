package com.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: SynchronizedDemo03
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/4/26 22:27
 */
public class SynchronizedDemo03 {
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
        Ticket ticket = new Ticket();
        Runnable runnable = () -> {
            for (int i=0 ;i<100 ; i++) ticket.sale();
        };
        new Thread(runnable,"T1").start();
        new Thread(runnable,"T2").start();


    }
    /**
     * 票的数量
     */
    static class Ticket{
        public  int num = 100;
        Lock lock = new ReentrantLock();

        public void sale(){
            lock.lock();
            try {
                if (num>0) {
                    System.out.println(Thread.currentThread().getName() + "卖出1张票 还剩" + (--num) + "张票");
                }
            }finally {
                lock.unlock();
            }
        }
    }
}