package cn.junwork.algorithm.other.linklist;

import java.util.HashMap;
import java.util.Map;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * <p>
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplication {
    
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) return null;
        Map<ListNode, Integer> countMap = new HashMap<>();
        ListNode p = pHead;
        
        while (p != null) {
            int count = countMap.containsKey(p) ? countMap.get(p) + 1 : 1;
            countMap.put(p, count);
            p = p.next;
        }
        
        p = pHead;
        while (p.next != null) {
            if (countMap.get(p.next) > 1) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        
        //最后要判断头结点是不是也要删
        return countMap.get(pHead) > 1 ? pHead.next : pHead;
    }
    
    
    public class ListNode {
        int val;
        ListNode next = null;
        
        ListNode(int val) {
            this.val = val;
        }
        
        @Override
        public int hashCode() {
            return val;
        }
        
        @Override
        public boolean equals(Object obj) {
            return val == ((ListNode) obj).val;
        }
    }
}
