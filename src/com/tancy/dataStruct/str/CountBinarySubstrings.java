package com.tancy.dataStruct.str;

/**
 * @author tancy
 * 2021/7/9 17:25
 * @description 统计二进制字符串中连续 1 和连续 0 数量相同的子字符串个数
 */
public class CountBinarySubstrings {

    public static void main(String[] args) {

        System.out.println(count("00110011"));

        System.out.println(countBinarySubstrings("00110011"));

    }


    private static int count(String s) {
        int total = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int count = 1, sw = 0;
            char pre = s.charAt(i), cur;
            for (int j = i + 1; j < s.length(); j++) {
                cur = s.charAt(j);
                if (pre != cur) {
                    pre = cur;
                    sw++;
                }
                if (sw > 1) {
                    break;
                }
                if (sw == 0) {
                    count++;
                } else {
                    count--;
                    if (count == 0) break;
                }
            }

            if (count == 0) {
                total++;
            }
        }
        return total;
    }


    private static int countBinarySubstrings(String s) {
        int preLen = 0, curLen = 1, count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curLen++;
            } else {
                preLen = curLen;
                curLen = 1;
            }

            if (preLen >= curLen) {
                count++;
            }
        }
        return count;
    }

}
