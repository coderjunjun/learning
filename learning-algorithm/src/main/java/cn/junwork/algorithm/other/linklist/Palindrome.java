package cn.junwork.algorithm.other.linklist;

import java.util.ArrayList;
import java.util.List;

import cn.junwork.algorithm.common.struct.LinkList.Node;
import cn.junwork.algorithm.common.util.LinkListUtil;
import cn.junwork.algorithm.common.util.Printer;

/**
 * Created by Jun on 2017/7/12.
 */
public class Palindrome {
    public static void main(String[] args) {
        Node head = LinkListUtil.genList(new int[]{1, 2, 3, 2, 1}, false, true);
        Printer.print("原始链表：");
        LinkListUtil.printHeadedList(head);
    
        Printer.println(isPalindrome(head) + " | " + isPalindromeAdv(head));
    
        Printer.print("恢复后：");
        LinkListUtil.printHeadedList(head);
    }
    
    
    public static boolean isPalindrome(Node head) {
        List<Node> list = new ArrayList();
    
        Node p = head.next;
        while (p != null) {
            list.add(p);
            p = p.next;
        }
        
        for (int i = 0, j = list.size() - 1; i < j; ++i, --j) {
            if (!list.get(i).equals(list.get(j))) return false;
        }
        
        return true;
    }
    
    
    public static boolean isPalindromeAdv(Node head) {
        
        //找到后半部分的开始节点
        Node backStart = head.next;
        Node cur = head;
        while (cur.next != null && cur.next.next != null) {
            backStart = backStart.next;
            cur = cur.next.next;
        }
        
        //将后半部分的指针反向
        cur = backStart;
        Node p1 = cur.next;
        while (p1 != null) {
            Node p2 = p1.next;
            p1.next = cur;
    
            cur = p1;
            p1 = p2;
        }
    
        backStart.next = null;
        Node lastNode = cur;
    
        //从两头开始，一一比较
        Node forward = head.next;
        Node backward = lastNode;
    
        boolean isPalindrome = true;
        while (backward != null) {
            if (!forward.equals(backward)) {
                isPalindrome = false;
                break;
            }
    
            forward = forward.next;
            backward = backward.next;
        }
        
        //恢复后半部分的指针
        cur = lastNode;
        p1 = cur.next;
        while (p1 != null) {
            Node p2 = p1.next;
            p1.next = cur;
    
            cur = p1;
            p1 = p2;
        }
    
        lastNode.next = null;
        
        return isPalindrome;
    }
}
