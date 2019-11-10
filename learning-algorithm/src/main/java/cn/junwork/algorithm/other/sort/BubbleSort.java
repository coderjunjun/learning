package cn.junwork.algorithm.other.sort;

/**
 * 冒泡排序。
 * <p>
 * 两两相邻的元素之间比较，较大者放后面，这样一趟下来，最大的元素就移动到了末尾。
 */
public class BubbleSort {
    
    public static void sort(int[] arr) {
        int len = arr.length;
        for (int i = len - 1; i > 0; --i) {
            boolean swapped = false;
            for (int j = 0; j < i; ++j) {
                if (arr[j] > arr[j + 1]) { //前者比后者大，则交换
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break; //一趟下来没发生任何交换，说明每一个元素都比它前者大，表明这已经是一个有序的升序序列了
        }    
    }
    
    
    private static void swap(int[] arr, int i, int j) {
        int t = arr[j];
        arr[j] = arr[i];
        arr[i] = t;
    }
}
