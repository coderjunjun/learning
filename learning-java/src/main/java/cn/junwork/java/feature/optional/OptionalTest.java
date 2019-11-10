package cn.junwork.java.feature.optional;

import java.util.Optional;

/**
 * @author coderjunjun@gmail.com
 * @date 2019-02-15
 */
public class OptionalTest {

    public static void main(String[] args) {
        //不能传null
        Optional<String> opt1 = Optional.of("abc");
        System.out.println(opt1);

        //可以传null
        Optional<String> opt2 = Optional.ofNullable(null);
        System.out.println(opt2.toString());

        //搭配lambda表达式使用
        opt1.ifPresent(v -> System.out.println(v));
        opt1.filter(v -> v.startsWith("a")).ifPresent(v -> System.out.println("True"));
    }
}
