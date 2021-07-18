package com.tancy.algorithm.dpointer;

import java.util.Arrays;

/**
 * @author tancy
 * 2021/6/8 14:23
 * @description 归并两个有序数组
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] num1 = {1, 2, 3, 0, 0, 0}, num2 = {2, 5, 6};
        mergeSortedArray(num1, 3, num2, 3);
    }


    /**
     * 把归并结果存到第一个数组上。
     * @param nums1
     * @param nums2
     */
    private static void mergeSortedArray(int[] nums1, int len1, int[] nums2, int len2) {
        int index1 = len1 - 1, index2 = len2 - 1, cursor = nums1.length - 1;
        while (index2 >= 0) {
            if (index1 < 0) {
                nums1[cursor--] = nums2[index2--];
            } else if (nums1[index1] >= nums2[index2]) {
                nums1[cursor--] = nums1[index1--];
            } else {
                nums1[cursor--] = nums2[index2--];
            }
        }
        System.out.println(Arrays.toString(nums1));
    }


    /**
     * 把归并结果存到第三个数组上。
     * @param nums1
     * @param nums2
     */
    private static void mergeSortedArrayMiddle(int[] nums1, int[] nums2) {
        int index1 = 0, index2 = 0, mergeIndex = 0;
        int[] merges = new int[nums1.length + nums2.length];
        while (mergeIndex < merges.length) {
            if (index1 >= nums1.length) {
                merges[mergeIndex++] = nums2[index2++];
                continue;
            }
            if (index2 >= nums2.length) {
                merges[mergeIndex++] = nums1[index1++];
                continue;
            }
            if (nums1[index1] == nums2[index2]) {
                merges[mergeIndex++] = nums1[index1++];
                merges[mergeIndex++] = nums2[index2++];
                continue;
            }
            if (nums1[index1] < nums2[index2]) {
                merges[mergeIndex++] = nums1[index1++];
                continue;
            }
            if (nums1[index1] > nums2[index2]) {
                merges[mergeIndex++] = nums2[index2++];
                continue;
            }
        }
        System.out.println(Arrays.toString(merges));
    }
}
