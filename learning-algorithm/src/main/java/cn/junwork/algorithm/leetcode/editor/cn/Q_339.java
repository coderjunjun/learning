//给定一个嵌套的整数列表，请返回该列表按深度加权后所有整数的总和。 
//
// 每个元素要么是整数，要么是列表。同时，列表中元素同样也可以是整数或者是另一个列表。 
//
// 示例 1: 
//
// 输入: [[1,1],2,[1,1]]
//输出: 10 
//解释: 因为列表中有四个深度为 2 的 1 ，和一个深度为 1 的 2。 
//
// 示例 2: 
//
// 输入: [1,[4,[6]]]
//输出: 27 
//解释: 一个深度为 1 的 1，一个深度为 2 的 4，一个深度为 3 的 6。所以，1 + 4*2 + 6*3 = 27。 
// Related Topics 深度优先搜索 
// 👍 36 👎 0

package cn.junwork.algorithm.leetcode.editor.cn;

import java.util.*;

public class Q_339 {
    public static void main(String[] args) {
        (new Q_339()).new Solution()

        ;
    }

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    interface NestedInteger {
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
        private int sum = 0;

        public int depthSum(List<NestedInteger> nestedList) {
            sum = 0;
            recursiveSum(nestedList, 1);
            return sum;
        }

        private void recursiveSum(List<NestedInteger> nestedList, int depth) {
            for (NestedInteger nestedInteger : nestedList) {
                if (nestedInteger.isInteger()) {
                    sum += depth * nestedInteger.getInteger();
                } else {
                    recursiveSum(nestedInteger.getList(), depth + 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}