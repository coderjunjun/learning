package cn.junwork.java.basis;

/**
 * 浮点数测试
 *
 * @author coderjunjun@gmail.com
 * @date 2020/8/5
 */
public class FloatingPointTest {

    public static void main(String[] args) {
        // 定点的BCD编码可以精确存储十进制小数
        // 但是基于科学计数法的浮点数表示法不能精确存储所有小数
        // 其精度也不确定，受当前指数大小影响

        // 例如16777216: 1.000……00 x 2^24
        // 相邻的可表示的数为: 1.000……01 x 2^24
        // 即 16777218
        float a = 16777216;
        float b = 16777216.5f;
        float c = 16777217;
        System.out.println(a == b && b == c);

        float x = 1.0f;
        float y = 0.9f;
        System.out.println(x - y);
    }
}
