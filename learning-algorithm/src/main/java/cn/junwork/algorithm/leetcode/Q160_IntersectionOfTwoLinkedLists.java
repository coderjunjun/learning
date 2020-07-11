package cn.junwork.algorithm.leetcode;

import cn.junwork.algorithm.common.struct.ListNode;

/**
 * <a href="https://leetcode-cn.com/problems/intersection-of-two-linked-lists/">160. Intersection of Two Linked Lists</a>
 * <pre>
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * For example, the following two linked lists:
 *
 *
 * begin to intersect at node c1.
 *
 *  
 *
 * Example 1:
 *
 *
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * Output: Reference of the node with value = 8
 * Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 *  
 *
 * Example 2:
 *
 *
 * Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Reference of the node with value = 2
 * Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 *  
 *
 * Example 3:
 *
 *
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * Output: null
 * Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
 * Explanation: The two lists do not intersect, so return null.
 *  
 *
 * Notes:
 *
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * </pre>
 *
 * @author coderjunjun@gmail.com
 * @date 2020/4/16
 */
public class Q160_IntersectionOfTwoLinkedLists {

    /**
     * 因为交点以后的路径是相同的，所以两个链表长度不一致时，
     * 遍历较长链表的起始位置向前挪和较短链表对其，然后向前一一比较即可
     */
    public ListNode getIntersectionNodeV1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        if (headA == headB) {
            return headA;
        }

        int len1 = 0, len2 = 0;
        ListNode p = headA;
        while (p != null) {
            ++len1;
            p = p.next;
        }
        p = headB;
        while (p != null) {
            ++len2;
            p = p.next;
        }

        ListNode longer = len1 > len2 ? headA : headB;
        int diff = Math.abs(len1 - len2);
        ListNode longerStart = longer;
        for (int i = 0; i < diff; ++i) {
            longerStart = longerStart.next;
        }
        ListNode shorterStart = len1 <= len2 ? headA : headB;

        ListNode p1 = longerStart, p2 = shorterStart;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }

    /**
     * 和V1版本质上相同，两个链表首尾互连，消除交点以前的路径差
     */
    public ListNode getIntersectionNodeV2(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }
}
