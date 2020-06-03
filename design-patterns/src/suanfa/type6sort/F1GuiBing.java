package suanfa.type6sort;

import java.util.Arrays;

/**
 * @ClassName: F1GuiBing
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/20 23:08
 */
public class F1GuiBing {
    public static void main(String[] args) {
//        int[] arr = {8,4,5,7,1,3,6,2};
//        int[] temp = new int[arr.length];
//        mergedSort(arr,0,arr.length-1,temp);
//        System.out.println(Arrays.toString(arr));
        int[] a = new int[80000];
        int[] temp = new int[a.length];
        for (int i = 0;i<80000;i++){
            a[i] = (int) (Math.random()*8000000);
        }
        System.out.println("开始");
        long begin = System.currentTimeMillis();
        mergedSort(a,0,a.length-1,temp);  //10ms左右

        long end = System.currentTimeMillis();
        System.out.println((end-begin)+"ms");
        System.out.println("结束");
    }
    public static void mergedSort(int[] arr,int left,int right,int[] temp){
        if(left<right){
            int mid = (left+right)/2;
            //向左递归 进行分解
            mergedSort(arr,left,mid,temp);
            //向右递归 进行分解
            mergedSort(arr,mid+1,right,temp);
            //合并
            merged(arr,left,mid,right,temp);
        }
    }
    /**
     * @param arr 原始数组
     * @param left 左边有序序列索引
     * @param mid  中间索引
     * @param right 右边索引
     * @param temp 中间数组
     */
    public static void merged(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;//变有序序列的初始索引
        int j = mid+1; //初始化j,表示右边有序序列的初始索引
        int t = 0;//指向temp的辅助索引 (当前)
        /*  1、
            先把左右两边(有序)的数据按照规则填充到temp数组
            知道左右两边有序序列 ， 有一方处理完毕
        */
        while (i <= mid && j<=right){
            if(arr[i] <= arr[j]){ //左边数据小于右边数据
                temp[t] = arr[i];
                t +=1;
                i +=1;
            }else {
                temp[t] = arr[j]; //右边边数据小于左边数据
                t +=1;
                j +=1;
            }
        }
        //2、将剩余数据的一边 全部放在temp
        while (i<=mid){
            temp[t] = arr[i]; //右边数据先空  将左边数据 一次加入temp
            t +=1;
            i +=1;
        }
        while (j<=right){
            temp[t] = arr[j]; //左边数据先空  将右边数据 一次加入temp
            t +=1;
            j +=1;
        }
        //3、 将temp拷贝到arr
        t=0; //将辅助指针 指向第一个位置
        int tempLeft = left; //创建辅助指针 指向原数组第一个位置
        while (tempLeft<=right){
            arr[tempLeft] = temp[t]; //进行copy
            tempLeft += 1;
            t += 1;
        }
    }
}
