package com.tancy.dataStruct.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tancy
 * 2021/7/16 18:13
 * @description 嵌套数组
 */
public class ArrayNesting {

    public static void main(String[] args) {

        int[] nums = {5, 4, 0, 3, 1, 6, 2};

        System.out.println(find(nums));

    }


    /**
     * 题目描述：S[i] 表示一个集合，集合的第一个元素是 A[i]，第二个元素是 A[A[i]]，如此嵌套下去。
     * 求最大的 S[i] 长度
     * @param nums
     * @return
     */
    private static int find(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            List<Integer> rec = new ArrayList<>();
            for (int j = i; !rec.contains(j); j = nums[j]) {
                count++;
                rec.add(j);
            }
            max = Math.max(max, count);
        }

        return max;
    }

}
