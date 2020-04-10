package cn.junwork.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/binary-tree-postorder-traversal/">145. Binary Tree Postorder Traversal</a>
 * <pre>
 * Given a binary tree, return the postorder traversal of its nodes' values.
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
 * Output: [3,2,1]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * </pre>
 *
 * @author coderjunjun@gmail.com
 * @date 2019-08-25
 */
public class Q145_BinaryTreePostorderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode cur = root;
        TreeNode last = null; // 上一个访问的节点
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            if (cur.right == null || cur.right == last) {
                // 当前节点没有右孩子,或者右孩子刚刚访问了
                // 说明该访问当前节点了
                result.add(cur.val);
                last = cur;
                cur = null;
            } else {
                // 当前节点右子树还没有访问
                // 把当前节点重新入栈,开始访问右子树
                stack.push(cur);
                cur = cur.right;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        new Q145_BinaryTreePostorderTraversal().postorderTraversal(root);
    }
}
