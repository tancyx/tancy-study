package com.tancy.dataStruct.str;

/**
 * @author tancy
 * 2021/7/9 17:01
 * @description 判断一个整数是否是回文数
 */
public class PalindromeNumber {

    public static void main(String[] args) {

        System.out.println(isPalindromeNumber(121));
        System.out.println(isPalindromeNumber(122));
        System.out.println(isPalindromeNumber(1221));

    }


    /**
     * 要求不能使用额外空间，也就不能将整数转换为字符串进行判断。
     *
     * 将整数分成左右两部分，右边那部分需要转置，然后判断这两部分是否相等。
     * @param num
     * @return
     */
    private static boolean isPalindromeNumber(int num) {
        if (num == 0) {
            return true;
        }

        int right = 0;
        while (num > right) {
            right = right * 10 + num % 10;
            num /= 10;
        }
        if (num == right) {
            return true;
        }
        return right / 10 == num;
    }

}
