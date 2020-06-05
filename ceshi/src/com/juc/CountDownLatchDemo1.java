package com.juc;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;

/**
 * @ClassName: ContDownLatchDemo
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/1 13:37
 */
public class CountDownLatchDemo1 {
    public static void main(String[] args) throws InterruptedException {
        semaphore1();
    }

    /**
     * 线程计数器
     * @throws InterruptedException
     */
    public static void countDownLatchDemo1() throws InterruptedException {
        //线程技术器
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i= 0 ; i<6 ; i++){
            new Thread(()->{
                System.out.println("走人");
                countDownLatch.countDown();//计数器减一
            },String.valueOf(i)).start();
        }
        countDownLatch.await();//计数器为0时  回复此线程
        System.out.println("======关门======");
    }
    /**
     * 线程计数器
     * @throws InterruptedException
     */
    public static void cyclicBarrierDemo1() throws InterruptedException {
        //定义了6个线程 6个线程结束后走第二个参数
        CyclicBarrier cyclicBarrier = new CyclicBarrier(6, ()->{ System.out.println("======关门======");});

        for (int i= 0 ; i<6 ; i++){
            new Thread(()->{
                System.out.println("走人");
                try {
                    cyclicBarrier.await(); //计数器加一
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }

    }
    /**
     * 线程限流
     */
    public static void semaphore1(){
        //线程限流
        Semaphore semaphore = new Semaphore(3);//只允许三个线程访问

        for (int i= 0 ; i<6 ; i++){
            new Thread(()->{
                try {
                    semaphore.acquire(); //抢占资源
                    System.out.println(Thread.currentThread().getName()+"\t抢占了资源");

                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName()+"\t释放了资源");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release(); //释放资源
                }
            },String.valueOf(i)).start();
        }
    }
}
