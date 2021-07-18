package com.tancy.algorithm.binarySearch;

/**
 * @author tancy
 * 2021/6/27 11:00
 * @description 二分查找也称为折半查找，每次都能将查找区间减半，这种折半特性的算法时间复杂度为 O(logN)。
 */
public class Main {


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(binarySearch(nums, 5));

        int[] numsRpeat = {1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 5};
        System.out.println(binarySearchRepeat(numsRpeat, 3));
    }

    /**
     * 有两种计算中值 m 的方式：
     *
     * mid = (left + right) / 2
     * mid = left + (right - left) / 2
     * l + h 可能出现加法溢出，也就是说加法的结果大于整型能够表示的范围。
     * 但是 l 和 h 都为正数，因此 h - l 不会出现加法溢出问题。所以，最好使用第二种计算法方法。
     * @param nums
     * @param k
     * @return
     */
    private static int binarySearch(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (k > nums[mid]) {
                left = mid + 1;
            } else if (k < nums[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    /**
     * 一个有重复元素的数组中查找 k 的最左位置
     * @param nums
     * @param k
     * @return
     */
    private static int binarySearchRepeat(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (k <= nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
