package cn.junwork.algorithm.leetcode;

/**
 * <a href="https://leetcode.com/problems/edit-distance/discuss/25849/Java-DP-solution-O(nm)">72. Edit Distance</a>
 * <pre>
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 *
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 * </pre>
 *
 * @author coderjunjun@gmail.com
 * @date 2019-03-13
 */
public class Q72_EditDistance {

    /**
     * <pre>
     *     先定义一个函数 f(i, j) = 将 word1 的前i个字符转换到 word2 的前j个字符的最少操作步骤，然后有：
     *     1.如果 word1[i] 正好等于 word2[j]，那么 f(i, j) == f(i - 1, j - 1)
     *     2.要搞出 word2[j]，有三种方案：
     *       1) 直接在 f(i, j - 1) 的基础上插入 word2[j]
     *       2) 在 f(i - 1, j) 的基础上删除 word1[i]
     *       3) 在 f(i - 1, j - 1) 的基础上替换 word1[i]
     * </pre>
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int[][] minDist = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); ++i) {
            for (int j = 0; j <= word2.length(); ++j) {
                if (i == 0 || j == 0) {
                    minDist[i][j] = Math.max(i, j);
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    minDist[i][j] = minDist[i - 1][j - 1];
                } else {
                    //性能太差
                    //minDist[i][j] = 1 + Stream.of(minDist[i][j - 1], minDist[i - 1][j], minDist[i - 1][j - 1]).min(Comparator.comparingInt(Integer::intValue)).get();
                    minDist[i][j] = 1 + Math.min(minDist[i][j - 1], Math.min(minDist[i - 1][j], minDist[i - 1][j - 1]));
                }
            }
        }
        return minDist[word1.length()][word2.length()];
    }
}
