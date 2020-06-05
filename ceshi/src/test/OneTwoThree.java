package test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: OneTwoThree
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/4 11:28
 */
class Foo{
    CountDownLatch countDownLatch = new CountDownLatch(1);
    CountDownLatch countDownLatch1 = new CountDownLatch(1);

    public void one(){
        System.out.println("one");
        countDownLatch.countDown();
    }
    public void two(){
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("two");
        countDownLatch1.countDown();
    }
    public void three(){
        try {
            countDownLatch1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("three");
    }
}
public class OneTwoThree {
    public static void main(String[] args) {
        Foo foo = new Foo();
        
        new Thread(foo::three,"A").start();
        new Thread(foo::two,"B").start();
        new Thread(foo::one,"C").start();

    }
}
