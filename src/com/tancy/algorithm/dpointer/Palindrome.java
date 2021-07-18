package com.tancy.algorithm.dpointer;

/**
 * @author tancy
 * 2021/6/8 13:34
 * @description description
 */
public class Palindrome {

    public static void main(String[] args) {
        palindrome("abecba");
    }


    /**
     * 可以删除一个字符，判断是否能构成回文字符串。
     *
     * @param target
     */
    private static void palindrome(String target) {
        int left = 0, right = target.length() - 1, deleted = 0, flag = 0;
        boolean isHuiwen = true;
        char[] chars = target.toCharArray();
        while (left <= right) {
            if (chars[left] == chars[right]) {
                left++;
                right--;
                continue;
            } else {
                if (deleted < 1) {
                    if (chars[left + 1] == chars[right]) {
                        flag = left;
                        left++;
                        deleted++;
                        continue;
                    }
                    if (chars[left] == chars[right - 1]) {
                        flag = right;
                        right--;
                        deleted++;
                        continue;
                    }
                }
                isHuiwen = false;
                System.out.println("不是回文字符串");
                break;
            }
        }

        if (isHuiwen) {
            System.out.println("删除第" + (flag + 1) + "个字母即是回文");
        }
    }

}
