package cn.junwork.algorithm.nowcoder;
/////////////////////////////////////////////////
/////////////////////////////////////////////////
/*********************分割线*********************/
////////////////////////////////////////////////
////////////////////////////////////////////////


import java.util.Scanner;

/**
 * <pre>
 * 给定一个无序数组，包含正数、负数和0，要求从中找出3个数的乘积，使得乘积最大，要求时间复杂度：O(n)，空间复杂度：O(1)
 * 输入描述:
 * 无序整数数组A[n]
 * <p>
 * <p>
 * 输出描述:
 * 满足条件的最大乘积
 * <p>
 * 输入例子1:
 * 3 4 1 2
 * <p>
 * 输出例子1:
 * 24
 * </pre>
 */
public class MaxMultiplyValue {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n;
        long[] A;
        while (sc.hasNextInt()) {
            n = sc.nextInt();
            A = new long[n];
            for (int i = 0; i < A.length; ++i) {
                A[i] = sc.nextInt();
            }
            
            
            //先来5趟冒泡，把最小的2个数弄到前面，最大的3个数弄到后面
            //O(5n)
            for (int i = 0; i < 2; ++i) {
                for (int j = A.length - 1; j > i; --j) {
                    if (A[j] < A[j - 1]) swap(A, j, j - 1);
                }
            }
            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < A.length - i - 1; ++j) {
                    if (A[j] > A[j + 1]) swap(A, j, j + 1);
                }
            }
            
            //1.最大的三个数相乘
            //2.最小的两个与最大的那个相乘
            //取较大者
            long a = A[A.length - 1] * A[A.length - 2] * A[A.length - 3];
            long b = A[0] * A[1] * A[A.length - 1];
            System.out.println(Math.max(a, b));
        }
    }
    
    
    private static void swap(long[] A, int i, int j) {
        long t = A[i];
        A[i] = A[j];
        A[j] = t;
    }
}
