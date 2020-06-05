package com.jvm;


class Oc{
    //volatile  当num值改变时 会通知 到使用改变量的其他线程
    volatile int num = 10 ;

    public void up(){
        this.num = 105;
    }
}
/**
 * @ClassName: Vat
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/4/29 21:47
 * JMM（java内存模型 Java memory model）本身是一种抽象概念并不真实存在，它描述的是一组规则和规范
 * 通过这种规范 定义了程序中各个变量的访问方式
 *   jmm 同步规定
 *      1、线程结束前，必须吧共享变量的值刷新回主内存
 *      2、线程加锁前，必须读取主内存的最新值到自己的工作内存
 *      3、加锁解锁是同一把锁
 *      jvm 会为每一个线程分配工作内存（有些地方称为栈空间）工作内存私有
 */
public class Vat {
    public static void main(String[] args) {
        Oc oc = new Oc();
        //开启一个线程 A
        new Thread(()->{
            try {
                Thread.sleep(300);
                oc.up(); //将Oc对象中的num值修改
                System.out.println(Thread.currentThread().getName()+":"+oc.num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();

        //此时 main线程不会收到 A线程修改的num值 所以跳不出循环
        //用volatile关键子修饰 num成员变量 就会同步数据
       while (oc.num == 10){

        }
        System.out.println(Thread.currentThread().getName()+":"+oc.num);
    }
}

