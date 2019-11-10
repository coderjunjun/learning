package cn.junwork.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

import static cn.junwork.algorithm.common.util.Printer.println;

/**
 * <a href="https://leetcode.com/problems/longest-harmonious-subsequence/description/">594. Longest Harmonious Subsequence</a>
 * <pre>
 *We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.
 *
 * Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.
 *
 * Example 1:
 * Input: [1,3,2,2,5,2,3,7]
 * Output: 5
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 * 
 * Note: The length of the input array will not exceed 20,000.
 * </pre>
 */
public class Q594_LongestHarmoniousSubsequence {
    
    public int findLHS(int[] nums) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        //先统计每个数出现的次数
        for (int n : nums) {
            Integer c = map.get(n);
            if (c == null) c = 0;
            ++c;
            map.put(n, c);
        }
    
        for (int n : nums) {
            Integer ec = map.get(n);       //当前数字的出现次数
            Integer gc = map.get(n + 1);   //比它大1的数字的出现次数
            if (gc != null && max < gc + ec) {
                max = gc + ec;
            }
        }
        
        return max;
    }
    
    
    public static void main(String[] args) {
        Q594_LongestHarmoniousSubsequence s = new Q594_LongestHarmoniousSubsequence();
        println(s.findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
        println(s.findLHS(new int[]{1, 1, 1, 1}));
    }
}
