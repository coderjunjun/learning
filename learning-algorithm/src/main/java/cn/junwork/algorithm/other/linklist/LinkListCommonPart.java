package cn.junwork.algorithm.other.linklist;

import cn.junwork.algorithm.common.struct.LinkList.Node;

/**
 * <p>打印有序链表的公共部分
 * <p>注意是公共部分，不是相同值
 * Created by Jun on 2017/6/6.
 */
public class LinkListCommonPart {
    
    public static void printCommon(Node head1, Node head2) {
        Node p1 = head1.next;
        Node p2 = head2.next;
    
        while (p1 != null && p2 != null) {
            if (p1.value == p2.value) {
                System.out.print(p1.value + " ");
                p1 = p1.next;
                p2 = p2.next;
            } else if (p1.value < p2.value) {
                p1 = p1.next;
            } else {
                p2 = p2.next;
            }
        }
    }
}
