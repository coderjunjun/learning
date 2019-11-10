package cn.junwork.algorithm.other.sort;

/**
 * 直接插入排序
 */
public class InsertionSort {
    
    public static void sort(int[] arr) {
        sort(arr, 1);
    }
    
    protected static void sort(int[] arr, int dt) {
        //第一个元素自成为有序区，因此遍历从第二个元素开始
        //[i, n) 即当前的无序区
        for (int i = 1; i < arr.length; ++i) {
            int e = arr[i]; //暂存无序区第一个元素
            int j = i;
        
            //有序区内大于e的全部往后移动（腾出正确的位置给e）
            for (; j >= dt && arr[j - dt] > e; j-=dt) {
                arr[j] = arr[j - dt];
            }
        
            //将e放到正确位置上 
            arr[j] = e;
        }
    }
}
