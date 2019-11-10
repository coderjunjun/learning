package cn.junwork.algorithm.other.sort;

import java.util.Arrays;

/**
 * 我们知道，计数排序最适用于元素取值范围小于元素个数的情况。
 * <p>
 * 基数排序的基本思想是从低位到高位，按照每一位数字对元素进行多轮排序，对于每一位，取值范围为[0, 9]，因此可以采用计数排序快速的完成。
 * 但是如果位数远大于元素个数，则要进行很多轮，反而效果不好，解决方法就是以多位为一块，具体取多少位最佳，这是一个函数的极值问题。
 * <p>
 * 下面就实现简单的一位一轮的方法。通过 {@link test.SortTest} 测试可以验证，在取值范围远大于元素个数时，基数排序可以秒杀（直接）计数排序。
 */
public class RadixSort {
    
    /**
     * 基于计数排序的基数排序算法。
     *
     * @param arr 要排序的数组
     * @param mdn 所有元素中最长的位数（十进制）
     * @see CountingSort
     */
    public static void sort(int[] arr, int mdn) {
        int curDigitIndex = 0; //当前位索引，0-个位 1-十位 2-百位 ...
        
        while (curDigitIndex < mdn) { //每一轮都是一次计数排序
            int[] temp = Arrays.copyOf(arr, arr.length);
            int[] count = new int[10];
            
            for (int e : arr) {
                ++count[(int) (e / Math.pow(10, curDigitIndex)) % 10];
            }
            
            for (int i = 1; i < count.length; ++i) {
                count[i] += count[i - 1];
            }
            
            for (int i = temp.length - 1; i >= 0; --i) {
                int digit = (int) (temp[i] / Math.pow(10, curDigitIndex)) % 10;
                arr[count[digit] - 1] = temp[i];
                --count[digit];
            }
            
            ++curDigitIndex;
        }
    }
}
