package cn.junwork.algorithm.leetcode;

/**
 * <a href="https://leetcode.com/problems/find-the-duplicate-number/">287. Find the Duplicate Number</a>
 * <pre>
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 *
 * Example 1:
 *
 * Input: [1,3,4,2,2]
 * Output: 2
 * Example 2:
 *
 * Input: [3,1,3,4,2]
 * Output: 3
 * Note:
 *
 * 1.You must not modify the array (assume the array is read only).
 * 2.You must use only constant, O(1) extra space.
 * 3.Your runtime complexity should be less than O(n2).
 * 4.There is only one duplicate number in the array, but it could be repeated more than once.
 * </pre>
 *
 * @author coderjunjun@gmail.com
 * @date 2019-02-28
 */
public class Q287_FindDuplicateNumber {


    /**
     * 二分查找的思想，时间复杂度O(nlogn)
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int low = 1;
        int high = nums.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;
            int leftCount = 0;
            for (int num : nums) {
                if (low <= num && num <= mid) {
                    ++leftCount;
                }
            }

            if (leftCount > mid - low + 1) { //多余的数在左边
                high = mid;
            } else { //多余的数在右边
                low = mid + 1;
            }
        }

        return low;
    }


    /**
     * <p>单链表找环的思想，时间复杂度O(n)</p>
     * <p>
     *     思想：把元素值当做数组下标，即链表的指针，模型就转化为一个带有环的链表，问题转化为寻找这个环的入口
     * </p>
     * <p>
     *     方法：从头结点开始，fast指针每次前进两步，slow指针每次前进一步，当进入圆环后，可看做是fast在追赶slow，且每次距离都缩短1，所以一定会相遇，而不是跳过去。
     *          然后，根据相遇点和入口点将圆环分为b、c两段，设头结点到入口点的长度为a，可以推算出 a = (n-1)(b+c) + c ，其中n是相遇时fast已经跑过的圈数。
     * </p>
     *
     * @param nums
     * @return
     */
    int findDuplicate1(int[] nums) {
        if (nums.length > 1) {
            int slow = nums[0];
            int fast = nums[nums[0]];
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            fast = 0;
            while (fast != slow) {
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
        return -1;
    }
}
