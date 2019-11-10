package cn.junwork.algorithm.common.struct;

/**
 * Created by Jun on 2017/8/10.
 */
public class LinkList {
    
    public static class Node {
        public int value;
        public Node next;
        
        public Node() {}
    
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    
        @Override
        public boolean equals(Object obj) {
            return obj instanceof Node ? ((Node)obj).value == this.value : false;
        }
    }
}
