package cn.junwork.java.feature.bridge;

/**
 * 协变返回: 当发生Override时, 子类方法返回类型 必须是 父类方法返回类型的子类型 <p/>
 * 因为JVM把返回值类型也作为方法签名的一部分, 所以发生协变时, 编译器会生成一个桥接方法 <p/>
 *
 * @author coderjunjun@gmail.com
 * @date 2019-09-11
 */
public class CovariantReturn {

    public class A {
        public A create() {
            return null;
        }
    }

    public class B extends A {
        @Override
        public B create() {
            return null;
        }
    }

    public class C extends B {
        //@Override
        //public A create() {
        //    return null;
        //}
    }
}
