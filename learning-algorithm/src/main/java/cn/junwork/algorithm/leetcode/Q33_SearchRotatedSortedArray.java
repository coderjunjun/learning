package cn.junwork.algorithm.leetcode;

/**
 * <a href="https://leetcode-cn.com/problems/search-in-rotated-sorted-array/">33. Search in Rotated Sorted Array</a>
 * <pre>
 * You are given an integer array nums sorted in ascending order, and an integer target.
 *
 * Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * If target is found in the array return its index, otherwise, return -1.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * Example 3:
 *
 * Input: nums = [1], target = 0
 * Output: -1
 *  
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * All values of nums are unique.
 * nums is guranteed to be rotated at some pivot.
 * -10^4 <= target <= 10^4
 * </pre>
 *
 * @author coderjunjun@gmail.com
 * @date 2020/10/8
 */
public class Q33_SearchRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums[0] > nums[nums.length - 1]) {
            int pivot = SearchPivot(nums, 0, nums.length - 1);
            return target >= nums[0] ? binarySearch(nums, 0, pivot, target) : binarySearch(nums, pivot + 1, nums.length - 1, target);
        } else {
            return binarySearch(nums, 0, nums.length - 1, target);
        }
    }

    private int SearchPivot(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        if (mid > 0 && nums[mid] < nums[mid - 1]) {
            return mid - 1;
        } else if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
            return mid;
        } else if (nums[mid] < nums[0]) {
            return SearchPivot(nums, low, mid - 1);
        } else {
            return SearchPivot(nums, mid + 1, high);
        }
    }

    private int binarySearch(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return binarySearch(nums, low, mid - 1, target);
        } else {
            return binarySearch(nums, mid + 1, high, target);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Q33_SearchRotatedSortedArray().search(new int[]{8, 9, 2, 3, 4}, 9));
    }
}
