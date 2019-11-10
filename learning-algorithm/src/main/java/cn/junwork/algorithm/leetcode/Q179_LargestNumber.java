package cn.junwork.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 *
 * 示例 1:
 * 输入: [10,2]
 * 输出: 210
 *
 * 示例 2:
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * </pre>
 *
 * @author chenjun1@corp.netease.com
 * @link https://cn.junwork.algorithm.leetcode-cn.com/problems/largest-number/description/
 * @date 2018/9/13
 */
public class Q179_LargestNumber {

    class Solution {

        public String largestNumber(int[] nums) {
            if (nums == null || nums.length == 0) return null;

            //转String数组
            List<String> numList = new ArrayList<>();
            for (int i = 0; i < nums.length; ++i) {
                numList.add(nums[i] + "");
            }

            List<String> tempList = new ArrayList<>();
            for (int i = 0; i < numList.size(); ++i) {
                String s = numList.get(i);
                int insertPos = 0;
                String max = build(tempList, null, 0);

                for (int j = 0; j <= tempList.size(); ++j) {
                    String tmp = build(tempList, s, j);
                    if (tmp.compareTo(max) > 0) {
                        max = tmp;
                        insertPos = j;
                    }
                }

                tempList.add(insertPos, s);
            }

            String result = build(tempList, null, 0);
            return result.charAt(0) == '0' ? "0" : result;
        }

        private String build(List<String> list, String s, int insertIndex) {
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i <= list.size(); ++i) {
                if (s != null && i == insertIndex) {
                    builder.append(s);
                }

                if (i < list.size()) {
                    builder.append(list.get(i));
                }
            }

            return builder.toString();
        }
    }


    public static void main(String[] args) {
//        Integer[] nums = new Integer[]{41, 23, 87, 55, 50, 53, 18, 9, 39, 63, 35, 33, 54, 25, 26, 49, 74, 61, 32, 81, 97, 99, 38, 96, 22, 95, 35, 57, 80, 80, 16, 22, 17, 13, 89, 11, 75, 98, 57, 81, 69, 8, 10, 85, 13, 49, 66, 94, 80, 25, 13, 85, 55, 12, 87, 50, 28, 96, 80, 43, 10, 24, 88, 52, 16, 92, 61, 28, 26, 78, 28, 28, 16, 1, 56, 31, 47, 85, 27, 30, 85, 2, 30, 51, 84, 50, 3, 14, 97, 9, 91, 90, 63, 90, 92, 89, 76, 76, 67, 55};
//        System.out.println(nums.length);
//        System.out.println(new HashSet<>(Arrays.asList(nums)).size());

        Solution solution = (new Q179_LargestNumber()).new Solution();
        System.out.println(solution.largestNumber(new int[]{41, 23, 87, 55, 50, 53, 18, 9, 39, 63, 35,
                33, 54, 25, 26, 49, 74, 61, 32, 81, 97, 99, 38, 96, 22, 95, 35, 57, 80, 80, 16, 22, 17,
                13, 89, 11, 75, 98, 57, 81, 69, 8, 10, 85, 13, 49, 66, 94, 80, 25, 13, 85, 55, 12, 87, 50,
                28, 96, 80, 43, 10, 24, 88, 52, 16, 92, 61, 28, 26, 78, 28, 28, 16, 1, 56, 31, 47, 85, 27,
                30, 85, 2, 30, 51, 84, 50, 3, 14, 97, 9, 91, 90, 63, 90, 92, 89, 76, 76, 67, 55}));
    }
}
