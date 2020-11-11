package cn.junwork.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode-cn.com/problems/two-sum/">1. Two Sum</a>
 * <pre>
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *  
 *
 * Constraints:
 *
 * 2 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 * </pre>
 *
 * @author coderjunjun@gmail.com
 * @date 2020/11/7
 */
public class Q1_TwoSum {

    public int[] twoSum1(int[] nums, int target) {
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);
        int l = 0, r = sortedNums.length - 1;
        int[] resultNum = new int[2];
        while (l < r) {
            if (sortedNums[l] + sortedNums[r] < target) {
                ++l;
            } else if (sortedNums[l] + sortedNums[r] > target) {
                --r;
            } else {
                resultNum = new int[]{sortedNums[l], sortedNums[r]};
                break;
            }
        }

        l = -1;
        r = -1;
        for (int i = 0; i < nums.length; i++) {
            if (l < 0 && nums[i] == resultNum[0]) {
                l = i;
            } else if (r < 0 && nums[i] == resultNum[1]) {
                r = i;
            }
        }
        return new int[]{l, r};
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> matchIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            matchIndexMap.put(target - nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer matchedIndex = matchIndexMap.get(nums[i]);
            if (matchedIndex != null && matchedIndex != i) {
                return new int[]{i, matchedIndex};
            }
        }
        return null;
    }
}
