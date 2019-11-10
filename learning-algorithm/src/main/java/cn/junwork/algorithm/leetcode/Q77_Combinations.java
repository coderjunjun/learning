package cn.junwork.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/combinations/">77. Combinations</a>
 * <pre>
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * Example:
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * </pre>
 *
 * @author coderjunjun@gmail.com
 * @date 2019-09-10
 */
public class Q77_Combinations {

    /**
     * 方法一: 递归+回溯, 单向的从前往后选择数字, 就不会出现重复的
     */
    static class solution1 {
        public List<List<Integer>> combine(int n, int k) {
            return combine(1, n, k, new ArrayList<>(), new ArrayList<>());
        }

        private List<List<Integer>> combine(int i, int n, int k, List<List<Integer>> result, List<Integer> cb) {
            if (cb.size() == k) {
                result.add(new ArrayList<>(cb));
                return result;
            }

            for (int cur = i; cur <= n; ++cur) {
                cb.add(cur);
                combine(cur + 1, n, k, result, cb);
                cb.remove(cb.size() - 1);
            }

            return result;
        }

    }

    /**
     * 方法二: 选择的过程一样, 只是递归换成了循环(移动下标)
     * @see cn.junwork.algorithm.other.math.Combination
     */
    static class solution2 {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> result = new ArrayList<>();

            List<Integer> cmb = IntStream.rangeClosed(1, k).boxed().collect(Collectors.toList());
            boolean moved = true;

            while (moved) {
                result.add(new ArrayList<>(cmb));
                moved = false;
                for (int i = cmb.size() - 1; i >= 0; i--) {
                    if (cmb.get(i) < n - k + i + 1) {
                        cmb.set(i, cmb.get(i) + 1);
                        for (int j = i + 1; j < cmb.size(); ++j) {
                            cmb.set(j, cmb.get(j - 1) + 1);
                        }
                        moved = true;
                        break;
                    }
                }
            }

            return result;
        }
    }



    public static void main(String[] args) {
        System.out.println(new solution1().combine(4, 3));
        System.out.println(new solution2().combine(4, 3));
    }
}
