package com.thread;

/**
 * @ClassName: ThreadTest01
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/4/26 21:17
 */
public class ThreadTest01 {
    public static void main(String[] args) {
        //方法一 通过自定义线程
        MyThread myThread = new MyThread();
        myThread.start();

        //匿名函数类
        Runnable runnable = ()->{
            for(int i=0;i<10;i++)
                System.out.println("我是子线程二"+ i);
        };
        Thread thread = new Thread(runnable);
        thread.start();

        System.out.println("我是主线程");



    }
}

/**
 * 自定义的线程类
 */
class MyThread extends Thread{
    /**
     * 重写run方法
     */
    @Override
    public void run() {
        for(int i=0;i<10;i++)
            System.out.println("我是子线程一"+ i);
    }
}
