package cn.junwork.algorithm.other.linklist;

import cn.junwork.algorithm.common.struct.LinkList.Node;

import static cn.junwork.algorithm.common.util.LinkListUtil.genContinuousList;
import static cn.junwork.algorithm.common.util.LinkListUtil.printHeadedList;

/**
 * Created by Jun on 2017/7/11.
 */
public class PartialReversal {
    public static void main(String[] args) {
        Node head = genContinuousList(1, 3, false, true);
        printHeadedList(head);
        
        reversePart(head, 1, 3);
        printHeadedList(head);
    }
    
    
    public static void reversePart(Node head, int from, int to) {
        if (from < 1 || from >= to) return;
    
        //找到from节点的前驱和to节点
        Node fromPrevNode = null;
        Node toNode = null;
        Node p = head;
        for (int i = 1; p.next != null; p = p.next, ++i) {
            if (i == from) {
                fromPrevNode = p;
            }
            
            if (i == to) {
                toNode = p.next;
                break;
            }
        }
        
        if (toNode == null) return;
        
        //以to节点为轴，将from开始的节点逐个移动到后面
        Node fromNode = fromPrevNode.next;
        while (fromNode != toNode) {
            fromPrevNode.next = fromNode.next;
            fromNode.next = toNode.next;
            toNode.next = fromNode;
            
            fromNode = fromPrevNode.next;
        }
    }
}
