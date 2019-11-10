package cn.junwork.algorithm.nowcoder;

/*
题目描述
有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问每个月的兔子总数为多少？

输入描述:
输入int型表示month
输出描述:
输出兔子总数int型
示例1

输入
9

输出
3
*/
/////////////////////////////////////////////////
/////////////////////////////////////////////////
/*********************分割线*********************/
////////////////////////////////////////////////
////////////////////////////////////////////////


import java.util.Scanner;

public class CountRabbit {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (sc.hasNextInt()) {
            System.out.println(getTotalCount(sc.nextInt()));
        }
    }
    
    
    /**
     * 统计出兔子总数。
     *
     * @param monthCount 第几个月
     * @return 兔子总数
     */
    public static int getTotalCount(int monthCount) {
        int[][] cache = new int[monthCount + 1][3 + 1];
        return getCount(cache, monthCount, 1) + getCount(cache, monthCount, 2) + getCount(cache, monthCount, 3);
    }
    
    
    /**
     * 获取第n个月的时候，年龄为i个月的兔子个数。
     * 大于3个月的也视为3个月
     *
     * @param n
     * @param i
     * @return
     */
    private static int getCount(int[][] cache, int n, int i) {
        if (cache[n][i] != 0) return cache[n][i];
        if (n == 1) {
            return i == 1 ? 1 : 0;
        }
    
        int result = i == 2 ? getCount(cache, n - 1, 1) : getCount(cache, n - 1, 2) + getCount(cache, n - 1, 3);
        cache[n][i] = result;
        
        return result;
    }
}
