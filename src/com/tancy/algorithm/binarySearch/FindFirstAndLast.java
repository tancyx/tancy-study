package com.tancy.algorithm.binarySearch;

import java.util.Arrays;

/**
 * @author tancy
 * 2021/6/28 13:35
 * @description 给定一个有序数组 nums 和一个目标 target，要求找到 target 在 nums 中的第一个位置和最后一个位置。
 */
public class FindFirstAndLast {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 8, 8, 10};
        System.out.println(Arrays.toString(find(nums, 8)));

    }


    private static int[] find(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int first = findFirst(nums, left, right, target);
        int last = findLast(nums, left, right, target);
        return new int[]{first, last};
    }


    private static int findFirst(int nums[], int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target <= nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[right] == target ? right : -1;
    }


    private static int findLast(int nums[], int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2 + 1;
            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }
}
