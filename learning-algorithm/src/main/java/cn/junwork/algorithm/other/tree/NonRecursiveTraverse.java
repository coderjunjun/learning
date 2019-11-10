package cn.junwork.algorithm.other.tree;

import java.util.Stack;

import cn.junwork.algorithm.common.struct.BinTree.Node;

/**
 * Created by Jun on 2017/6/9.
 */
public class NonRecursiveTraverse {
    static class TraverseNode {
        
        public TraverseNode(Node node) {
            this.node = node;
        }
    
        Node node;
        int visitCount;
    }
    
    public static void preOrderTraverse(Node root) {
        traverse(root, 0);
    }
    
    
    public static void inOrderTraverse(Node root) {
        traverse(root, 1);
    }
    
    
    public static void postOrderTraverse(Node root) {
        traverse(root, 2);
    }
    
    
    private static void traverse(Node root, int rootOrder) {
        Stack<TraverseNode> traverseStack = new Stack<>();
        traverseStack.push(new TraverseNode(root));
    
        while (!traverseStack.isEmpty()) {
            TraverseNode curNode = traverseStack.pop();
            if (curNode.node == null) continue;
    
            if (curNode.visitCount == rootOrder) {
                System.out.print(curNode.node.value + " ");
            }
            
            switch (curNode.visitCount) {
                case 0:
                    //访问左子树前先把自身压栈（模拟递归）
                    traverseStack.push(curNode);
                    traverseStack.push(new TraverseNode(curNode.node.lchild));
                    break;
            
                case 1:
                    //访问右子树前先把自身压栈（模拟递归）
                    traverseStack.push(curNode);
                    traverseStack.push(new TraverseNode(curNode.node.rchild));
                    break;
            }
    
            ++curNode.visitCount;
        }
    }
}
