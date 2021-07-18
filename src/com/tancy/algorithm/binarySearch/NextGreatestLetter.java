package com.tancy.algorithm.binarySearch;

/**
 * @author tancy
 * 2021/6/27 15:04
 * @description 大于给定元素的最小元素
 */
public class NextGreatestLetter {

    public static void main(String[] args) {
        char[] chars = {'a', 'c', 'd', 'e', 'f', 'h', 'j'};
        System.out.println(nextGreatestLetter(chars, 'd'));
    }


    /**
     * 题目描述：给定一个有序的字符数组 letters 和一个字符 target，
     * 要求找出 letters 中大于 target 的最小字符，如果找不到就返回第 1 个字符。
     * @param chars
     * @param target
     * @return
     */
    private static char nextGreatestLetter(char[] chars, char target) {
        if (chars.length <=0) return ' ';
        int left = 0, right = chars.length - 1, count = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < chars[mid]) {
                right = mid - 1;
                count++;
            } else {
                left = mid + 1;
            }
        }
        return left < right || count > 0 ? chars[left] : chars[0];
    }

}
