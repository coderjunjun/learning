package cn.junwork.algorithm.leetcode;

import cn.junwork.algorithm.common.struct.ListNode;

public class Q206_ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = p1.next;
        ListNode p3;
        while (p2 != null) {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        head.next = null;
        return p1;
    }
}
