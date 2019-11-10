package cn.junwork.algorithm.common.util;

import java.util.Arrays;

/**
 * Created by Jun on 2017/7/12.
 */
public class Printer {
    
    public static void println() {
        System.out.println();
    }
    
    public static void println(Object msg) {
        System.out.println(msg);
    }
    
    public static void print(Object msg) {
        System.out.print(msg);
    }
    
    public static void print(Object[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
