package com.tancy.dataStruct.list;

/**
 * @author tancy
 * 2021/6/18 23:35
 * @description description
 */
public class LinkedList {


    public static void main(String[] args) {

        ListNode listNode5 = new ListNode(5, null);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        ListNode tmp = reverse(listNode1);

        while (tmp != null) {
            System.out.println(tmp);
            tmp = tmp.next;
        }


    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    private static ListNode reverse(ListNode head) {
        ListNode pre = head, current = head.next;
        pre.next = null;
        while (current != null) {
            ListNode tmp = current.next;
            current.next = pre;
            pre = current;
            current = tmp;
        }
        return pre;
    }

    private static class ListNode{
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


}
