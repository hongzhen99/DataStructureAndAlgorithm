package com.juc;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: ticket01
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/4/26 15:49
 */
public class TicketDemo01 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        //public Thread(ThreadGroup group, String name)
        new Thread(() -> {
            for (int i =0;i<40;i++) ticket.sale();
        },"A").start();
        new Thread(() -> {
            for (int i =0;i<40;i++) ticket.sale();
        },"B").start();
        new Thread(() -> {
            for (int i =0;i<40;i++) ticket.sale();
        },"C").start();
    }
}
class Ticket{

    private int number = 30;

    Lock lock = new ReentrantLock();

    public void sale(){
        lock.lock();//获得锁
        try {
            if (number>0){
                System.out.println(Thread.currentThread().getName()+
                        "\t卖出1张：\t还剩下："+(--number) );
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();//释放锁
        }
    }
}