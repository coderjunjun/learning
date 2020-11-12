//给一个嵌套整数序列，请你返回每个数字在序列中的加权和，它们的权重由它们的深度决定。 
//
// 序列中的每一个元素要么是一个整数，要么是一个序列（这个序列中的每个元素也同样是整数或序列）。 
//
// 与 前一个问题 不同的是，前一题的权重按照从根到叶逐一增加，而本题的权重从叶到根逐一增加。 
//
// 也就是说，在本题中，叶子的权重为1，而根拥有最大的权重。 
//
// 示例 1: 
//
// 输入: [[1,1],2,[1,1]]
//输出: 8 
//解释: 四个 1 在深度为 1 的位置， 一个 2 在深度为 2 的位置。
// 
//
// 示例 2: 
//
// 输入: [1,[4,[6]]]
//输出: 17 
//解释: 一个 1 在深度为 3 的位置， 一个 4 在深度为 2 的位置，一个 6 在深度为 1 的位置。 1*3 + 4*2 + 6*1 = 17。
// 
// Related Topics 深度优先搜索 
// 👍 39 👎 0

package cn.junwork.algorithm.leetcode.editor.cn;

import java.util.*;

public class Q_364 {
    public static void main(String[] args) {
        (new Q_364()).new Solution()

        ;
    }


    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int maxDepth;
        private int sum;

        public int depthSumInverse(List<NestedInteger> nestedList) {
            maxDepth = 0;
            sum = 0;
            findMaxDepth(nestedList, 1);
            recursiveSum(nestedList, maxDepth);
            return sum;
        }

        private void findMaxDepth(List<NestedInteger> nestedList, int depth) {
            maxDepth = Math.max(maxDepth, depth);
            for (NestedInteger nestedInteger : nestedList) {
                if (!nestedInteger.isInteger()) {
                    findMaxDepth(nestedInteger.getList(), depth + 1);
                }
            }
        }

        private void recursiveSum(List<NestedInteger> nestedList, int depth) {
            for (NestedInteger nestedInteger : nestedList) {
                if (nestedInteger.isInteger()) {
                    sum += depth * nestedInteger.getInteger();
                } else {
                    recursiveSum(nestedInteger.getList(), depth - 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}