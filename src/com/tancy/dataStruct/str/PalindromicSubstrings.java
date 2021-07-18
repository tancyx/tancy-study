package com.tancy.dataStruct.str;

/**
 * @author tancy
 * 2021/7/9 15:45
 * @description 回文子字符串个数
 */
public class PalindromicSubstrings {

    public static void main(String[] args) {

        System.out.println(countSubstrings("aaa"));

    }


    /**
     * 从字符串的某一位开始，尝试着去扩展子字符串。
     * @param s
     * @return
     */
    private static int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int odd = extend(s, i, i);
            int even = extend(s, i, i + 1);
            count += odd + even;
        }
        return count;
    }

    private static int extend(String s, int start, int end) {
        int count = 0;
        while (start >= 0 && end <= s.length() - 1 && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            count++;
        }
        return count;
    }

}
