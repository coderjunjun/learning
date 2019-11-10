package cn.junwork.algorithm.leetcode;


/**
 * <a href="https://leetcode.com/problems/permutation-sequence/">60. Permutation Sequence</a>
 * <pre>
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 * Note:
 *
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * Example 1:
 *
 * Input: n = 3, k = 3
 * Output: "213"
 * Example 2:
 *
 * Input: n = 4, k = 9
 * Output: "2314"
 * </pre>
 *
 * @author coderjunjun@gmail.com
 * @date 2019-09-06
 */
public class Q60_PermutationSequence {

    public String getPermutation(int n, int k) {
        // 用来标记哪些数已经被选择了
        // 也可以使用ArrayList + remove操作来实现
        boolean[] flags = new boolean[n + 1];
        // 用于快速查阶乘
        int[] facts = new int[n];
        facts[0] = 1;
        for (int i = 1; i < n; ++i) {
            facts[i] = facts[i - 1] * i;
        }

        StringBuilder result = new StringBuilder();
        // 为了统一从0开始，序号k转换成k-1
        permutation(flags, facts, n, k - 1, result);
        return result.toString();
    }

    private void permutation(boolean[] flags, int[] facts, int n, int k, StringBuilder s) {
        if (n == 0) {
            return;
        }

        // 从全排列顺序来看，首位总是以周期(n-1)!在迭代
        int period = facts[n - 1];
        // 因此可以直接求出首位字符在n个数中的序号
        int index = k / period;

        // 根据序号，找出实际的数（注意已经被选择过的数要跳过，这就是flags的作用）
        int i = -1, j = 0;
        while (i < index) {
            if (!flags[++j]) ++i;
        }

        // 首位字符被确定
        s.append(j);
        // 标记该数已被选择
        flags[j] = true;

        // 递归处理剩下的n-1位
        permutation(flags, facts, n - 1, k % period, s);
    }


    public static void main(String[] args) {
        System.out.println(new Q60_PermutationSequence().getPermutation(4, 9));
    }
}
