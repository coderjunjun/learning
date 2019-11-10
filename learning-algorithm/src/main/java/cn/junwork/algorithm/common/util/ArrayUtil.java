package cn.junwork.algorithm.common.util;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Jun on 2017/5/31.
 */
public class ArrayUtil {
    
    public static void print(int[] arr) {
        for (int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
    
    
    
    public static int[] genRandomArr(int length, int bound) {
        int[] arr = new int[length];
        Random random = new Random(System.currentTimeMillis());
        
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = random.nextInt(bound);
        }
    
        return arr;
    }
    
    
    public static int[] genRandomOrderedArr(int length, int bound) {
        int[] data = genRandomArr(length, bound);
        Arrays.sort(data);
        return data;
    }
    
    
    public static boolean isAscSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; ++i) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        
        return true;
    }
    
    
    public static boolean isDescSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; ++i) {
            if (arr[i] < arr[i + 1]) {
                return false;
            }
        }
        
        return true;
    }
    
    
    public static void randomReorder(int[] arr) {
        int len = arr.length;
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < arr.length; ++i) {
            int ni = random.nextInt(len);
            int t = arr[i]; arr[i] = arr[ni]; arr[ni] = t;
        }
    }
}
