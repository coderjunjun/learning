package cn.junwork.java.feature.bridge;


/**
 * 根据子类实际传递的类型参数，是满足Override条件的，但因为泛型擦除，子类参数类型和父类参数类型不一致,
 * 这时候编译器就会为子类自动生成一个桥接方法，使得JVM可以实现多态特性。
 *
 * @see CovariantReturn
 * @author coderjunjun@gmail.com
 * @date 2019-09-11
 */
public class ParameterTypeErasure {

    public static class A<T> {
        public void create(T p) {
        }
    }

    public static class B extends A<String> {
        @Override
        public void create(String p) {
        }
    }

    public static class C extends A {
        // 这个不是Override
        public void create(String p) {

        }
    }


    public static void main(String[] args) {
        A a = new B();
        // 桥接方法调用真实方法的时候 CHECKCAST 出错
        a.create(new Object());
    }
}
