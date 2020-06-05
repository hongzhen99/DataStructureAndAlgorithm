package com.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: CallableDemo
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/4/30 23:00
 */
class Tread2 implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        System.out.println("===========");
        TimeUnit.SECONDS.sleep(4);
        return 1;
    }

}

public class CallableDemo {
    public static void main(String[] args) throws Exception {

        Tread2 tread2 = new Tread2();
        FutureTask futureTask = new FutureTask(tread2);

        new Thread(futureTask,"a").start();
        new Thread(()->{
            try {
                System.out.println("aaa");
                TimeUnit.SECONDS.sleep(4);
                System.out.println("bbb");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"b").start();
        System.out.println("完成");
        System.out.println(futureTask.get());
    }
}
