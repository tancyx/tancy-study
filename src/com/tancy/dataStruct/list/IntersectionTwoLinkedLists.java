package com.tancy.dataStruct.list;

/**
 * @author tancy
 * 2021/7/2 9:10
 * @description 找出两个链表的交点
 *
 * 如果只是判断是否存在交点，那么就是另一个问题，有两种解法：
 *
 * 把第一个链表的结尾连接到第二个链表的开头，看第二个链表是否存在环；
 * 或者直接比较两个链表的最后一个节点是否相同。
 */
public class IntersectionTwoLinkedLists {

    public static void main(String[] args) {
        ListNode listNode23 = new ListNode(23);
        ListNode listNode22 = new ListNode(22, listNode23);
        ListNode listNode21 = new ListNode(21, listNode22);

        ListNode listNode02 = new ListNode(2, listNode21);
        ListNode listNode01 = new ListNode(1, listNode02);

        ListNode listNode13 = new ListNode(13, listNode21);
        ListNode listNode12 = new ListNode(12, listNode13);
        ListNode listNode11 = new ListNode(11, listNode12);

        ListNode intersection = findIntersectionLinked(listNode01, listNode11);

        System.out.println(intersection);

    }

    /**
     * A:          a1 → a2
     *                     ↘
     *                       c1 → c2 → c3
     *                     ↗
     * B:    b1 → b2 → b3
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode findIntersectionLinked(ListNode head1, ListNode head2) {
        ListNode l1 = head1, l2 = head2;
        while (l1 != l2) {
            l1 = l1.next == null ? head2 : l1.next;
            l2 = l2.next == null ? head1 : l2.next;
        }
        return l1;
    }


    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this(val, null);
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
