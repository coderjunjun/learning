//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 849 👎 0

package cn.junwork.algorithm.leetcode.editor.cn;

import java.util.*;

public class Q_152 {
    public static void main(String[] args) {
        System.out.println((new Q_152()).new Solution()
        .maxProduct(new int[]{2,3,-2,4}))
        ;
        System.out.println((new Q_152()).new Solution()
        .maxProduct(new int[]{-2,0,-1}))
        ;
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        int mul = 1, firstNegMul = 1;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            mul *= num;
            max = Math.max(mul, max);
            if (mul < 0) {
                if (firstNegMul == 1) {
                    firstNegMul = mul;
                } else {
                    max = Math.max(max, mul / firstNegMul);
                }
            } else if (mul == 0) {
                mul = 1;
                firstNegMul = 1;
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}