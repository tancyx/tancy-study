package com.tancy.algorithm.sort;

import java.util.Arrays;

/**
 * @author tancy
 * 2021/6/9 18:48
 * @description 归并排序
 */
public class MergeSort {

    private static int[] tmp;

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 6, 9, 5, 4, 8, 7};
//        nums = new int[]{1, 2, 3, 6, 4, 5, 7, 8, 9};

        tmp = new int[nums.length];

//        merge(nums, 0, 4, 8);

//        up2DownSort(nums, 0, nums.length - 1);

        down2UpSort(nums);

        System.out.println(Arrays.toString(nums));

    }

    /**
     * 合并2部分有序的数组
     *
     * @param nums
     * @param left  数组左起始位置
     * @param mid   数组中间元素位置，要求：left 到 mid-1 为左半部分有序，mid 到 right 为右半部分有序
     * @param right 数组右结束位置
     */
    private static void merge(int[] nums, int left, int mid, int right) {
        int lindex = mid - 1, rindex = right, cursor = right;
        for (int i = mid; i <= right; i++) {
            tmp[i] = nums[i];
        }
        while (rindex >= mid) {
            if (lindex < left) {
                nums[cursor--] = tmp[rindex--];
            } else if (nums[lindex] >= tmp[rindex]) {
                nums[cursor--] = nums[lindex--];
            } else {
                nums[cursor--] = tmp[rindex--];
            }
        }
    }

    /**
     * 自顶向下归并排序
     * @param nums
     * @param left
     * @param right
     */
    private static void up2DownSort(int[] nums, int left, int right) {
        if (Math.abs(left - right) > 0) {
            int mid = (1 + right - left) / 2 + left;
            up2DownSort(nums, left, mid - 1);
            up2DownSort(nums, mid, right);
            merge(nums, left, mid, right);
        }
    }

    /**
     * 自底向上归并排序
     * @param nums
     */
    private static void down2UpSort(int[] nums) {
        for (int size = 1; size < nums.length; size += size) {
            for (int i = 0; i < nums.length - size; i += size + size) {
                merge(nums, i, i + size, Math.min(i + size + size - 1, nums.length - 1));
                System.out.println(Arrays.toString(nums));
            }
        }
    }

    private static void mergex(int[] nums, int l, int m, int h) {
        int i = l, j = m + 1;

        for (int k = l; k <= h; k++) {
            tmp[k] = nums[k]; // 将数据复制到辅助数组
        }

        for (int k = l; k <= h; k++) {
            if (i > m) {
                nums[k] = tmp[j++];

            } else if (j > h) {
                nums[k] = tmp[i++];

            } else if (tmp[i] <= tmp[j]) {
                nums[k] = tmp[i++]; // 先进行这一步，保证稳定性

            } else {
                nums[k] = tmp[j++];
            }
        }
    }

    private static void swap(int[] nums, int index1, int index2) {
        if (index1 != index2) {
            int tmp;
            tmp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = tmp;
        }
    }
}
