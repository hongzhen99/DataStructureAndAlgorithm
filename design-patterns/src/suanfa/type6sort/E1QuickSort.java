package suanfa.type6sort;

import java.util.Arrays;

/**
 * @ClassName: E1QuickSort
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/20 21:04
 */
public class E1QuickSort {
    public static void main(String[] args) {
//        int[] arr = new int[] {9,4,6,8,5,10,3,24,3423,523};
//        quickSortMy(arr,0,arr.length - 1);
//        System.out.println(Arrays.toString(arr));

        int[] a = new int[80000];

        for (int i = 0;i<80000;i++){
            a[i] = (int) (Math.random()*8000000);
        }
        System.out.println("开始");
        long begin = System.currentTimeMillis();
        quickSort(a,0,a.length-1); //14ms左右

        long end = System.currentTimeMillis();
        System.out.println((end-begin)+"ms");
        System.out.println("结束");
    }
    public static void quickSortMy(int[] arr,int low,int high){
        int center; //基数
        int left; //最左边
        int right;//最右边
        int temp;  //用于交换值
        //结束条件  说明传进来的low 与 high 值相等  说明 就剩一个数
        if(low >= high){
            return;
        }
        //已第一个数位准  作为基数 /3  0  4
        center = arr[low];
        left = low;
        right = high;
        //当 left 不小于 right 时 说明找到中间 基数所在的下标
        while (left < right){
            //判断最右边的值 如果小于等于基数 则跳出循环
            while (arr[right] >= center && left < right){
                right--;
            }
            //判断最左边的值 如果大于等于基数 则跳出循环
            while (arr[left] <= center && left < right){
                left++;
            }
            if(left < right){
                //进行交换值  将右边小于基数的值  与 左边大于基数的值 交换位置
                temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
            }

        }
        arr[low] = arr[left]; //将基数的位置 与  基数应该在的位置 互换
        arr[left] = center;
        //一次排序就好了
        //进行递归排序

        //向左递归
        System.out.println(Arrays.toString(arr));
        quickSortMy(arr,low,right-1);//0 4
        //向右递归
        quickSortMy(arr,low+1,high);
    }



    public static void quickSort(int[] arr,int low,int high){
        int benchmark,left,right,temp;
        //递归终止条件
        if(low >= high) {
            return;
        }
        //benchmark就是基准数,这里就是每个数组的第一个
        benchmark = arr[low];
        left = low; //最左边
        right = high;//最右边
        while(left < right) {
            //右边当发现小于 基准数 时停止循环
            while(arr[right] >= benchmark && left < right) {
                right--;
            }
            //这里一定是右边开始，上下这两个循环不能调换（下面有解析，可以先想想）
            //左边当发现大于p的值时停止循环
            while(arr[left] <= benchmark && left < right) {
                left++;
            }
            temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
        }
        arr[low] = arr[left];//这里的arr[i]一定是停小于p的，经过i、j交换后i处的值一定是小于p的(j先走)
        arr[left] = benchmark;
        quickSort(arr,low,right-1);  //对左边快排
        quickSort(arr,right+1,high); //对右边快排
    }
}
