package com.demo;

/**
 * @ClassName: Consumer
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/4/27 0:43
 */
public class Consumer extends Thread{

    private ProductPool productPool;

    public  Consumer(ProductPool productPool){
        this.productPool =  productPool;
    }

    @Override
    public void run() {
        while (true){
            Product product = this.productPool.buy();
            System.out.println("消费者购买了"+product.getName());
        }
    }
}
