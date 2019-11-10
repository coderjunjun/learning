package cn.junwork.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/">448. Find All Numbers Disappeared in an Array</a>
 * <pre>
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 *
 * Example:
 *
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [5,6]
 * </pre>
 *
 * @author coderjunjun@gmail.com
 * @date 2019-02-28
 */
public class Q448_FindNumbersDisappeared {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        int i = 0;
        while (i < nums.length) {
            if (nums[i] > 0) {
                //暂存该数对应下标位置的数
                int temp = nums[nums[i] - 1];
                //该数对应下标位置标记为0，表示该数存在
                nums[nums[i] - 1] = 0;
                //当前数对应的位置就是当前位置，不做后续处理，否则会无限循环
                if (nums[i] != 0) {
                    if (temp > 0) {
                        //是一个数则交换过来，继续循环
                        nums[i] = temp;
                    } else {
                        //否则用-1标记该位置的数空缺
                        nums[i] = -1;
                    }
                }
            }
            if (nums[i] == 0 || nums[i] == -1) {
                ++i;
            }
        }

        //取-1标记的下标对应的数
        for (i = 0; i < nums.length; ++i) {
            if (nums[i] == -1) {
                result.add(i + 1);
            }
        }

        return result;
    }
}
