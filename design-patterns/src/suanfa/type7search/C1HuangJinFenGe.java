package suanfa.type7search;

import java.util.Arrays;

/**
 * @ClassName: C1HuangJinFenGe
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/25 15:06
 */
public class C1HuangJinFenGe {
    public static void main(String[] args) {
        int maxSize = 20;

        int[]  arr = {1,2,3,4,5,6,7,8,9,33,100};
        System.out.println(fibSearch(arr, 33));
    }
    //创建一个斐波那契数组
    public static int[] fib(int maxSize){
        int[] f = new int [maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2 ; i<f.length;i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f;
    }
    public static int fibSearch(int[] arr ,int key){
        int low = 0;
        int high = arr.length-1;
        int mid = 0;
        int k = 0;//表示斐波那契数值的下标
        int fib[] = fib(20);//获取
        //获得斐波那契分割数值的下标
        while (high > fib[k] - 1){
            k++;
        }
        //
        int[] temp = Arrays.copyOf(arr,fib[k]);
        for (int i = high+1;i<temp.length;i++){
            temp[i] = temp[high];
        }
        //
        while (low <= high){
            mid = low + temp[k-1] -1;
            if(key < temp[mid]){
                high = mid - 1 ;
                k--;
            }else if(key > temp[mid]){
                low = mid + 1;
                k-=2;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
