package cn.junwork.algorithm.leetcode;

/**
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">3. Longest Substring Without Repeating Characters</a>
 * <pre>
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * </pre>
 *
 * @author coderjunjun@gmail.com
 * @date 2020/4/10
 */
public class Q3_LongestSubstrWithoutRepeatingChars {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        int max = 0;
        Integer[] posMap = new Integer[256];
        for (int head = 0, tail = 0; head < s.length(); ++head) {
            if (posMap[s.charAt(head)] != null) {
                int newTail = posMap[s.charAt(head)] + 1;
                for (int i = tail; i < newTail; ++i) {
                    posMap[s.charAt(i)] = null;
                }
                tail = newTail;
            }
            posMap[s.charAt(head)] =  head;
            max = Math.max(max, head - tail + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Q3_LongestSubstrWithoutRepeatingChars().lengthOfLongestSubstring("abba"));
    }
}
