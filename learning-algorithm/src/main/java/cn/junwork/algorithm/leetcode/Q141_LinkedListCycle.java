package cn.junwork.algorithm.leetcode;

import cn.junwork.algorithm.common.struct.ListNode;

/**
 * <a href="https://leetcode-cn.com/problems/linked-list-cycle/">141. Linked List Cycle</a>
 * <pre>
 * Given a linked list, determine if it has a cycle in it.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 *  
 *
 * Example 1:
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 *
 * Example 2:
 *
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 *
 * Example 3:
 *
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 *
 *
 *  
 *
 * Follow up:
 *
 * Can you solve it using O(1) (i.e. constant) memory?
 * </pre>
 *
 * @author coderjunjun@gmail.com
 * @date 2020/4/19
 */
public class Q141_LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode p1 = head, p2 = head;
        do {
            p1 = p1 != null ? p1.next : null;
            p2 = p2 != null && p2.next != null ? p2.next.next : null;
        } while (p1 != p2 && p2 != null);
        return p2 != null;
    }
}
