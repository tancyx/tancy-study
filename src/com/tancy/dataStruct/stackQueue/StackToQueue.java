package com.tancy.dataStruct.stackQueue;

import java.util.Stack;

/**
 * @author tancy
 * 2021/7/4 15:47
 * @description 用栈实现队列
 */
public class StackToQueue {

    public static void main(String[] args) {

    }


    private static class MyQueue {

        private Stack<Integer> in = new Stack<>();

        private Stack<Integer> out = new Stack<>();

        public void push(int num) {
            in.push(num);
        }

        public Integer pop() {
            inToOut();
            return out.pop();
        }

        public Integer peek() {
            inToOut();
            return out.peek();
        }

        public void inToOut() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
        }

    }

}
