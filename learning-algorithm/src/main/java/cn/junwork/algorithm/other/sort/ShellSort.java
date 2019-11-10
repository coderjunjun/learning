package cn.junwork.algorithm.other.sort;

/**
 * 希尔排序
 * <p>
 * 希尔排序是插入排序（{@link InsertionSort}）的优化版。
 * 插入排序的缺点很明显，插入时，只能一个位置一个位置的移动，不高效，到后期，
 * 有序区元素很多时，要将元素插到前面，需要挺大的代价。
 * <p>
 * 希尔排序就是先以下标的一定增量对元素分组进行插入排序，然后逐渐缩小增量直到1，等于最后一轮就是做一个直接插入排序。
 * 这样的话，初期因为增量较大，元素可以一次性跨越多个位置进行移动，而且在增量逐渐缩小的过程中，整个数组逐渐接近有序，
 * 从而使得后面的插入排序越来越高效（接近O(N))。
 */
public class ShellSort extends InsertionSort {
    
    public static void sort(int[] arr) {
        int dt = arr.length; //初始化增量
        while ((dt /= 2) > 0) {
            sort(arr, dt);
        }
    }
}
