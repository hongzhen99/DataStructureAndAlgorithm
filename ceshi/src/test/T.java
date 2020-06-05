package test;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName: T
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/10 20:37
 */
public class T {
    public static void main(String[] args) {
        int[] arr = {1,3 ,6, 4, 5,2};
        sort(arr);
        for(int n:arr)
            System.out.printf("%d ",n);
    }
    public static void sort(int[] arr){
        Sleeper.index = 0;
        for (int i = 0;i<arr.length; i++){
            new Sleeper(arr[i],arr.length).start();
        }
        try {
            Sleeper.countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0;i<arr.length; i++){
            arr[i]=Sleeper.output[i];
        }

    }
}
class Sleeper extends Thread{
    public static int[] output;
    public static int index;
    public int sleepTime;
    public static CountDownLatch countDownLatch;
    public Sleeper(int sleepTime,int length){
        this.sleepTime = sleepTime;
        output = new int[length];
        countDownLatch = new CountDownLatch(length);
    }
    @Override
    public void run() {
        try {
            Sleeper.sleep(this.sleepTime*100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        output[index++] = this.sleepTime;
        countDownLatch.countDown();

    }
}
