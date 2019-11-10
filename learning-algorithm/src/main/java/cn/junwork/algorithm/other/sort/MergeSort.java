package cn.junwork.algorithm.other.sort;

/**
 * 归并排序
 * <p>
 * 思想：递归的将列表对半分，当子列表长度为1时，自成一个有序列表，当递归调用返回时，将这些有序子列表合并即可。
 * <p>
 * 考虑长度为n的列表，递归调用是一颗高度约为log2n的完全二叉树，每一层需要合并的元素总个数都为n，所以时间复杂度是O(n·log2n)
 */
public class MergeSort {
    
    public static void sort(int[] arr) {
        int[] tempArr = new int[arr.length];
        sort(arr, tempArr, 0, arr.length - 1);
    }
    
    private static void sort(int[] arr, int[] tempArr, int l, int r) {
        if (l == r) return;
        
        int mid = (l + r) / 2;
        sort(arr, tempArr, l, mid);
        sort(arr, tempArr, mid + 1, r);
        
        merge(arr, tempArr, l, mid, mid + 1, r);
    }
    
    
    /**
     * 合并2个有序表为1个有序表
     * @param arr
     * @param l1
     * @param r1
     * @param l2
     * @param r2
     */
    private static void merge(int[] arr, int[] tempArr, int l1, int r1, int l2, int r2) {
        //先将元素复制到临时数组中
        for (int i = l1; i <= r1; ++i) { tempArr[i] = arr[i]; }
        for (int i = l2; i <= r2; ++i) { tempArr[i] = arr[i]; }
        
        int p1 = l1, p2 = l2; //分别指向两个列表的当前元素
        int p = p1;           //指向当前存放位置
        
        //合并
        while (p1 <= r1 && p2 <= r2) {
            if (tempArr[p1] <= tempArr[p2]) {
                arr[p++] = tempArr[p1];
                ++p1;
            } else {
                arr[p++] = tempArr[p2];
                ++p2;
            }
        }
    
        //列表1的剩余元素
        while (p1 <= r1) { arr[p++] = tempArr[p1++]; }
        //列表2的剩余元素
        while (p2 <= r2) { arr[p++] = tempArr[p2++]; }
    }
}
