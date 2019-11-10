package cn.junwork.java.feature.cast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author coderjunjun@gmail.com
 * @date 2019-03-14
 */
public class DynamicCast {

    public static void main(String[] args) {
        List<Object> list = Arrays.asList(1, 0.2, "xxx");
        System.out.println(filter(Integer.class, list));
        System.out.println(filter(Double.class, list));
        System.out.println(filter(String.class, list));
    }

    private static <T> List<T> filter(Class<T> tarCls, List<?> list) {
        List<T> result = new ArrayList<>();
        for (Object e : list) {
            if (tarCls.isInstance(e)) {
                result.add(tarCls.cast(e));
                // 静态转换也可以，但是编译器有警告
                result.add((T) e);
            }
        }
        return result;
    }
}
