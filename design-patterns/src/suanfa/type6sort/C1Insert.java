package suanfa.type6sort;

import java.util.Arrays;

/**
 * @ClassName: C1Insert
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/20 18:02
 */
public class C1Insert {
    public static void main(String[] args) {

        int[] a = new int[80000];

        for (int i = 0;i<80000;i++){
            a[i] = (int) (Math.random()*8000000);
        }
        System.out.println("开始");
        long begin = System.currentTimeMillis();

        sort(a); //600ms左右

        long end = System.currentTimeMillis();
        System.out.println((end-begin)+"ms");
        System.out.println("结束");
    }
    /*
        插入排序
     */
    public static void sort(int[] arr){
        int insertVal ;
        int insIndex ;
        for (int i=1;i<arr.length;i++){
            insertVal= arr[i];//记录 当前下标的值（要插入的值）
            insIndex = i-1;   //记录 前一个值得下标
            //如判断 前一个值下表是否大于=0 &&  当前下标的值 小于 前一个值  就将当前值 = 前一个值  下标在向前移
            while (insIndex >= 0 && insertVal < arr[insIndex] ){
                arr[insIndex+1] = arr[insIndex];
                insIndex--;
            }
            //出循环时 insIndex为要插入位置的前一个 这里要++
            //让 当前的值 = 之前保存的要插入的值
            arr[insIndex+1] = insertVal;
        }
    }
}
