package cn.junwork.java.feature.function;

import java.util.function.Predicate;

/**
 * 为了把lambda表达式发扬光大，Java定了函数式接口的标准，
 * 我们可以通过lambda表达式或者method引用来创建函数式接口的实例，
 * Java也内置了一些通用的函数式接口。
 *
 * @author coderjunjun@gmail.com
 * @date 2019-09-10
 */
public class FunctionInterfaceTest {

    public static void main(String[] args) {
        // 内置函数接口
        testPredicate(String::isEmpty);
        testPredicate(s -> s == null || s.length() == 0);

        // 测试自定义的
        testMyFunc(Integer::parseInt);
    }

    static void testPredicate(Predicate<String> predicateFunc) {
        System.out.println(predicateFunc.test("111"));
    }

    static void testMyFunc(MyFunc<String, Integer> myFunc) {
        System.out.println(myFunc.map("111"));
    }

    @FunctionalInterface
    interface MyFunc<P,R> {
        R map(P param);
    }
}
