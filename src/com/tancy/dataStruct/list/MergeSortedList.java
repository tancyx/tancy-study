package com.tancy.dataStruct.list;

/**
 * @author tancy
 * 2021/7/2 14:44
 * @description 归并两个有序的链表
 */
public class MergeSortedList {

    public static void main(String[] args) {

        ListNode listNode02 = new ListNode(2, null);
        ListNode listNode01 = new ListNode(1, listNode02);

        ListNode listNode13 = new ListNode(13, null);
        ListNode listNode12 = new ListNode(12, listNode13);
        ListNode listNode11 = new ListNode(11, listNode12);

        ListNode listNode = mergeSortedList(listNode01, listNode11);

        while (listNode != null) {
            System.out.println(listNode);
            listNode = listNode.next;
        }
    }

    private static ListNode mergeSortedList(ListNode head1, ListNode head2) {
        ListNode l1 = head1, l2 = head2, newList, tmp;
        if (l1.val <= l2.val) {
            newList = l1;
            l1 = l1.next;
        } else {
            newList = l2;
            l2 = l2.next;
        }
        tmp = newList;
        while (l1 != null && l2 != null) {
            if (l2 == null || l1.val <= l2.val) {
                tmp.next = l1;
                tmp = tmp.next;
                l1 = l1.next;
            }
            if (l1 == null || l1.val > l2.val) {
                tmp.next = l2;
                tmp = tmp.next;
                l2 = l2.next;
            }
        }

        return newList;
    }

}
