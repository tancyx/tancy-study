package com.tancy.dataStruct.array;

import java.util.Arrays;

/**
 * @author tancy
 * 2021/7/12 14:18
 * @description 一个数组元素在 [1, n] 之间，其中一个数被替换为另一个数，找出重复的数和丢失的数
 */
public class SetMismatch {

    public static void main(String[] args) {

        int[] nums = {2, 1, 4, 2};

        System.out.println(Arrays.toString(find(nums)));

    }


    private static int[] find(int[] nums) {
        int more = 0, mis = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == nums[num - 1] && i != num - 1) {
                more = num;
                mis = i + 1;
                continue;
            }
            swap(nums, i, num - 1);
        }
        System.out.println(Arrays.toString(nums));
        return new int[]{more, mis};
    }



    private static void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

}
