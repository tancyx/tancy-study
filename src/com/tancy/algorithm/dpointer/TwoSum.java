package com.tancy.algorithm.dpointer;

/**
 * @author tancy
 * 2021/6/4 11:09
 * @description 双指针主要用于遍历数组，两个指针指向不同的元素，从而协同完成任务。
 */
public class TwoSum {


    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 7, 11, 15};
        twoSum(nums, 9);
    }

    /**
     * 在有序数组中找出两个数，使它们的和为 target
     * 使用双指针，一个指针指向值较小的元素，一个指针指向值较大的元素。指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
     * 如果两个指针指向元素的和 sum == target，那么得到要求的结果；
     * 如果 sum > target，移动较大的元素，使 sum 变小一些；
     * 如果 sum < target，移动较小的元素，使 sum 变大一些。
     * 数组中的元素最多遍历一次，时间复杂度为 O(N)。只使用了两个额外变量，空间复杂度为 O(1)。
     * @param nums
     * @param target
     */
    private static void twoSum(int[] nums, int target) {
        int min = 0, max = nums.length - 1;
        while (min <= max) {
            int sum = nums[min] + nums[max];
            if (sum > target) {
                max--;
                continue;
            }
            if (sum < target) {
                min++;
                continue;
            }
            if (sum == target) {
                System.out.println("min: " + min);
                System.out.println("max: " + max);
                break;
            }
        }

    }

}
