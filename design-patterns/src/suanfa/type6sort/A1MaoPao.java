package suanfa.type6sort;

import java.util.Arrays;

/**
 * @ClassName: A1MaoPao
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/20 13:18
 */
public class A1MaoPao {
    public static void main(String[] args) throws InterruptedException {


        int[] a = new int[80000];
        for (int i = 0;i<80000;i++){
            a[i] = (int) (Math.random()*8000000);
        }
        System.out.println("开始");
        long begin = System.currentTimeMillis();

        bubbleSort(a); //10000ms左右  10s

        long end = System.currentTimeMillis();
        System.out.println((end-begin)+"ms");
        System.out.println("结束");
    }
    //冒泡排序
    public static void bubbleSort(int[] a){
        int temp;
        //一共进行数组的大小-1次大的循环
        //每一趟排序的次数逐渐的减少
        //如何发现在某趟排序中，没有发生交换 ，可以提前结束  优化
        boolean flag; //优化点
        for (int i = 0 ; i<a.length-1;i++){
            flag = true;
            for (int j = 0 ; j<a.length - i - 1;j++){
                if(a[j] > a[j+1]){
                    flag = false;
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
            if(flag){
                break;
            }
        }
    }
}
