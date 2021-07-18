package com.tancy.dataStruct.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tancy
 * 2021/7/16 17:18
 * @description 数组的度
 */
public class DegreeArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 1, 4, 2};

        System.out.println(Arrays.toString(find(nums)));

    }


    /**
     * 题目描述：数组的度定义为元素出现的最高频率，例如上面的数组度为 3。
     * 要求找到一个最小的子数组，这个子数组的度和原数组一样。
     * @param nums
     * @return
     */
    private static int[] find(int[] nums) {
        Map<Integer, Integer> frequency = new HashMap<>();
        int[] result = new int[nums.length];

        for (int num : nums) {
            if (frequency.containsKey(num)) {
                Integer total = frequency.get(num) + 1;
                frequency.put(num, total);
            } else {
                frequency.put(num, 1);
            }
        }

        int max = nums[0];
        for (Map.Entry<Integer, Integer> integerIntegerEntry : frequency.entrySet()) {
            if (integerIntegerEntry.getValue() > frequency.get(max)) {
                max = integerIntegerEntry.getKey();
            }
        }

        int j = 0;
        for (int i = 0, count = frequency.get(max); i < nums.length && count > 0; i++) {
            if (j == 0 && nums[i] == max) {
                result[j++] = nums[i];
                count--;
                continue;
            }
            if (j > 0) {
                if (nums[i] == max) {
                    count--;
                }
                result[j++] = nums[i];
            }
        }

        return Arrays.copyOfRange(result, 0, j);
    }

}
