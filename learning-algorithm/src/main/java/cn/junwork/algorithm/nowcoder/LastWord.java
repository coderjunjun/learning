package cn.junwork.algorithm.nowcoder;

import java.util.Scanner;

/**
 * 字符串最后一个单词的长度
 * <pre>
 * 题目描述
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 * 输入描述:
 * 一行字符串，非空，长度小于5000。
 * 输出描述:
 * 整数N，最后一个单词的长度。
 * 示例1
 * 输入
 *
 * hello world
 * 输出
 *
 * 5
 * </pre>
 */
public class LastWord {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            int count = 0;
            for (int i = s.length() - 1; i >= 0 && s.charAt(i) != ' '; --i) {
                ++count;
            }
            System.out.println(count);
        }
    }
}
