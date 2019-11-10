package cn.junwork.java.feature.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://docs.oracle.com/javase/tutorial/extra/generics/subtype.html">官方文档</a><p/>
 *
 * @author coderjunjun@gmail.com
 * @date 2019-09-10
 */
public class Subtyping {

    public static void main(String[] args) {
        List<String> ls = new ArrayList<>();

        // 编译器禁止这种转换, 因为这样lo能放入任意对象, 导致ls取出的时候不安全
        // 虽然这和我们的常识是违背的: 一个String列表并不是一个Object列表
        // List<Object> lo = ls;
    }
}
