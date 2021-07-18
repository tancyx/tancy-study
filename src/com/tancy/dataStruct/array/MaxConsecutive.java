package com.tancy.dataStruct.array;

/**
 * @author tancy
 * 2021/7/12 13:56
 * @description 找出数组中最长的连续 1
 */
public class MaxConsecutive {

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println(find(nums));

    }


    private static int find(int[] nums) {
        int pre = 0, cur = 0;
        for (int num : nums) {
            if (num == 1) {
                cur++;
            } else {
                pre = Math.max(pre, cur);
                cur = 0;
            }
        }
        return Math.max(pre, cur);
    }

}
