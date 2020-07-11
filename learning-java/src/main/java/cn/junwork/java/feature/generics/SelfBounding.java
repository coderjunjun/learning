package cn.junwork.java.feature.generics;

/**
 * 自限定类型只在继承时有用武之地，作用是迫使开发者在创建派生类时将自身类型传递给基类，从而将共同操作统一到基类中实现。
 *
 * @author coderjunjun@gmail.com
 * @date 2019-02-12
 */
public class SelfBounding {

    class Base<T extends Base<T>> {
        T v;

        public T getV() {
            return v;
        }
    }

    class Sub1 extends Base<Sub1> {
        void func() {
            Sub1 v = getV();
        }
    }

    //其实也不是非得传自身
    class Sub2 extends Base<Sub1> {
        void func() {

        }
    }
}
