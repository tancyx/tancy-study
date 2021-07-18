package com.tancy.algorithm.binarySearch;

/**
 * @author tancy
 * 2021/6/28 9:35
 * @description 有序数组的单元素
 */
public class SingleElement {

    public static void main(String[] args) {

        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};

        System.out.println(findSingleElement(nums));

    }


    /**
     * 一个有序数组只有一个数不出现两次，找出这个数。
     * @param nums
     * @return
     */
    private static int findSingleElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 1) {
                mid--; // 保证 left/right/mid 都在偶数位，使得查找区间大小一直都是奇数
            }
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }
        return nums[right];
    }

}
