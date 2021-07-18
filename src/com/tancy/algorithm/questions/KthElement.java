package com.tancy.algorithm.questions;

import java.util.Arrays;

/**
 * @author tancy
 * 2021/6/26 10:36
 * @description description
 */
public class KthElement {


    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int kthElement = findKthElement(nums, 2);
        System.out.println(kthElement);

        int[] colors = {2, 0, 2, 1, 1, 0};
        sortColors(colors);
    }


    /**
     * 题目描述：找到倒数第 k 个的元素。
     * @param nums
     */
    private static int findKthElement(int[] nums, int k) {
        int left = 0, right = nums.length - 1, result = k;
        while (left < right) {
            int partition = partition(nums, left, right);
            if (nums.length - k > partition) {
                left = partition + 1;
            } else if (nums.length - k < partition) {
                right = partition - 1;
            } else {
                result = partition;
                break;
            }
        }
        return nums[result];
    }

    private static int partition(int[] nums, int left, int right) {
        int lindex = left, rindex = right + 1;
        int select = nums[left];
        while (true) {
            while (select > nums[++lindex] && lindex < right) ;
            while (select <= nums[--rindex] && rindex > left) ;
            if (lindex >= rindex) break;
            swap(nums, lindex, rindex);
        }
        swap(nums, left, rindex);
        return rindex;
    }


    private static void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }


    /**
     * 荷兰国旗问题，按颜色进行排序：只有 0/1/2 三种颜色。
     *
     * 荷兰国旗包含三种颜色：红、白、蓝。
     *
     * 有三种颜色的球，算法的目标是将这三种球按颜色顺序正确地排列。
     * 它其实是三向切分快速排序的一种变种，在三向切分快速排序中，每次切分都将数组分成三个区间：小于切分元素、等于切分元素、大于切分元素，而该算法是将数组分成三个区间：等于红色、等于白色、等于蓝色。
     * @param nums
     */
    private static void sortColors(int[] nums) {
        int select = 1, left = 0, mid = left + 1, right = nums.length - 1;
        while (mid < right) {
            if (select > nums[left]) {
                left++;
                mid++;
            } else if (select < nums[left]) {
                swap(nums, left, right--);
            } else {
                swap(nums, left, mid++);
            }
        }
        System.out.println(Arrays.toString(nums));
    }

}
