package cn.junwork.algorithm.common.util;

import java.util.stream.IntStream;

import cn.junwork.algorithm.common.struct.LinkList.Node;

/**
 * Created by Jun on 2017/6/6.
 */
public class LinkListUtil {
    
    public static Node genRandomOrderedList(int length, int bound, boolean cyclic, boolean headed) {
        int[] data = ArrayUtil.genRandomOrderedArr(length, bound);
        return genList(data, cyclic, headed);
    }
    
    public static Node genContinuousList(int start, int length, boolean cyclic, boolean headed) {
        int[] data = IntStream.range(start, start + length).toArray();
        return genList(data, cyclic, headed);
    }
    
    public static Node genList(int[] data, boolean cyclic, boolean headed) {
        Node head = new Node(0, null);
    
        /* 尾插法创建 */
        Node pTail = head;
        for (int v : data) {
            Node node = new Node(v, null);
            pTail.next = node;
            pTail = node;
        }
        
        if (cyclic) {
            pTail.next = headed ? head : head.next;
        }
        
        return headed ? head : head.next;
    }
    
    
    public static void printHeadedList(Node head) {
        Node p = head.next;
        
        while (p != null && p != head) {
            System.out.print(p.value + " -> ");
            p = p.next;
        }
        
        System.out.println(p != null ? "HEAD" : "NULL");
    }
    
    
    public static void printHeadlessList(Node node) {
        Node p = node;
        do {
            System.out.print(p.value + " -> ");
            p = p.next;
        } while (p != null && p != node);
    
        System.out.println(p != null ? "FIRST" : "NULL");
    }
}
