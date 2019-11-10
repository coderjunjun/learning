package cn.junwork.algorithm.other.sort;

/**
 * 严蔚敏版本的快排
 */
public class QuickSortStd {

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }


    private static void sort(int[] a, int left, int right) {
        if (right <= left) return;

        int pivotIndex = partition(a, left, right);
        sort(a, left, pivotIndex - 1);
        sort(a, pivotIndex + 1, right);
    }


    private static int partition(int[] a, int left, int right) {
        if (right <= left) return left;

        int i = left, j = right;
        int x = a[i];
        while (i < j) {
            while (i < j && a[j] >= x) j--;
            a[i] = a[j];

            while (i < j && a[i] <= x) i++;
            a[j] = a[i];
        }

        a[i] = x;
        return i;
    }
}
