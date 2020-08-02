package cn.junwork.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode-cn.com/problems/permutations-ii/">47. Permutations II</a>
 * <pre>
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * Example:
 *
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 * </pre>
 *
 * @author coderjunjun@gmail.com
 * @date 2020/7/31
 */
public class Q47_PermutationsII {
    public static void main(String[] args) {
        System.out.println(new Q47_PermutationsII().permuteUnique(new int[]{1, 1, 2}));
    }

    /**
     * 基本思想：一个坑位不能重复选择相同的数
     * 跟{@link Q46_Permutations }不一样的是不采用交换位置的方法了，
     * 而是采用标记法，所以先把数组排序，从前往后选择，这样每个坑位就能判断是否跟上一轮选择的数一样
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        return permute(nums, new boolean[nums.length], new ArrayList<>(), new ArrayList<>());
    }

    private List<List<Integer>> permute(int[] nums, boolean[] visited,
                                        List<List<Integer>> result, List<Integer> curList) {
        if (curList.size() == nums.length) {
            result.add(new ArrayList<>(curList));
        } else {
            for (int i = 0; i < nums.length; ++i) {
                if (visited[i]) {
                    continue;
                }
                // 如果跟上一轮选择的数一样
                if (i > 0 && nums[i] == nums[i - 1]
                        && !visited[i - 1]) {
                    continue;
                }
                curList.add(nums[i]);
                visited[i] = true;
                permute(nums, visited, result, curList);
                curList.remove(curList.size() - 1);
                visited[i] = false;
            }
        }
        return result;
    }
}
