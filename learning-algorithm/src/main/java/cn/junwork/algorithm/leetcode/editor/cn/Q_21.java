//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表 
// 👍 1375 👎 0

package cn.junwork.algorithm.leetcode.editor.cn;

import java.util.*;

public class Q_21 {
    public static void main(String[] args) {
        (new Q_21()).new Solution()

        ;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            } else if (l2 == null) {
                return l1;
            } else {
                ListNode tail = null, p1 = l1, p2 = l2;
                while (p1 != null && p2 != null) {
                    if (p1.val < p2.val) {
                        tail = append(tail, p1);
                        p1 = p1.next;
                    } else {
                        tail = append(tail, p2);
                        p2 = p2.next;
                    }
                }
                tail.next = p1 != null ? p1 : p2;
                return l1.val < l2.val ? l1 : l2;
            }
        }

        private ListNode append(ListNode tail, ListNode node) {
            if (tail != null) {
                tail.next = node;
            }
            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}