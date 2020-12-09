//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2620 👎 0

package cn.junwork.algorithm.leetcode.editor.cn;

import java.util.*;

public class Q_53 {
    public static void main(String[] args) {
        System.out.println((new Q_53()).new Solution()
                .maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}))
        ;
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            max = Math.max(sum, max);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}