package com.tancy.dataStruct.array;

import java.util.Arrays;

/**
 * @author tancy
 * 2021/7/16 9:40
 * @description 数组相邻差值的个数
 */
public class BeautifulArrangement {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(myCount(6, 3)));

        System.out.println(Arrays.toString(count(6, 3)));

    }


    /**
     * 题目描述：数组元素为 1~n 的整数，要求构建数组，使得相邻元素的差值不相同的个数为 k。
     *
     * 让前 k+1 个元素构建出 k 个不相同的差值，序列为：1 k+1 2 k 3 k-1 ... k/2 k/2+1.
     * @param num
     * @param k
     * @return
     */
    private static int[] myCount(int num, int k) {
        int[] result = new int[num];
        for (int i = 0; i < num - (k + 1); i++) {
            result[i] = i + 1;
        }

        int left = num - k;
        int right = num;
        for (int i = num - (k + 1); i < num; i++) {
            if (i % 2 == 0) {
                result[i] = left++;
            } else {
                result[i] = right--;
            }
        }

        return result;
    }


    private static int[] count(int num, int k) {
        int[] result = new int[num];

        // 构造等差序列
        for (int i = 0; i < num - k - 1; i++) {
            result[i] = i + 1;
        }


        // 第 2 步：构造交错数列，下标从 n - k - 1 开始，数值从 n - k 开始
        // 控制交错的变量
        int j = 0;
        int left = num - k;
        int right = num;
        for (int i = num - k - 1; i < num; i++) {
            if (j % 2 == 0) {
                result[i] = left;
                left++;
            } else {
                result[i] = right;
                right--;
            }
            j++;
        }

        return result;
    }

}
