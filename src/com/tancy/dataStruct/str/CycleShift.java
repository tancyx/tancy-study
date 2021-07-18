package com.tancy.dataStruct.str;

/**
 * @author tancy
 * 2021/7/9 10:20
 * @description 字符串循环移位
 */
public class CycleShift {

    public static void main(String[] args) {

        System.out.println(shift("abcd123", 3));

    }


    /**
     * 将字符串向右循环移动 k 位
     *
     * @param s
     * @param k
     * @return
     */
    private static String shift(String s, int k) {
        String left = s.substring(0, s.length() - k);
        String right = s.substring(s.length() - k);
        String ls = reverse(left);
        String rs = reverse(right);
        return reverse(ls + rs);
    }

    private static String reverse(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            swap(chars, left++, right--);
        }
        return String.valueOf(chars);
    }

    private static void swap(char[] chars, int index1, int index2) {
        char tmp = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = tmp;
    }

}
