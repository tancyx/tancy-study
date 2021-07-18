package com.tancy.algorithm.sort;

import com.tancy.dataStruct.tree.BinaryTreeNode;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author tancy
 * 2021/6/17 9:04
 * @description description
 */
public class Test {

    public static void main(String[] args) {
        int[] nums = {3, 5, 1, 5, 6, 5, 2, 5, 5, 8, 5, 4, 5, 7, 5};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

    }


    private static void quickSort(int[] nums, int left, int right) {
        if (right <= left) return;
        int p = partition(nums, left, right);
        quickSort(nums, left, p - 1);
        quickSort(nums, p + 1, right);
    }

    private static int partition(int[] nums, int left, int right) {
        int lindex = left, rindex = right + 1;
        int select = nums[left];
        while (true) {
            while (nums[++lindex]< select && lindex < right);
            while (nums[--rindex] >= select && rindex > left);
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

}
