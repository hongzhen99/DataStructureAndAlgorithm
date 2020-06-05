package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: TTT
 * @Description: TODO
 * @Author: TianHongzhen
 * @Date: 2020/5/20 15:27
 */
public class TTT {
    public static void main(String[] args) {
        /*
            给定 nums = [2, 7, 11, 15], target = 9

            因为 nums[0] + nums[1] = 2 + 7 = 9
            所以返回 [0, 1]

         */
        int[] nums = {2, 7, 11, 15};
        int target = 9;

//        int[] ints = find(nums, target);
        int[] ints = twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }
    public static int[] find(int[] nums,int target){
        int[] res = new int[2];
        int index = 0;
        for (int i = 0;i<nums.length;i++){
            index = i;
            for (int j = i+1;j<nums.length;j++){
                if(nums[index] + nums[j] == target){
                    res[0] = index;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }
    /*
        给定 nums = [2, 7, 11, 15], target = 9

     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
