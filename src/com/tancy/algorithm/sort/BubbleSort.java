package com.tancy.algorithm.sort;

import java.util.Arrays;

/**
 * @author tancy
 * 2021/6/9 15:31
 * @description 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {5, 4, 2, 1, 3};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 从左到右不断交换相邻逆序的元素，在一轮的循环之后，可以让未排序的最大元素上浮到右侧。
     * @param nums
     */
    private static void bubbleSort(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] nums, int index1, int index2) {
        int tmp;
        tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }
}
