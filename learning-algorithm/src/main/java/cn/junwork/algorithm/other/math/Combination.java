package cn.junwork.algorithm.other.math;

import cn.junwork.algorithm.common.util.Printer;

/**
 * Created by Jun on 2017/7/17.
 */
public class Combination {
    public static void main(String[] args) {
        String str = "1234";
        combination(str, 3);
    }
    
    
    /**
     * 输出k个字符的所有组合
     * @param str 所有字符
     * @param k
     */
    public static void combination(String str, int k) {
        int n = str.length();
        if (k > n) return;
    
        //当前组合的k个元素的索引
        int[] indexs = new int[k];
        
        //第一个组合就是前k个元素
        for (int i = 0; (indexs[i] = i) < k - 1; ++i);
        printSubset(str, indexs);
        
        for (;;) {
            int i;
            //从后往前，寻找还能往后移动的索引
            for (i = k - 1; i >= 0 && indexs[i] + k - i == n; --i);
            if (i < 0) break;  //没有可以移动的了
    
            //移动
            ++indexs[i];
            //填充后面的（递增）
            for (++i; i < k; ++i) {
                indexs[i] = indexs[i - 1] + 1;
            }
            printSubset(str, indexs);
        }
    }
    
    
    private static void printSubset(String str, int[] indexs) {
        for (int i : indexs) {
            Printer.print(str.charAt(i) + " ");
        }
        Printer.println();
    }
}
