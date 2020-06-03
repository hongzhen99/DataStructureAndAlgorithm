package suanfa.type7search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: B1ChaZhi
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/25 14:20
 */
public class B1ChaZhi {
    public static void main(String[] args) {
        //来一个有序数组
        int arr[] = {1,8,19,81,82,89,1000,1234};

        int integers = binarySearch(arr, 0, arr.length - 1, 82);
        System.out.println(integers);

    }
    //基本二分查找
    public static int binarySearch(int[] arr,int left,int right,int findValue){
        System.out.println("a");
        //退出条件
        if(left>right || findValue>arr[arr.length-1] || findValue < arr[0] ){
            return -1;
        }
        //获取中间值
//        int mid = (left+right)/2;
        //重新对mid定位
        int mid = left + (right-left) * (findValue-arr[left])/(arr[right]-arr[left]);
        //找到就退出
        if (findValue == arr[mid]){
            return mid;
        }else if (findValue > arr[mid]) {//向右递归
            return binarySearch(arr,mid+1,right,findValue);
        }else { //向左递归
            return binarySearch(arr,left,mid-1,findValue);
        }
    }
    //基本二分查找  返回连续值
    public static List<Integer> binarySearch1(int[] arr, int left, int right, int findValue){
        int mid = (left+right)/2;
        //退出条件
        if(left>right){
            return Arrays.asList(-1);
        }
        //找到就退出
        if (findValue == arr[mid]){
            List<Integer> integers = new ArrayList<>();
            integers.add(mid);
            int temp = mid-1;
            while (true){
                if(temp <0 || arr[temp] != findValue){
                    break;
                }
                integers.add(temp);
                temp -= 1;
            }
            temp = mid+1;
            while (true){
                if(temp > right || arr[temp] != findValue){
                    break;
                }
                integers.add(temp);
                temp += 1;
            }
            return integers;
        }else if (findValue > arr[mid]) {//向右递归
            return binarySearch1(arr,mid+1,right,findValue);
        }else { //向左递归
            return binarySearch1(arr,left,mid-1,findValue);
        }
    }

}
