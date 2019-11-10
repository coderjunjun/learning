package cn.junwork.java.feature.generics;

import java.io.Serializable;

/**
 * @author coderjunjun@gmail.com
 * @date 2019/9/15
 */
public class UncheckedCast {

    private static class Holder {
        private Serializable value;

        public <T> T getValue() {
            // 编译器未检查的(unchecked)类型转换
            return (T) value;
        }
    }

    public static void main(String[] args) {
        Holder h = new Holder();
        // 实际check cast的字节码在这里
        String s = h.getValue();
    }
}
