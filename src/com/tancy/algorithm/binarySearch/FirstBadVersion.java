package com.tancy.algorithm.binarySearch;

/**
 * @author tancy
 * 2021/6/28 11:10
 * @description 第一个错误的版本
 */
public class FirstBadVersion {

    public static void main(String[] args) {
        System.out.println(findFirstBadVersion(8));
    }


    private static int findFirstBadVersion(int version) {
        if (version <= 0) return -1;
        int left = 1, right = version;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private static boolean isBadVersion(int mid) {
        if (mid >= 3) {
            return true;
        }
        return false;
    }


}
