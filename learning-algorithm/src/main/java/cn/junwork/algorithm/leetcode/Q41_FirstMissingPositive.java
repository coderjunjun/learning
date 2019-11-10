package cn.junwork.algorithm.leetcode;

/**
 *
 * <a href="https://leetcode.com/problems/first-missing-positive/">41. First Missing Positive</a>
 * <pre>
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * Example 1:
 *
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 *
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 *
 * Input: [7,8,9,11,12]
 * Output: 1
 * Note:
 *
 * Your algorithm should run in O(n) time and uses constant extra space.
 * </pre>
 *
 * @author coderjunjun@gmail.com
 * @date 2019-02-22
 */
public class Q41_FirstMissingPositive {

    /**
     * 核心思路：n个数顶多能占据前n个正数，所以可以用原数组来标记
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) return 1;
        //最大值
        int max = 0;
        //存在标记
        final int FLAG = -1;
        //小于0的全部转为0（避免和FLAG冲突）
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < 0) nums[i] = 0;
        }

        for (int i = 0; i < nums.length; ) {
            int num = nums[i];
            if (num > max) max = num;
            if (1 <= num && num <= nums.length) {
                int temp = nums[num - 1];
                //在该数对应下标处做标记，表示该数存在
                nums[num - 1] = FLAG;
                //把那个位置原本的数交换过来，继续循环
                if (i != num - 1 && temp != FLAG) {
                    nums[i] = temp;
                    continue;
                }
            }
            ++i;
        }

        //遍历，找出第一个没有标记的位置，对应的数就是缺失的数
        int missing = max + 1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != FLAG) {
                missing = i + 1;
                break;
            }
        }

        return missing;
    }

}
