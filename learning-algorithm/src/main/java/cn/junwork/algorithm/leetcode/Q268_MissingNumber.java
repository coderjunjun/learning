package cn.junwork.algorithm.leetcode;

/**
 * <a href="https://leetcode.com/problems/missing-number/">268. Missing Number</a>
 * <pre>
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * Example 1:
 *
 * Input: [3,0,1]
 * Output: 2
 * Example 2:
 *
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 * </pre>
 *
 * @author coderjunjun@gmail.com
 * @date 2019-02-28
 */
public class Q268_MissingNumber {

    public int missingNumber(int[] nums) {
        int result = 0;
        if (nums == null || nums.length == 0) {
            return result;
        }

        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return (n * n + n) / 2 - sum;
    }
}
