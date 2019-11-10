package cn.junwork.algorithm.other.linklist;

import cn.junwork.algorithm.common.struct.LinkList.Node;
import cn.junwork.algorithm.common.util.LinkListUtil;

/**
 * Created by Jun on 2017/7/4.
 */
public class JosephRing {
    
    public static void main(String[] args) {
        Node firstNode = LinkListUtil.genContinuousList(1, 5, true, false);
        System.out.print("原始链表：");
        LinkListUtil.printHeadlessList(firstNode);
        
        int count = 1;
        Node cur = firstNode.next;
        Node pre = firstNode;
    
        while (cur.next != cur) {
            ++count;
            if (count % 3 == 0) {
                count = 0;
                System.out.println(cur.value + "号自杀！");
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
    
        System.out.print("最后剩余：");
        LinkListUtil.printHeadlessList(cur);
    }
}
