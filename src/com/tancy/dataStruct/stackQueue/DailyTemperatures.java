package com.tancy.dataStruct.stackQueue;

import java.util.Stack;

/**
 * @author tancy
 * 2021/7/6 17:17
 * @description 数组中元素与下一个比它大的元素之间的距离
 */
public class DailyTemperatures {


    public static void main(String[] args) {
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};

        for (int i : dailyTemperatures(nums)) {
            System.out.print(i + ",");
        }

    }

    private static int[] dailyTemperatures(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                Integer index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }

}
