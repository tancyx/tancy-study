package com.tancy;

import com.tancy.desiginPattern.proxy.WineProduct;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Test {

    public static void main(String[] args) {
//        int length=3;
//        System.out.println(hash("xx"));
//        System.out.println(hash("xx"));
        System.out.println(Test.class.getName());
        System.out.println(Test.class.getCanonicalName());
        System.out.println(Test.class.getSimpleName());
        System.out.println("");
        Method[] methods = Test.class.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            System.out.println(method.getReturnType().getSimpleName());
            Class[] params = method.getParameterTypes();
            for (Class clazz : params) {
                System.out.println("getParameterTypes:" + clazz.getSimpleName());
            }
            Type[] types = method.getGenericParameterTypes();
            for (Type type : types) {
                System.out.println("getGenericParameterTypes:" + type.getTypeName());
            }

        }
        Constructor[] constructors = Test.class.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        List list = new ArrayList();
        System.out.println(list.getClass().getSimpleName());
        Test[] ta = new Test[]{new Test(), new Test(), new Test()};
        System.out.println(Arrays.deepToString(ta));

        Path path = Paths.get("./src");
        try {
            System.out.println(path.toRealPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Files.exists(path));


        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
        maxSubArray(new int[]{-3, -2, 1, 2, 2, 0, 1, 0});
        System.out.println(Arrays.toString(plusOne(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0})));
        System.out.println(Integer.MAX_VALUE);

        long start=System.currentTimeMillis();
        System.out.println(climbStairs(50));
        System.out.println(System.currentTimeMillis()-start);
        Object[] tas=new Object[]{4,1,3};Arrays.sort(tas);
    }


    public static int hashx(java.lang.Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            map.put(nums[i], i);
            int another = target - nums[i];
            boolean flag = map.containsKey(another);
            int index = map.get(another);
            if (flag && index != i) {
                return new int[]{map.get(another), i};
            }
        }
        return new int[]{0, 0};
    }

    public static int maxSubArray(int[] nums) {
        int max = nums[0], sum = 0, result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > max) {
                max = sum;
            } else if (sum < 0) {
                if (nums[i] > max) {
                    max = nums[i];
                    sum = nums[i];
                }
                sum = 0;

            }
        }
        return max;
    }

    public static int lengthOfLastWord(String s) {
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (' ' == s.charAt(i)) {
                break;
            }
            count++;
        }
        return count;
    }

    public static int[] plusOne(int[] digits) {
        long num = 0;
        int[] res = new int[digits.length + 1];
        for (int i = 0; i < digits.length; i++) {
            num = num * 10 + digits[i];
        }
        num += 1;
        int r;
        for (int j = res.length - 1; j >= 0; j--) {
            r = (int) num % 10;
            if (num == 0) {
                return Arrays.copyOfRange(res, 1, res.length);
            } else {
                res[j] = r;
            }
            num /= 10;
        }
        return res;
    }

    public static int climbStairs(int n) {
        if (n < 1) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

}
