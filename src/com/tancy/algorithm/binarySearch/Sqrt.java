package com.tancy.algorithm.binarySearch;

/**
 * @author tancy
 * 2021/6/27 14:33
 * @description 求开方
 */
public class Sqrt {

    public static void main(String[] args) {

        System.out.println(calculateSqrt(8));

    }


    /**
     * 一个数 x 的开方 sqrt 一定在 0 ~ x 之间，并且满足 sqrt == x / sqrt。
     * 可以利用二分查找在 0 ~ x 之间查找 sqrt。
     * @param num
     * @return
     */
    private static int calculateSqrt(int num) {
        if (num <= 1) return num;
        int left = 2, right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (num < mid * mid) {
                right = mid - 1;
            } else if (num > mid * mid) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        // 对于 num = 8，它的开方是 2.82842...，最后应该返回 2 而不是 3。
        // 在循环条件为 left <= right 并且循环退出时，right 总是比 left 小 1，也就是说 right = 2，left = 3，因此最后的返回值应该为 right 而不是 left。
        return right;
    }

}
