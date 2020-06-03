package suanfa.type6sort;

import java.util.Arrays;

/**
 * @ClassName: D1Shell
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/20 18:54
 */
public class D1Shell {
    public static void main(String[] args) {
//        int[] a = {2,3,50,100,13,6,5,0,1};
//        shellInsertSort(a);
//        System.out.println(Arrays.toString(a));

        int[] a = new int[80000];

        for (int i = 0;i<80000;i++){
            a[i] = (int) (Math.random()*8000000);
        }
        System.out.println("开始");
        long begin = System.currentTimeMillis();
//        shellSort(a); //5600ms左右
        shellInsertSort(a); //16ms左右

        long end = System.currentTimeMillis();
        System.out.println((end-begin)+"ms");
        System.out.println("结束");
    }
    //希尔交换法
    public static void shellSort(int[] arr){
        int temp = 0;
        for (int gap = arr.length/2; gap>0; gap/=2){
            //10个数据 第一次分组  arr.length/2   第二次分组 arr.length/(2*2)  知道 gap/2 = 0时结束  gap=1
            for (int i = gap; i < arr.length; i++){
                //第一次5分组 每组2个数据 相差 5     第二次2分组 每组5个数据 相差 2   第三次1组  10个数据  相差1
                for (int j = i - gap; j >= 0; j -= gap ){//每一次将最大的放在后面
                    if(arr[j] > arr[j+gap]){
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }
        }
    }
    //希尔一位法
    public static void shellInsertSort(int[] arr){
        for (int gap = arr.length/2; gap>0; gap/=2){
            //10个数据 第一次分组  arr.length/2   第二次分组 arr.length/(2*2)  知道 gap/2 = 0时结束  gap=1
            for (int i = gap; i < arr.length; i++){
                int index = i; //记录当前值的下标
                int insertVal = arr[index];//记录 要插入的值
                //判断 前一个值下表是否大于=0 &&  要插入的值 小于 前一个值 就将当前值 = 前一个值  下标在向前移 gap个
                while (index - gap >= 0 && insertVal < arr[index - gap]){
                    arr[index] = arr[index - gap];
                    index -= gap;
                }
                //这里的index就是 要插入值的下标  当index == i时说明  该数的位置不用动
                if(index != i){
                    arr[index] = insertVal;
                }
            }
        }
    }
}
