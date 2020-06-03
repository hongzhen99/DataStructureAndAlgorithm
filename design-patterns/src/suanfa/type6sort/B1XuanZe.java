package suanfa.type6sort;

import java.util.Arrays;

/**
 * @ClassName: B1XuanZe
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/20 15:50
 */
public class B1XuanZe {
    public static void main(String[] args) {
        int[] a = new int[80000];
        for (int i = 0;i<80000;i++){
            a[i] = (int) (Math.random()*8000000);
        }
        System.out.println("开始");
        long begin = System.currentTimeMillis();

        sort(a); //2400ms左右

        long end = System.currentTimeMillis();
        System.out.println((end-begin)+"ms");
        System.out.println("结束");
    }
    // 2,3,1,5,4,6      2     1,3,1,5,4,6

    //选择排序
    //每一次都选择出一个最小值  与最前面的第i个替换进行替换
    public static void sort(int[] arr){
        for (int i=0;i<arr.length-1;i++){
            int minIndex = i; //记录第i个的下表
            int min = arr[minIndex];//记录第i个的下表的值
            //该循环是 选出最小值
            for (int j=i;j<arr.length-1;j++){
                if(min > arr[j+1]){
                    minIndex = j+1;
                    min = arr[j+1];
                }
            }
            //得到最小值后 和之前保存的值替换
            if(minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
