package cn.junwork.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters/
 */
public class Q395_LongestSubstring {

    public static void main(String[] args) {
        System.out.println(new Q395_LongestSubstring().longestSubstring("ababbc", 2));
    }


    /**
     * 方法1: 找出不满足条件都字符，以该字符分割为子串，然后递归处理
     */
    public int longestSubstring2(String s, int k) {
        if (s == null || s.length() == 0 || s.length() < k) {
            return 0;
        }

        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        String target = null;
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() < k) {
                target = entry.getKey() + "";
                break;
            }
        }

        if (target == null) {
            return s.length();
        }

        int max = 0;
        for (String sp : s.split(target)) {
            max = Math.max(max, longestSubstring(sp, k));
        }
        return max;
    }


    /**
     * 方法2: 因为题目最多只有26种字符，所以可以枚举字符种类数量，在限定了字符种类数量的前提下，就可以使用双指针做滑动窗口了
     */
    public int longestSubstring(String s, int k) {
        int maxLen = 0;
        for (int maxTypeCount = 1; maxTypeCount <= Math.min(26, s.length()); maxTypeCount++) {
            int l = 0;
            int r = 0;
            int typeCount = 0;
            int validCount = 0;
            Map<Character, Integer> countMap = new HashMap<>();
            while (l <= r && r < s.length()) {
                while (r < s.length() && typeCount <= maxTypeCount) {
                    int newCount = countMap.getOrDefault(s.charAt(r), 0) + 1;
                    countMap.put(s.charAt(r), newCount);
                    if (newCount == 1) {
                        ++typeCount;
                    }
                    if (newCount == k) {
                        ++validCount;
                    }
                    if (validCount == typeCount) {
                        maxLen = Math.max(maxLen, r - l + 1);
                    }
                    ++r;
                }
                while (r < s.length() && l <= r && typeCount > maxTypeCount) {
                    int newCount = countMap.get(s.charAt(l)) - 1;
                    countMap.put(s.charAt(l), newCount);
                    if (newCount == 0) {
                        --typeCount;
                    }
                    if (newCount == k - 1) {
                        --validCount;
                    }
                    if (validCount == typeCount) {
                        maxLen = Math.max(maxLen, r - l + 1);
                    }
                    ++l;
                }
            }
        }
        return maxLen;
    }
}
