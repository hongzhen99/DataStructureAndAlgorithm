package suanfa.type9tree;

import java.util.Arrays;

/**
 * @ClassName: D1HeapSort
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/27 20:21
 */
public class D1HeapSort {
    public static void main(String[] args) {
//        int[] arr = {4,6,8,5,9};
//        heapSort(arr);
        int[] a = new int[80000000];
        for (int i = 0;i<80000000;i++){
            a[i] = (int) (Math.random()*8000000);
        }
        System.out.println("开始");
        long begin = System.currentTimeMillis();

        heapSort(a); //80万 150ms  800万 1.9s  8000万 36s

        long end = System.currentTimeMillis();
        System.out.println((end-begin)+"ms");
        System.out.println("结束");
    }
    //堆排序
    public static void heapSort(int[] arr){
        System.out.println("这是堆排序");
//        bigHeap(arr,1,arr.length);
//        System.out.println(Arrays.toString(arr));
//
//        bigHeap(arr,0,arr.length);
//        System.out.println(Arrays.toString(arr));
        //将整个数组 排成 大顶堆  //arr.length/2 -1最多非叶子节点个数
        for (int i = arr.length/2 -1 ;i>=0 ; i--){
            bigHeap(arr,i,arr.length);
        }
//        System.out.println(Arrays.toString(arr));
        for (int j = arr.length-1; j >= 0; j--) {
            //每次将第0个元素与最有一个交换
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            //再次将最大值放入第一个
            bigHeap(arr,0,j);
        }
//        System.out.println(Arrays.toString(arr));
    }
    //i表示非叶子节点的索引   length对多少个元素进行调整
    public static void bigHeap(int[] arr,int i,int length){
        int temp = arr[i];
        for (int k = i*2+1 ;k < length;k = k*2+1) {
            if ( k+1 < length && arr[k] < arr[k+1]) {
                k++;
            }
            if (arr[k] > temp){
                arr[i] = arr[k]; //吧较大的值赋给当前节点
                i = k; //将i 指向k 继续比较
            } else {
                break;
            }
        }
        //当for循环结束后
        arr[i] = temp;
    }
}
