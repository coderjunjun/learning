package cn.junwork.algorithm.other.linklist;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jun on 2017/6/12.
 */
public class CopyListWithRandomPointer {
    
    public static class Node {
        public Node() {
        }
        
        public Node(int value) {
            this.value = value;
        }
        
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
        
        int value;
        Node next;
        Node rndPointer;
    }
    
    
    public static Node copyOnOn(Node head) {
        Node newHead = new Node();
        Node p;
        
        //先扫一遍，对每一个节点，Node -> Index
        Map<Node, Integer> map = new HashMap<>();
        p = head.next;
        int i = 0;
        while (p != null) {
            map.put(p, i++);
            p = p.next;
        }
        
        //复制链表到一个数组
        int len = i;
        Node[] newNodes = new Node[len];
        
        p = head.next;
        for (i = 0; i < len; ++i, p = p.next) {
            newNodes[i] = new Node(p.value, null);
            if (i > 0) {
                newNodes[i - 1].next = newNodes[i];
            }
        }
        
        //设置随机指针的值
        p = head.next;
        for (i = 0; i < len; ++i, p = p.next) {
            if (p.rndPointer != null) {
                newNodes[i].rndPointer = newNodes[map.get(p.rndPointer)];
            }
        }
        
        newHead.next = newNodes[0];
        return newHead;
    }
    
    
    public static Node copyOnO1(Node head) {
        //复制每一个节点放在其后，如 1 -> 1` -> 2 -> 2` -> null
        Node p = head.next;
        while (p != null) {
            Node node = new Node(p.value, p.next);
            p.next = node;
            p = node.next;
        }
        
        Node newHead = new Node();
        p = head.next;
        Node pre;
        Node np = newHead;
        
        //设置随机指针
        while (p != null) {
            if (p.rndPointer != null) {
                p.next.rndPointer = p.rndPointer.next;
            }
            p = p.next.next;
        }
        
        //将新链表串起来，同时让原链表也恢复
        p = head.next;
        while (p != null) {
            pre = p.next.next;
            np.next = p.next;
            np = np.next;
            
            p.next = pre;
            p = pre;
        }
        
        return newHead;
    }
    
    
    public static void print(Node head) {
        Node p = head.next;
        while (p != null && p != head) {
            System.out.print(String.format("%d(%s) -> ", p.value, p.rndPointer != null ? p.rndPointer.value + "" : "NULL"));
            p = p.next;
        }
        
        System.out.print(p != null ? "HEAD" : "NULL");
        
        System.out.println();
    }
    
    
    public static Node getAt(Node head, int index) {
        int i = 0;
        Node p = head.next;
        
        while (p != null) {
            if (i == index) return p;
            p = p.next;
            ++i;
        }
        
        return null;
    }
    
    
    public static void main(String[] args) {
        
        Integer[][] data = {
                //format: {value, randomIndex}
                {1, 2},
                {2, null},
                {3, 0}
        };
        
        //创建链表
        Node head = new Node();
        Node p = head;
        for (Integer[] nodeData : data) {
            Node node = new Node(nodeData[0], null);
            p.next = node;
            p = p.next;
        }
        for (int i = 0; i < data.length; ++i) {
            getAt(head, i).rndPointer = data[i][1] == null ? null : getAt(head, data[i][1]);
        }
    
        System.out.print("原链表：");
        print(head);
        System.out.println();
        
        Node newListHead = copyOnO1(head);
        System.out.print("复制后新链表：");
        print(newListHead);
        System.out.print("复制后原链表：");
        print(head);
    }
}
