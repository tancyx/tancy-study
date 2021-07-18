package com.tancy.dataStruct.stackQueue;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author tancy
 * 2021/7/7 10:39
 * @description 循环数组中比当前元素大的下一个元素
 * https://leetcode-cn.com/problems/next-greater-element-ii/
 */
public class NextGreaterElement {

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        for (int i : nextGreaterElement(nums)) {
            System.out.print(i + ",");
        }
    }

    private static int[] nextGreaterElement(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);

        for (int i = 0; i < nums.length * 2; i++) {
            int num = nums[i % nums.length];
            while (!stack.isEmpty() && num > nums[stack.peek()]) {
                Integer index = stack.pop();
                result[index] = num;
            }
            if (i < nums.length) {
                stack.push(i);
            }
        }
        return result;
    }


}
