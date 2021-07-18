package com.tancy.algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author tancy
 * 2021/6/26 17:08
 * @description 不重叠的区间个数
 */
public class NonOverlappingIntervals {

    public static void main(String[] args) {

        int[][] nums = {{1, 2}, {3, 4}, {1, 2}, {2, 3}, {2, 5}};


        System.out.println(removeCount(nums));

    }

    /**
     * 题目描述：计算让一组区间不重叠所需要移除的区间个数。
     *
     * 先计算最多能组成的不重叠区间个数，然后用区间总个数减去不重叠区间的个数。
     *
     * 在每次选择中，区间的结尾最为重要，选择的区间结尾越小，留给后面的区间的空间越大，那么后面能够选择的区间个数也就越大。
     *
     * 按区间的结尾进行排序，每次选择结尾最小，并且和前一个区间不重叠的区间。
     * @param nums
     * @return
     */
    private static int removeCount(int[][] nums) {
        if (nums.length == 0) return 0;
        // 按区间的结尾进行排序
        //使用 lambda 表示式创建 Comparator 会导致算法运行时间过长，如果注重运行时间，可以修改为普通创建 Comparator 语句
        Arrays.sort(nums, Comparator.comparingInt(value -> value[1]));

        int index = 1, count = 1;
        while (index < nums.length) {
            if (nums[index - 1][1] <= nums[index][0]) {
                count++;
            }
            index++;
        }
        return nums.length - count;
    }


}
