package com.tancy.algorithm.partition;

import java.util.LinkedList;
import java.util.List;

/**
 * @author tancy
 * 2021/6/30 9:04
 * @description 给表达式加括号
 */
public class AssignParentheses {

    public static void main(String[] args) {
        String input = "2-1-1";

        List<Integer> integers = diffWaysToCompute(input);
        for (Integer integer : integers) {
            System.out.println(integer);
        }

    }


    private static List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new LinkedList<>();

        for (int i = 1; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));

                for (Integer l : left) {
                    for (Integer r : right) {
                        if (c == '+') {
                            result.add(l + r);
                        }
                        if (c == '-') {
                            result.add(l - r);
                        }
                        if (c == '*') {
                            result.add(l * r);
                        }
                    }
                }
            }
        }

        if (result.size() == 0) {
            result.add(Integer.parseInt(expression));
        }
        return result;
    }

}
