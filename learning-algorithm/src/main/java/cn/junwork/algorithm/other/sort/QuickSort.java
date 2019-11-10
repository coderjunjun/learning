package cn.junwork.algorithm.other.sort;

/**
 * 快速排序。
 * <p>
 * 每次都选第一个元素做pivot
 */
public class QuickSort {
    
    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }
    
    
    private static void sort(int[] a, int left, int right) {
        if (right <= left) return;
        
        //取第一个元素作轴
        int pivotIndex = left;
        //将数据按大小分到轴两边
        int pivotFinalIndex = partition(a, left, right, pivotIndex);
        
        //轴左边的子序列排序
        sort(a, left, pivotFinalIndex - 1);
        //轴右边的子序列排序
        sort(a, pivotFinalIndex + 1, right);
    }
    
    
    private static int partition(int[] a, int left, int right, int pivotIndex) {
        //先将pivot值交换到末尾，方便后面循环处理
        int t = a[right]; a[right] = a[pivotIndex]; a[pivotIndex] = t;
        int pivotValue = a[right];
        
        //遍历所有值，小于轴的元素都交换到前面
        int storeIndex = left;
        for (int i = left; i < right; ++i) {
            if (a[i] < pivotValue) {
                t = a[storeIndex];
                a[storeIndex++] = a[i];
                a[i] = t;
            }
        }
        
        //把轴放到正确位置
        a[right] = a[storeIndex];
        a[storeIndex] = pivotValue;
        
        return storeIndex;
    }
}
