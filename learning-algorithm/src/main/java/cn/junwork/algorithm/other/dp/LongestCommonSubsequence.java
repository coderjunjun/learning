package cn.junwork.algorithm.other.dp;


import cn.junwork.algorithm.leetcode.Q516_LongestPalindromicSubsequence;

/**
 * <a href="http://www.lintcode.com/en/problem/longest-common-subsequence/">Longest Common Subsequence</a>
 * <pre>
 * Given two strings, find the longest cn.junwork.algorithm.common subsequence (LCS).
 *
 * Your code should return the length of LCS.
 *
 * Have you met this question in a real interview? Yes
 * Clarification
 * What's the definition of Longest Common Subsequence?
 *
 * https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
 * http://baike.baidu.com/view/2020307.htm
 *
 * Example
 * For "ABCD" and "EDCA", the LCS is "A" (or "D", "C"), return 1.
 *
 * For "ABCD" and "EACB", the LCS is "AC", return 2.
 * </pre>
 */
public class LongestCommonSubsequence {
    
    /**
     * @param A, B: Two strings.
     * @return: The length of longest cn.junwork.algorithm.common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        int[][] cache = new int[A.length()][B.length()];
        return lcs(cache, A, B, 0, 0);
    }
    
    
    /**
     * 这个递推方法跟 {@link Q516_LongestPalindromicSubsequence} 一样，对于 {@code s1} 中的每一个字符，
     * 分两种情况：
     * <p>
     * 1.放入LCS
     * 2.丢弃
     * <p>
     * 取最终结果较大者
     *
     * @param cache
     * @param s1
     * @param s2
     * @param l1 s1的实际起始位置
     * @param l2 s2的实际起始位置
     * @return
     */
    private int lcs(int[][] cache, String s1, String s2, int l1, int l2) {
        if (l1 == s1.length() || l2 == s2.length()) return 0; //递归出口
        if (cache[l1][l2] > 0) return cache[l1][l2];
        
        int result = 0;
        int ib = s2.indexOf(s1.charAt(l1), l2);
        if (ib != -1) { //如果当前字符在s2中存在
            result = 1 + lcs(cache, s1, s2, l1 + 1, ib + 1);  //将当前字符计入LCS（长度加1），递归计算
        }
        result = Math.max(result, lcs(cache, s1, s2, l1 + 1, l2)); //跟丢弃当前字符的结果作比较，取较大值
        cache[l1][l2] = result;
        
        return result;
    }
    
    
    /**
     * @param A, B: Two strings.
     * @return: The length of longest cn.junwork.algorithm.common subsequence of A and B.
     */
    public int longestCommonSubsequence1(String A, String B) {
        int[][] cache = new int[A.length()][B.length()];
        return lcs1(cache, A, B, A.length() - 1, B.length() - 1);
    }


    /**
     * 这是比较标准的LCS递推方法：
     * <pre>
     *     lcs[i][j] = 1 + lcs[i-1][j-1], a[i] = b[j]
     *                 max(lcs[i-1,j], lcs[i][j-1]), a[i] != b[j]
     * </pre>
     * 其中lcs[i][j]表示 a0 a1...ai 与 b0 b1...bj 的LCS长度
     *
     * @param cache
     * @param a
     * @param b
     * @param i
     * @param j
     * @return
     */
    private int lcs1(int[][] cache, String a, String b, int i, int j) {
        if (i < 0 || j < 0) return 0;
        if (cache[i][j] > 0) return cache[i][j];

        int result;
        if (a.charAt(i) == b.charAt(j)) {
            result = 1 + lcs1(cache, a, b, i - 1, j - 1);
        } else {
            result = Math.max(lcs1(cache, a, b, i - 1, j), lcs1(cache, a, b, i, j - 1));
        }
        cache[i][j] = result;

        return result;
    }


    /**
     * @param A, B: Two strings.
     * @return: A longest cn.junwork.algorithm.common subsequence of A and B.
     */
    public String getLcs(String A, String B) {
        String[][] cache = new String[A.length()][B.length()];
        return lcs(cache, A, B, A.length() - 1, B.length() - 1);
    }


    /**
     * 返回一个LCS字符串，而不是长度
     * @param cache
     * @param a
     * @param b
     * @param i
     * @param j
     * @return
     */
    private String lcs(String[][] cache, String a, String b, int i, int j) {
        if (i < 0 || j < 0) return "";
        if (cache[i][j] != null) return cache[i][j];

        String result;
        if (a.charAt(i) == b.charAt(j)) {
            result = lcs(cache, a, b, i - 1, j - 1) + a.charAt(i);
        } else {
            String r1 = lcs(cache, a, b, i - 1, j);
            String r2 = lcs(cache, a, b, i, j - 1);
            result = r1.length() > r2.length() ? r1 : r2;
        }
        cache[i][j] = result;

        return result;
    }
}
