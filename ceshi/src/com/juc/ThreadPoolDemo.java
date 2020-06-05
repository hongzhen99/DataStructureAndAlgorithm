package com.juc;

import sun.nio.ch.ThreadPool;

import java.util.concurrent.*;

/**
 * @ClassName: ThreadPoolDemo
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/2 16:04
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        //最大容量位 max数+队列容量
        //new ThreadPoolExecutor.AbortPolicy()
        //调用者运行 该策略不会抛弃任务
//        new ThreadPoolExecutor.CallerRunsPolicy()
        //抛弃
        //new ThreadPoolExecutor.DiscardPolicy()
        //new ThreadPoolExecutor.DiscardOldestPolicy()
        ExecutorService threadPool =
                new ThreadPoolExecutor(
                2,
                5,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        try {
            for (int i = 0 ; i<10; i ++){
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"办理了");
                });
            }
        }finally {
            threadPool.shutdown();
        }

    }
    public static void aa(){
        ExecutorService threadPool = Executors.newFixedThreadPool(5);//一池五 个
        ExecutorService threadPool1 = Executors.newSingleThreadExecutor();//一池一个
        ExecutorService threadPool2 = Executors.newCachedThreadPool();//一池一个

        try {
            for (int i = 0 ; i<10 ; i ++){
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"办理了");
                });
            }
        }finally {
            threadPool.shutdown();
        }
    }
}
