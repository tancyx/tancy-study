package com.tancy.algorithm.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author tancy
 * 2021/6/12 23:10
 * @description 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        Integer[] nums = {3, 5, 1, 5, 6, 5, 2, 5, 5, 8, 5, 4, 5, 7, 5};
//        shuffle(nums);
//        sort(nums, 0, nums.length - 1);

        threeWaySort(nums, 0, nums.length - 1);
    }


    private static void sort(Integer[] nums, int left, int right) {
        if (right - left <= 0) return;
        int p = partition(nums, left, right);
        // 算法改进：此处为递归，对于切分后的小数组可以使用插入排序
        sort(nums, left, p - 1);
        sort(nums, p + 1, right);
    }

    /**
     * 取 a[l] 作为切分元素，然后从数组的左端向右扫描直到找到第一个大于等于它的元素，再从数组的右端向左扫描找到第一个小于它的元素，交换这两个元素。
     * 不断进行这个过程，就可以保证左指针 i 的左侧元素都不大于切分元素，右指针 j 的右侧元素都不小于切分元素。
     * 当两个指针相遇时，将切分元素 a[l] 和 a[j] 交换位置。
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private static int partition(Integer[] nums, int left, int right) {
        int lindex = left, rindex = right + 1;
        int select = nums[left];
        while (true) {
            while (select > nums[++lindex] && lindex != right) ;
            while (select <= nums[--rindex] && rindex != left) ;
            if (lindex >= rindex) break;
            swap(nums, rindex, lindex);
            System.out.println(Arrays.toString(nums));
        }
        swap(nums, left, rindex);
        System.out.println(Arrays.toString(nums));
        return rindex;
    }


    private static void swap(Integer[] nums, int index1, int index2) {
        if (index1 != index2) {
            int tmp;
            tmp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = tmp;
        }
    }

    private static void shuffle(Integer[] nums) {
        List<Comparable> list = Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);
    }

    /**
     * 对于有大量重复元素的数组，可以将数组切分为三部分，分别对应小于、等于和大于切分元素。
     * “三向切分快速排序”对于有大量重复元素的随机数组可以在线性时间内完成排序。
     *
     * @param nums
     */
    private static void threeWaySort(Integer[] nums, int left, int right) {
        if (right - left <= 0) return;
        int lindex = left + 1, sindex = left, rindex = right;
        int select = nums[left];
        while (lindex <= rindex) {
            if (select > nums[lindex]) {
                swap(nums, sindex++, lindex++);
                System.out.println(Arrays.toString(nums));
            } else if (select < nums[lindex]) {
                swap(nums, lindex, rindex--);
                System.out.println(Arrays.toString(nums));
            } else {
                lindex++;
            }
        }
        threeWaySort(nums, left, sindex - 1);
        threeWaySort(nums, rindex + 1, right);
    }


    /**
     * 找出数组的第 select 个元素
     * @param nums
     * @param select
     * @return
     */
    private static int select(Integer[] nums, int select) {
        int lindex = 0, rindex = nums.length - 1;
        while (lindex < rindex) {
            int p = partition(nums, lindex, rindex);
            if (select > p) {
                lindex = p + 1;
            } else if (select < p) {
                rindex = p - 1;
            } else {
                return nums[p];
            }
        }
        return nums[select];
    }

}
