package com.demo;

/**
 * @ClassName: main
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/4/27 0:34
 */
public class Run {
    public static void main(String[] args) {
        //产品池
        ProductPool pool = new ProductPool(15);

        //生产者线程
        new Producer(pool).start();
        //消费者线程
        new Consumer(pool).start();
    }
}
