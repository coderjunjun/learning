//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 696 👎 0

package cn.junwork.algorithm.leetcode.editor.cn;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Q_102 {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        ConcurrentHashMap concurrentHashMap;
        (new Q_102()).new Solution()
        ;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> result;
        public List<List<Integer>> levelOrder(TreeNode root) {
            result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            travelRecursive(Arrays.asList(root));
            return result;
        }

        private void travelRecursive(List<TreeNode> nodes) {
            if (nodes == null || nodes.size() == 0) {
                return;
            }
            List<TreeNode> nextLevelNodes = new ArrayList<>();
            List<Integer> levelNums = new ArrayList<>();
            for (TreeNode node : nodes) {
                levelNums.add(node.val);
                if (node.left != null) {
                    nextLevelNodes.add(node.left);
                }
                if (node.right != null) {
                    nextLevelNodes.add(node.right);
                }
            }
            result.add(levelNums);
            travelRecursive(nextLevelNodes);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}