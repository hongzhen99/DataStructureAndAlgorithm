package com.demo;

/**
 * @ClassName: 生产者
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/4/27 0:44
 */
public class Producer extends Thread{

    private ProductPool productPool;

    public  Producer(ProductPool productPool){
        this.productPool =  productPool;
    }

    @Override
    public void run() {
        while (true){
            String name = (int) (Math.random() * 100) + "号产品";
            System.out.println("生产了"+name);

            Product product = new Product();
            product.setName(name);
            productPool.push(product);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
