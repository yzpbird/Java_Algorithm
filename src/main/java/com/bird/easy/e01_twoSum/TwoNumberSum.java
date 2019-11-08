package com.bird.easy.e01_twoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述：
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出 和 为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoNumberSum {

    public static void main(String[] args) {

        //测试
        int[] nums = new int[]{2, 7, 11, 15};
//        int[] nums = new int[]{6,2, 2, 3, 4,5};
        int target = 9;
        int[] result = twoSum3(nums, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }


    /**
     * 暴力解法：两层for循环
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1;j < nums.length; j++){
                if (nums[j] == target - nums[i]){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    /**
     * 解法二：使用HashMap，两次循环
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        //先循环数组，将数组的值作为key,下标作为value
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        //再循环数组，用target-循环的值，去hashMap里找有没有存在的key
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }



    /**
     * 解法三：使用HashMap，一次循环
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        //循环数组，用target-循环的值，去hashMap里找有没有存在的key
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            //添加到map里
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
