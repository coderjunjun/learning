package cn.junwork.java.feature.cast;

/**
 * @author coderjunjun@gmail.com
 * @date 2019/9/16
 */
public class StaticCast {

    public static void main(String[] args) {
        Object obj = new Integer(1);
        System.out.println((Integer) obj + 1);
        System.out.println(null instanceof Integer);
    }
}
