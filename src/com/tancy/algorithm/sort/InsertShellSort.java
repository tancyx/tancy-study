package com.tancy.algorithm.sort;

import java.util.Arrays;

/**
 * @author tancy
 * 2021/6/9 16:32
 * @description 希尔排序（插入排序的优化）
 */
public class InsertShellSort {

    public static void main(String[] args) {
        int[] nums = {5, 11, 7, 9, 2, 3, 12, 8, 6, 1, 4, 10};
        System.out.println(Arrays.toString(nums));
        shellSort(nums);
    }


    /**
     * 对于大规模的数组，插入排序很慢，因为它只能交换相邻的元素，每次只能将逆序数量减少 1。
     * 希尔排序的出现就是为了解决插入排序的这种局限性，它通过交换不相邻的元素，每次可以将逆序数量减少大于 1。
     *
     * 希尔排序使用插入排序对间隔 h 的序列进行排序。通过不断减小 h，最后令 h=1，就可以使得整个数组是有序的。
     * @param nums
     */
    private static void shellSort(int[] nums) {
        int h = 1;
        while (h < nums.length / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < nums.length; i++) {
                for (int j = i; j >= h ; j-=h) {
                    if (nums[j - h] > nums[j]) {
                        swap(nums, j, j - h);
                        System.out.println(Arrays.toString(nums));
                    } else {
                        break;
                    }
                }
            }
            System.out.println("====================" + h);
            h = h / 3;
        }

    }


    private static void swap(int[] nums, int index1, int index2) {
        int tmp;
        tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }
}
