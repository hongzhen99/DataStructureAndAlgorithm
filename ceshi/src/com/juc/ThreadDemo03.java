package com.juc;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: ThreadDemo02
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/4/29 22:47
 * 实现线程之间的调用  A->B->C
 * AA打印 5次  BB打印 10次 CC打印 15次
 *  1、高内聚前提下，操作资源类
 *  2、判断/干活/通知
 *  3、多线程交互中，必须要防止多线程的虚假唤醒，也即（判断只能用 while 不能用if）
 *  4、标志位
 */
class ShareRes {
    private  int num = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    public void print(){
        System.out.println("---------");
        lock.lock();
        System.out.println("========");
        try {
            while (num != 1){
                System.out.println(Thread.currentThread().getName());
                condition1.await();
            }
            for (int i = 1 ; i<=5;i++){
                System.out.println(i);
            }
//            num = 2;
            condition1.signal();
            
        }catch (Exception e){
            System.out.println(e);
        }finally {
            lock.unlock();
        }
    }
}
public class ThreadDemo03 {

    public static void main(String[] args) {
        ShareRes shareRes = new ShareRes();

        new Thread(()->{for (int i = 0 ; i<5;i++) shareRes.print();},"AA").start();
        new Thread(()->{for (int i = 0 ; i<5;i++) shareRes.print();},"BB").start();
        new Thread(()->{for (int i = 0 ; i<5;i++) shareRes.print();},"CC").start();
    }

}
