package com.juc;

/**
 * @ClassName: BlockingQueueDemo
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/2 15:46
 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞队列
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(3);
        //blockingQueue.add("1")
//        System.out.println(blockingQueue.add("1"));
//        System.out.println(blockingQueue.add("2"));
//        System.out.println(blockingQueue.add("3"));
//        System.out.println(blockingQueue.add("4"));//当队列满时 抛出异常
        //blockingQueue.remove()
//        System.out.println(blockingQueue.remove());//当队列无值时 抛出异常

//        System.out.println(blockingQueue.offer("1"));
//        System.out.println(blockingQueue.offer("2"));
//        System.out.println(blockingQueue.offer("3"));
//        System.out.println(blockingQueue.offer("4"));//当队列满时返回false
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());//当队列无值时 返回null

        /*blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
//        blockingQueue.put("d");//当队列满时 等待
//        TimeUnit.SECONDS.sleep(1);
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
//        System.out.println(blockingQueue.take());//当队列空时 等待 阻塞*/

        System.out.println(blockingQueue.offer("e"));
        System.out.println(blockingQueue.offer("e"));
        System.out.println(blockingQueue.offer("e"));
        System.out.println(blockingQueue.offer("e",3l,TimeUnit.SECONDS));//当队列满时 超市后取消当前操作
    }
}
