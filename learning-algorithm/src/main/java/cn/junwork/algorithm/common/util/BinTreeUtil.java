package cn.junwork.algorithm.common.util;

import java.util.ArrayList;
import java.util.List;

import cn.junwork.algorithm.common.struct.BinTree.Node;

/**
 * Created by Jun on 2017/6/6.
 */
public class BinTreeUtil {
    
    public static Node createByPreAndIn(int[] preOrder, int[] midOrder, int pl, int pr, int ml, int mr) {
        if (pr < pl) return null;
        
        int rootValue = preOrder[pl];
        Node root = new Node(rootValue);
        
        int pivotIndex = -1;
        for (int i = ml; i <= mr; ++i) {
            if (midOrder[i] == rootValue) {
                pivotIndex = i;
                break;
            }
        }
        System.out.println("Pivot: " + pivotIndex);
        
        int leftChildCount = pivotIndex - ml;
        int rightChildCount = mr - pivotIndex;
        
        root.lchild = createByPreAndIn(preOrder, midOrder, pl + 1, pl + leftChildCount, ml, pivotIndex - 1);
        root.rchild = createByPreAndIn(preOrder, midOrder, pr - rightChildCount + 1, pr, mr - rightChildCount + 1, mr);
        
        return root;
    }
    
    public static Node createByInAndPost(int[] midOrder, int[] postOrder, int ml, int mr, int pl, int pr) {
        if (pr < pl) return null;
        
        int rootValue = postOrder[pr];
        Node root = new Node(rootValue);
        
        int pivotIndex = -1;
        for (int i = ml; i <= mr; ++i) {
            if (midOrder[i] == rootValue) {
                pivotIndex = i;
                break;
            }
        }
//       System.out.println("Pivot: " + pivotIndex);
        
        int leftChildCount = pivotIndex - ml;
        int rightChildCount = mr - pivotIndex;
        
        root.lchild = createByInAndPost(midOrder, postOrder, ml, pivotIndex - 1, pl, pl + leftChildCount - 1);
        root.rchild = createByInAndPost(midOrder, postOrder, mr - rightChildCount + 1, mr, pr - rightChildCount, pr - 1);
        
        return root;
    }
    
    
    public static void printGraph(List<GraphNode> gnodes) {
        if (gnodes.isEmpty()) return;
        
        List<GraphNode> nextLevelGnodes = new ArrayList<>();
        int offset = 0;
        
        for (GraphNode gnode : gnodes) {
            printValue(gnode.xOffset - offset - 1, gnode.node.value);
            offset = gnode.xOffset;
            
            if (gnode.node.lchild != null) {
                GraphNode lchildGnode = new GraphNode(gnode.node.lchild, gnode.xOffset - 3);
                nextLevelGnodes.add(lchildGnode);
            }
            
            if (gnode.node.rchild != null) {
                GraphNode rchildGnode = new GraphNode(gnode.node.rchild, gnode.xOffset + 3);
                nextLevelGnodes.add((rchildGnode));
            }
        }
        
        System.out.println();
        
        printGraph(nextLevelGnodes);
    }
    
    private static void printValue(int xPos, int value) {
        StringBuilder fillerBuilder = new StringBuilder();
        while (xPos-- > 0) {
            fillerBuilder.append(" ");
        }
        System.out.print(fillerBuilder.toString() + value);
    }
    
    
    public static void printPreOrder(Node root) {
        if (root == null) return;
        
        System.out.print(root.value + " ");
        printPreOrder(root.lchild);
        printPreOrder(root.rchild);
    }
    
    public static void printInOrder(Node root) {
        if (root == null) return;
        
        printInOrder(root.lchild);
        System.out.print(root.value + " ");
        printInOrder(root.rchild);
    }
    
    public static void printPostOrder(Node root) {
        if (root == null) return;
        
        printPostOrder(root.lchild);
        printPostOrder(root.rchild);
        System.out.print(root.value + " ");
    }
    
    
    public static class GraphNode {
        public Node node;
        public int xOffset;
        
        public GraphNode(Node node, int xOffset) {
            this.node = node;
            this.xOffset = xOffset;
        }
    }
}
