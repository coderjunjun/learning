package cn.junwork.algorithm.other.sort;

/**
 * 选择排序
 * <p>
 * 这个算法的思想最简单，每一轮都从后面的无序区选择一个最小值交换到有序区末尾。
 * <p>
 * 另外，这是个不稳定排序算法。比如 1 1` 0，最终排序结果是 0 1` 1 （因为第一轮的时候，1跟0交换了位置）
 */
public class SelectionSort {
    
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; ++i) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; ++j) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }
    
    private static void swap(int[] arr, int i, int j) {
        int t = arr[j];
        arr[j] = arr[i];
        arr[i] = t;
    }
}
