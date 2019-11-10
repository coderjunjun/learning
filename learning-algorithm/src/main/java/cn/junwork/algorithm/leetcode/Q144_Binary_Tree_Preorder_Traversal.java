package cn.junwork.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/binary-tree-preorder-traversal/">144. Binary Tree Preorder Traversal</a>
 * <pre>
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,2,3]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * </pre>
 *
 * @author coderjunjun@gmail.com
 * @date 2019-08-25
 */
public class Q144_Binary_Tree_Preorder_Traversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || cur != null) {
            // 一直访问左子树并入栈，直到左下角
            while (cur != null) {
                result.add(cur.val); // 访问
                stack.push(cur);
                cur = cur.left;
            }
            // 弹出栈顶节点，处理它的右子树
            if (!stack.isEmpty()) {
                cur = stack.pop().right;
            }
        }

        return result;
    }
}
