package cn.junwork.algorithm.leetcode;


/**
 * <a href="https://leetcode-cn.com/problems/powx-n/">50. Pow(x, n)</a>
 * <pre>
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 *
 * Example 1:
 *
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 *
 * Input: 2.10000, 3
 * Output: 9.26100
 * Example 3:
 *
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * Note:
 *
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−2^31, 2^31 − 1]
 * </pre>
 *
 * @author coderjunjun@gmail.com
 * @date 2020/8/14
 */
public class Q50_Pow {

    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        return n > 0 ? pow(x, n) : 1 / pow(x, -(long) n);
    }

    private double pow(double x, long n) {
        double result = 1;
        while (n > 0) {
            long b = n & 1;
            result = result * (b > 0 ? x : 1);
            n >>= 1;
            x = x * x;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Q50_Pow().myPow(10, 300));
        System.out.println(new Q50_Pow().myPow(10, 310));
        System.out.println(new Q50_Pow().myPow(1, -2147483648));
    }
}
