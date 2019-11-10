package cn.junwork.java.feature.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * raw type主要是用来兼容JDK 1.5以下版本代码的,
 * 使用raw type后编译器会忽略所有泛型信息, 不安全也不方便。
 *
 * @author coderjunjun@gmail.com
 * @date 2019/10/25
 */
public class RawType<T> {

    private List<String> list = new ArrayList<>();

    public List<String> getList() {
        return list;
    }

    public static void main(String[] args) {
        RawType rawType = new RawType<>();

        // 只要使用raw type, 编译器就会忽略所有泛型信息(即使跟类型参数T无关),
        // 所以就不会检查类型和自动转换, 导致下面的转换会有unchecked警告
        List<String> list = rawType.getList();

        // 同理, 下面的语句会有类型不匹配的错误
        //for (String s : rawType.getList()) {
        //
        //}
    }
}
