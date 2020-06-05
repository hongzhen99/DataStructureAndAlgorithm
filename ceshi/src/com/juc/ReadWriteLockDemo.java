package com.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName: ReadWirteLockDemo
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/2 13:26
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        Res res = new Res();

        for (int i=0 ;i <5;i++){
            final int tem = i;
            new Thread(()->{
                res.put(tem+"",tem+"");
            },String.valueOf(i)).start();
        }
        for (int i=0 ;i <5;i++){
            final int tem = i;
            new Thread(()->{
                res.get(tem+"");
            },String.valueOf(i)).start();
        }
    }
}

/**
 * 读写锁
 */
class Res{
    private Map<String,String> map = new HashMap<String,String>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key,String value){
        readWriteLock.writeLock().lock();
        try {
            System.out.println(key+"正在存储");
            TimeUnit.MILLISECONDS.sleep(300);
            map.put(key,value);
            System.out.println("存储完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();
        }
    }
    public void get(String key){
        //读不加锁的话 会在写的时候操作
        readWriteLock.readLock().lock();
        try {
            System.out.println("正在读取");
            Object o = map.get(key);
            System.out.println("读取完成"+o);
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}
