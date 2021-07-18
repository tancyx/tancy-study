package com.tancy.dataStruct.stackQueue;

import java.util.Stack;

/**
 * @author tancy
 * 2021/7/6 10:32
 * @description 用栈实现括号匹配
 */
public class ValidParentheses {


    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("){[]}"));

    }


    private static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            if ((aChar == ')' || aChar == '}' || aChar == ']') && stack.isEmpty()) {
                return false;
            }
            if (aChar == '(' || aChar == '{' || aChar == '[') {
                stack.push(aChar);
            }
            if (aChar == ')' || aChar == '}' || aChar == ']') {
                Character pre = stack.pop();
                if (!compare(pre, aChar)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean compare(char left, char right) {
        if (left == '(' && right == ')') {
            return true;
        }
        if (left == '{' && right == '}') {
            return true;
        }
        if (left == '[' && right == ']') {
            return true;
        }
        return false;
    }

}
