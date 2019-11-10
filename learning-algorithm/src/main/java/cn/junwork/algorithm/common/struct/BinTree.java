package cn.junwork.algorithm.common.struct;

/**
 * Created by Jun on 2017/8/10.
 */
public class BinTree {
    
    public static class Node {
        public Node() {}
    
        public Node(int value) {
            this.value = value;
        }
    
        public int value;
        public Node lchild;
        public Node rchild;
    }
}
