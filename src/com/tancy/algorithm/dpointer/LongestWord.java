package com.tancy.algorithm.dpointer;

/**
 * @author tancy
 * 2021/6/9 9:33
 * @description 最长子序列
 */
public class LongestWord {

    public static void main(String[] args) {
        String s = "abpcplea";
        String[] d = {"ale", "apple", "monkey", "plea"};
        longestWord(s, d);
    }


    /**
     * 删除 s 中的一些字符，使得它构成字符串列表 d 中的一个字符串，找出能构成的最长字符串。
     * 如果有多个相同长度的结果，返回字典序的最小字符串。
     *
     * @param source
     * @param targets
     */
    private static void longestWord(String source, String[] targets) {
        String tmp = "";
        for (String target : targets) {
            if (tmp.length() > target.length() || (tmp.length() == target.length() && tmp.compareTo(target) < 0)) {
                continue;
            }
            if (isSubStr(source, target)) {
                tmp = target;
            }
        }
        System.out.println(tmp);
    }

    private static boolean isSubStr(String source, String target) {
        int sourceIndex = 0, targetIndex = 0;
        while (sourceIndex < source.length() && targetIndex < target.length()) {
            if (source.charAt(sourceIndex) == target.charAt(targetIndex)) {
                targetIndex++;
            }
            sourceIndex++;
        }
        return targetIndex >= target.length();
    }

}
