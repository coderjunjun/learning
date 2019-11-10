package cn.junwork.algorithm.leetcode;

/**
 * <a href="https://leetcode.com/problems/single-number/description/">136. Single Number</a>
 * <p>
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class Q136_SingleNumberI {
    
    /**
     * 这个实现方法的理论依据是：
     * <p>
     * 1.任何数异或0得其自身
     * <p>
     * 2.任何数异或自身得0
     * <p>
     * 3.异或满足交换律
     */
    public int singleNumber(int[] nums) {
        int x = 0;
        for (int e : nums) x ^= e;
        return x;
    }
}
