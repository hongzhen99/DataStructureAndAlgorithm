package suanfa.type6sort;

import java.util.Arrays;

/**
 * @ClassName: E1jIShu
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/23 15:12
 */
public class G1jIShu {
    public static void main(String[] args) {
//        int[] arr  = {53,3,542,748,14,214};
//        sort(arr);
        int[] arr = new int[80000];
        for (int i = 0;i<80000;i++){
            arr[i] = (int) (Math.random()*8000000);
        }
        System.out.println("开始");
        long begin = System.currentTimeMillis();

        sort(arr);  //8万 60ms左右        //8百万  800ms左右

        long end = System.currentTimeMillis();
        System.out.println((end-begin)+"ms");
        System.out.println("结束");
    }
    public static void sort(int[] arr){
        //1、得到arr的最大位数
        int max = arr[0];
        for(int i = 1;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        int maxLength = String.valueOf(max).length();//得到最大位数
        //2、定义一个二维数组 包含10个一维数组
        //防止存放数时 数据溢出 每一个一维数组，大小定义为arr.length
        //基数排序 空间换时间的经典算法
        int[][] tong = new int[10][arr.length];
        //3、创建一个计数器 用来记录桶里存放的个数
        int[] counts = new int[10];
        //4、开始排序 根据 最大位数 来定循环 轮数
        for(int i = 0,n = 1;i < maxLength;i++,n *=10){
            //第i+1轮针对各位进行排序
            for(int j = 0;j<arr.length;j++){
                //取出个位 表示第几个桶
                int digitOfElement = (arr[j]/n) % 10;
                //tong[a][b]  a代表第几个桶 b代表第几个数 counts[digitOfElement]
                tong[digitOfElement][counts[digitOfElement]] = arr[j];
                counts[digitOfElement]++;
            }
            //将桶里的元素放回原数组
            int index = 0;
            //遍历10个桶
            for (int k = 0;k < counts.length ;k++ ){
                //如果桶里面有数 就放入原数组
                if(counts[k] != 0){
                    for (int l = 0; l<counts[k];l++){
                        arr[index++] = tong[k][l];
                    }
                    //没经过i轮  将这个桶计数器清空
                    counts[k] = 0;
                }
            }
//            System.out.println("第"+(i+1)+"次arr= "+ Arrays.toString(arr));
        }
    }
    //整合第一次
    public static void sortFirst(int[] arr){
        //定义一个二维数组 包含10个一维数组
        //防止存放数时 数据溢出 每一个一维数组，大小定义为arr.length
        //基数排序 空间换时间的经典算法
        int[][] tong = new int[10][arr.length];
        //创建一个计数器 用来记录桶里存放的个数
        int[] counts = new int[10];

        //第一轮针对各位进行排序
        for(int j = 0;j<arr.length;j++){
            //取出个位 表示第几个桶
            int digitOfElement = (arr[j]/1) % 10;
            //tong[a][b]  a代表第几个桶 b代表第几个数 counts[digitOfElement]
            tong[digitOfElement][counts[digitOfElement]] = arr[j];
            counts[digitOfElement]++;
        }
        //将桶里的元素放回原数组
        int index = 0;
        //遍历10个桶
        for (int k = 0;k < counts.length ;k++ ){
            //如果桶里面有数 就放入原数组
            if(counts[k] != 0){
                for (int l = 0; l<counts[k];l++){
                    arr[index++] = tong[k][l];
                }
                //没经过一轮  将这个桶计数器清空
                counts[k] = 0;
            }
        }
        System.out.println("第一次arr= "+ Arrays.toString(arr));

    }
}
