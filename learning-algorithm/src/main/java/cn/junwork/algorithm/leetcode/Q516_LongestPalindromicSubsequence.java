package cn.junwork.algorithm.leetcode;

/**
 * <a href="https://leetcode.com/problems/longest-palindromic-subsequence/description/">516. Longest Palindromic Subsequence</a>
 * <p>Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.</p>
 * Input: "bbbab"
 * <br/>
 * Output: 4
 */
public class Q516_LongestPalindromicSubsequence {
    public static void main(String[] args) {
        System.out.println(new Q516_LongestPalindromicSubsequence().longestPalindromeSubseq("bbbab"));
        System.out.println(new Q516_LongestPalindromicSubsequence().longestPalindromeSubseq("cbbd"));
    }
    
    
    /**
     * 动态规划的方法
     *
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        return longestPalindromeSubseq(s, 0, s.length() - 1, new int[s.length()][s.length()]);
    }
    
    
    private int longestPalindromeSubseq(String s, int l, int r, int[][] resultCache) {
        int count;
        
        if (r < l) return 0;
        if (r == l) return 1;
        if (resultCache[l][r] > 0) return resultCache[l][r];
        
        if (s.charAt(l) == s.charAt(r)) { //左右两端字符相等，直接“消除”
            count = longestPalindromeSubseq(s, l + 1, r - 1, resultCache) + 2;
        } else {
            //分 包含s[l] 和 不包含s[l] 两种情况，取结果较大者
            //即：f(s, l, r) = max[f(s, l, lastIndexOf(s[l]), f(s, l+1, r)]
            count = Math.max(longestPalindromeSubseq(s, l, s.lastIndexOf(s.charAt(l), r), resultCache), longestPalindromeSubseq(s, l + 1, r, resultCache));
        }
        
        resultCache[l][r] = count;
        return count;
    }
    
    
    /**
     * 最先尝试的暴力法，毫不意外的TLE了
     *
     * @param s
     * @return
     */
    public int lpsViolent(String s) {
        for (int k = s.length(); k > 1; --k) {
            if (combination(s, k)) return k;
        }
        return 1;
    }
    
    
    private boolean combination(String s, int k) {
        int n = s.length();
        if (k > n) return false;
        
        //当前组合的k个元素的索引
        int[] indexs = new int[k];
        
        //第一个组合就是前k个元素
        for (int i = 0; (indexs[i] = i) < k - 1; ++i) ;
        if (isPalindrome(s, indexs)) {
            return true;
        }
        
        for (; ; ) {
            int i;
            //从后往前，寻找还能往后移动的索引
            for (i = k - 1; i >= 0 && indexs[i] + k - i == n; --i) ;
            if (i < 0) break;  //没有可以移动的了
            
            //移动
            ++indexs[i];
            //填充后面的（递增）
            for (++i; i < k; ++i) {
                indexs[i] = indexs[i - 1] + 1;
            }
            
            if (isPalindrome(s, indexs)) {
                return true;
            }
        }
        
        return false;
    }
    
    
    private boolean isPalindrome(String str, int[] indexs) {
        for (int i = 0, j = indexs.length - 1; j > i; ++i, --j) {
            if (str.charAt(indexs[i]) != str.charAt(indexs[j])) return false;
        }
        
        return true;
    }
}
