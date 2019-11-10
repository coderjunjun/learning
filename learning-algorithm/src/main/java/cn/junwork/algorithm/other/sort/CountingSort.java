package cn.junwork.algorithm.other.sort;

import java.util.Arrays;

/**
 * 计数排序：
 * <p>
 * 这个排序算法的时间复杂度为O(k+n)，其中k是元素值的范围大小，n是元素个数。
 * <p>
 * 因此，当元素值的范围较小时，该算法可以达到线性时间复杂度O(n)
 * <p>
 * 计数排序是一个稳定的排序算法，因此可以应用到基数排序（{@link RadixSort}）中。
 */
public class CountingSort {
    
    /**
     * 计数排序算法。
     * <p>
     * <b>注意：为了便于理解，没有处理负数的情况。所以要求元素的范围必须处于 [0, k)</b>
     *
     * @param arr
     * @param k
     */
    public static void sort(int[] arr, int k) {
        int[] temp = Arrays.copyOf(arr, arr.length);
        int[] count = new int[k];
        
        //对元素进行计数。O(n)
        for (int e : temp) {
            ++count[e];
        }
        
        //计数值累加。O(k)
        //该操作完成后，count[i]的值表示“小于等于i”的元素有多少个
        for (int i = 1; i < count.length; ++i) {
            count[i] += count[i - 1];
        }
        
        //确定每个元素的位置。O(n)
        //从后往前遍历是为了保留相等元素的相对顺序，从而保证了算法的稳定性
        for (int i = temp.length - 1; i >= 0; --i) {
            int n = temp[i];
            arr[count[n] - 1] = n;
            --count[n];
        }
    }
}
