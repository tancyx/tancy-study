package com.tancy.dataStruct.stackQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author tancy
 * 2021/7/4 16:08
 * @description 队列实现栈
 */
public class QueueToStack {

    public static void main(String[] args) {

    }


    private static class MyStack {

        private Queue<Integer> queue = new LinkedList<>();


        public void push(int num) {
            queue.add(num);
            for (int i = queue.size(); i > 1; i--) {
                queue.add(queue.poll());
            }
        }

        public int pop() {
            return queue.remove();
        }

        public int peek() {
            return queue.peek();
        }

    }


}
