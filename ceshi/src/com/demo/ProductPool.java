package com.demo;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: PorductPool
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/4/27 0:31
 */
public class ProductPool {
    private List<Product> productList;

    private int maxSize;
    //初始化容量

    public ProductPool(int maxSize){
        this.productList = new LinkedList<Product>();
        this.maxSize = maxSize;
    }

    /**
     * 生产者 将生产好的商品放入商品池
     * 将商品 存入LinkedList
     * @param product
     */
    public synchronized void push(Product product){
        //判断是否还需要继续生产
        if(this.productList.size()==maxSize){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //将商品 存入LinkedList
        this.productList.add(product);
        //放入后 解锁
        this.notifyAll();
    }

    /**
     * 从LinkedList中去商品
     */
    public synchronized Product buy(){
        //判断能否取出
        if (this.productList.size() == 0 ){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //将商品 从LinkedList取出
        Product product = this.productList.remove(0);
        //放入后 解锁
        this.notifyAll();

        return product;
    }
}
