package com.tancy.dataStruct.array;

/**
 * @author tancy
 * 2021/7/17 19:10
 * @description 分隔数组
 */
public class MaxChunksMakeSorted {

    public static void main(String[] args) {

        int[] nums = {1, 0, 2, 3, 4};

        System.out.println("special:" + splitSpecial(nums));


        System.out.println("normal:" + split(nums));

    }


    /**
     * 题目描述：分隔数组，使得对每部分排序后数组就为有序。
     * 特殊情况算法
     * @param nums
     * @return
     */
    private static int splitSpecial(int[] nums) {
        int max = nums[0], count = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (max == i) {
                count++;
            }
        }
        return count;
    }

    /**
     * 一般情况算法
     * @param nums
     * @return
     */
    private static int split(int[] nums) {
        int max = nums[0], count = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            int min = nums[nums.length - 1];
            for (int j = nums.length - 1; j > i; j--) {
                min = Math.min(min, nums[j]);
            }
            if (min >= max) {
                count++;
            }
        }
        return count;
    }

}
