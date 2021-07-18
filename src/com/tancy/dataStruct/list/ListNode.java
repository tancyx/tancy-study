package com.tancy.dataStruct.list;

/**
 * @author tancy
 * 2021/7/2 14:45
 * @description description
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
