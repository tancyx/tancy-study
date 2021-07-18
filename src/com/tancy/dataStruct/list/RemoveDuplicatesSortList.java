package com.tancy.dataStruct.list;

/**
 * @author tancy
 * 2021/7/2 15:58
 * @description 从有序链表中删除重复节点
 */
public class RemoveDuplicatesSortList {


    public static void main(String[] args) {

        ListNode listNode7 = new ListNode(4, null);
        ListNode listNode6 = new ListNode(4, listNode7);
        ListNode listNode5 = new ListNode(4, listNode6);
        ListNode listNode4 = new ListNode(3, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        ListNode result = removeDupl(listNode1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }


    private static ListNode removeDupl(ListNode head) {
        ListNode l1 = head;
        while (l1.next != null) {
            if (l1.val == l1.next.val) {
                l1.next = l1.next.next;
            } else {
                l1 = l1.next;
            }
        }
        return head;
    }


}
