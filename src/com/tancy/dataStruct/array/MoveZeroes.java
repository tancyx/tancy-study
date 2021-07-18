package com.tancy.dataStruct.array;

import java.util.Arrays;

/**
 * @author tancy
 * 2021/7/12 10:57
 * @description 把数组中的 0 移到末尾
 */
public class MoveZeroes {


    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        move(nums);
        System.out.println(Arrays.toString(nums));

        int[] nums1 = {0, 1, 0, 3, 12};
        moveZeroes(nums1);
        System.out.println(Arrays.toString(nums1));
    }


    private static void move(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] == 0) {
                for (int i = left; i < right; i++) {
                    swap(nums, i, i + 1);
                }
                right--;
            }
            left++;
        }
    }


    private static void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;

    }

    public static void moveZeroes(int[] nums) {
        int idx = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[idx++] = num;
            }
        }
        while (idx < nums.length) {
            nums[idx++] = 0;
        }
    }

}
