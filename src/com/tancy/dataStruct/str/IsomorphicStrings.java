package com.tancy.dataStruct.str;

/**
 * @author tancy
 * 2021/7/9 15:07
 * @description 字符串同构
 */
public class IsomorphicStrings {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));

    }


    /**
     * 记录一个字符上次出现的位置，如果两个字符串中的字符上次出现的位置一样，那么就属于同构。
     * @param s1
     * @param s2
     * @return
     */
    private static boolean isIsomorphic(String s1, String s2) {
        int[] c1 = new int[256];
        int[] c2 = new int[256];

        for (int i = 0; i < s1.length(); i++) {
            char sc1 = s1.charAt(i);
            char sc2 = s2.charAt(i);
            if (c1[sc1] != c2[sc2]) {
                return false;
            }
            c1[sc1] = i;
            c2[sc2] = i;
        }
        return true;
    }

}
