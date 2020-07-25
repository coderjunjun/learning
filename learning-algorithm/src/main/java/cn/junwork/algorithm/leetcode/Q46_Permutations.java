package cn.junwork.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode-cn.com/problems/permutations/">46. Permutations</a>
 * <pre>
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * </pre>
 *
 * @author coderjunjun@gmail.com
 * @date 2020/7/24
 */
public class Q46_Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0, result);
        return result;
    }

    private void permute(int[] nums, int i, List<List<Integer>> result) {
        if (i < nums.length) {
            for (int j = i; j < nums.length; ++j) {
                swap(nums, i, j);
                permute(nums, i + 1, result);
                swap(nums, i, j);
            }
        } else {
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new Q46_Permutations().permute(new int[]{1, 2, 3}));
    }
}
