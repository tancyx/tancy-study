package com.tancy.dataStruct.array;

/**
 * @author tancy
 * 2021/7/12 15:22
 * @description 找出数组中重复的数，数组值在 [1, n] 之间
 *
 * 要求不能修改数组，也不能使用额外的空间。
 */
public class FindDuplicateNumber {

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(findBinary(nums));
        System.out.println(findDpointer(nums));

    }


    /**
     * 二分查找方式
     * @param nums
     * @return
     */
    private static int findBinary(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    /**
     * 快慢指针， 类似于有环链表中找出环的入口
     * @param nums
     * @return
     */
    private static int findDpointer(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

}
