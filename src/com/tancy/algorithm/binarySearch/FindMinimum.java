package com.tancy.algorithm.binarySearch;

/**
 * @author tancy
 * 2021/6/28 11:31
 * @description 旋转数组的最小数字
 */
public class FindMinimum {

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(findMin(nums));
    }

    private static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

}
