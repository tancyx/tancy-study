package com.tancy.dataStruct.stackQueue;

import java.util.Stack;

/**
 * @author tancy
 * 2021/7/5 9:30
 * @description 最小栈
 */
public class MinStack {


    public static void main(String[] args) {

    }


    private static class MyStack {

        private Stack<Integer> stack = new Stack<>();

        private Stack<Integer> minStack = new Stack<>();

        private Integer min;

        public void push(int num) {
            stack.push(num);
            if (min == null) {
                min = num;
            } else {
                min = Math.min(min, num);
            }
            minStack.push(min);
        }


        public int pop() {
            Integer num = stack.pop();
            minStack.pop();
            min = minStack.isEmpty() ? null : minStack.pop();
            return num;
        }

        public int top() {
            return stack.peek();
        }

        public int getMinStack() {
            return min;
        }
    }

}
