package com.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Resources {
    private int num = 0;

    private Lock lock = new ReentrantLock();

    Condition condition = lock.newCondition();

    public void increment() throws Exception{
        lock.lock();
        //1、判断
        while (this.num != 0){
            condition.await();
        }
        //2、操作
        try {
            this.num++;
            System.out.println(Thread.currentThread().getName()+"已+++++一");
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void decrement() throws Exception{
        lock.lock();
        //1、判断
        while (this.num == 0){
            condition.await();
        }
        //2、操作
        try {
            this.num--;
            System.out.println(Thread.currentThread().getName()+"已-----一");
            condition.signalAll();
        }finally {
            lock.unlock();

        }
    }

//    public synchronized void increment() throws Exception{
//        //1、判断
//        while (this.num != 0){
//            this.wait();
//        }
//        //2、操作
//        this.num++;
//        System.out.println(Thread.currentThread().getName()+"已+++++一");
//        //3、通知
//        this.notifyAll();
//    }
//
//    public synchronized void decrement() throws Exception{
//        //1、判断
//        while (this.num == 0){
//            this.wait();
//        }
//        //2、操作
//        this.num--;
//        System.out.println(Thread.currentThread().getName()+"已-----一");
//        //3、通知
//        this.notifyAll();
//    }
}
/**
 * @ClassName: ThreadDemo02
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/4/29 22:47
 * 现在有两个线程 可以操作初始值位零的一个变量
 * 实现一个线程对该变量加1，另一个减1
 * 实现交替 来10轮，变量初始值为零
 *  1、高内聚前提下，操作资源类
 *  2、判断/干活/通知
 *  3、多线程交互中，必须要防止多线程的虚假唤醒，也即（判断只能用 while 不能用if）
 */
public class ThreadDemo02 {
    public static void main(String[] args) {
        Resources re = new Resources();

        new Thread(()->{
            try {
                for (int i=0;i<10;i++) re.increment();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"A").start();
        new Thread(()->{
            try {
                for (int i=0;i<10;i++) re.decrement();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"B").start();
        new Thread(()->{
            try {
                for (int i=0;i<10;i++) re.increment();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"C").start();
        new Thread(()->{
            try {
                for (int i=0;i<10;i++) re.decrement();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"D").start();
    }

}
