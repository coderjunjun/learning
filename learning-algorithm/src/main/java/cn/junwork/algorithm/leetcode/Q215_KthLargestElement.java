package cn.junwork.algorithm.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/kth-largest-element-in-an-array/">215. Kth Largest Element in an Array</a>
 * <pre>
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 * </pre>
 *
 * @author coderjunjun@gmail.com
 * @date 2020/11/6
 */
public class Q215_KthLargestElement {

    public static void main(String[] args) {
        System.out.println(new Q215_KthLargestElement().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        int[] minHeap = Arrays.copyOf(nums, k);
        // 先从下至上堆化
        for (int i = k / 2 - 1; i >= 0; --i) {
            sink(minHeap, k, i);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap[0]) {
                minHeap[0] = nums[i];
                sink(minHeap, k, 0);
            }
        }
        return minHeap[0];
    }

    private void sink(int[] minHeap, int size, int i) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        if (leftChild >= size) {
            return;
        }

        int smallerChild = leftChild;
        if (rightChild < size && minHeap[rightChild] < minHeap[leftChild]) {
            smallerChild = rightChild;
        }
        if (minHeap[i] > minHeap[smallerChild]) {
            swap(minHeap, i, smallerChild);
            sink(minHeap, size, smallerChild);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
