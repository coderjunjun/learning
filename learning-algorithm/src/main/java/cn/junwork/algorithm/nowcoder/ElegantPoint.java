package cn.junwork.algorithm.nowcoder;

import java.util.Scanner;

/**
 * <pre>
 * 小易有一个圆心在坐标原点的圆，小易知道圆的半径的平方。小易认为在圆上的点而且横纵坐标都是整数的点是优雅的，小易现在想寻找一个算法计算出优雅的点的个数，请你来帮帮他。
 * 例如：半径的平方如果为25
 * 优雅的点就有：(+/-3, +/-4), (+/-4, +/-3), (0, +/-5) (+/-5, 0)，一共12个点。
 * 输入描述:
 * 输入为一个整数，即为圆半径的平方,范围在32位int范围内。
 *
 *
 * 输出描述:
 * 输出为一个整数，即为优雅的点的个数
 *
 * 输入例子1:
 * 25
 *
 * 输出例子1:
 * 12
 * </pre>
 */
public class ElegantPoint {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r2 = sc.nextInt();
        int r = (int)Math.sqrt(r2);
    
        int count = 0;
        for (int i = 1; i <= r; ++i) {
            double y = Math.sqrt(r2 - i * i);
            if (Math.abs(y - Math.floor(y)) < 0.000000001) {
                count += 4;
            }
        }
    
        System.out.println(count);
    }
}
