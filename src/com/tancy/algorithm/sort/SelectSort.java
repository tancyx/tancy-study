package com.tancy.algorithm.sort;

import java.util.Arrays;

/**
 * @author tancy
 * 2021/6/9 14:28
 * @description 选择排序
 */
public class SelectSort {


    public static void main(String[] args) {
        int[] nums = {5, 4, 2, 1, 3};
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 从数组中选择最小元素，将它与数组的第一个元素交换位置。
     * 再从数组剩下的元素中选择出最小的元素，将它与数组的第二个元素交换位置。
     * 不断进行这样的操作，直到将整个数组排序。
     * @param nums
     */
    private static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (compare(nums[minIndex], nums[j]) > 0) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
    }

    private static int compare(int num1, int num2) {
        return Integer.compare(num1, num2);
    }

    private static void swap(int[] nums, int index1, int index2) {
        int tmp;
        tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

}
