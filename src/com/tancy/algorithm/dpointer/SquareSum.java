package com.tancy.algorithm.dpointer;

/**
 * @author tancy
 * 2021/6/8 10:01
 * @description description
 */
public class SquareSum {

    public static void main(String[] args) {
        squareSum(13);
    }


    /**
     * 判断一个非负整数是否为两个整数的平方和
     * @param target
     */
    private static void squareSum(int target) {
        int min = 0, max = (int) Math.floor(Math.sqrt(target));

        while (min <= max) {
            int sum = min * min + max * max;
            if ( sum == target) {
                System.out.println(min);
                System.out.println(max);
                break;
            } else if (sum < target) {
                min++;
            } else {
                max--;
            }
        }
    }
}
