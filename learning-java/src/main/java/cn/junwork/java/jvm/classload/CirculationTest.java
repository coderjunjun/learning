package cn.junwork.java.jvm.classload;


/**
 * 循环依赖
 * @author coderjunjun@gmail.com
 * @date 2019/11/9
 */
public class CirculationTest {

    /* 实例字段互相依赖 */

    static class A {
        private B b = new B();
    }

    static class B {
        private A a = new A();
    }

    /* 静态字段互相依赖 */

    static class SA {
        private static SA a = SB.a;
    }

    static class SB {
        private static SA a = new SA();
    }

    public static void main(String[] args) {
        // 递归互调构造方法，导致栈溢出
        //new A();

        /*
        * 跟类初始化顺序有关，如果先初始化SB，则SA.a就为null。
        * 这是因为，递归初始化会直接释放初始化锁，继续往下执行。
        *
        * 参见：https://docs.oracle.com/javase/specs/jls/se8/html/jls-12.html#jls-12.4.1
        * If the Class object for C indicates that initialization is
        *  in progress for C by the current thread,
        *  then this must be a recursive request for initialization.
        *  Release LC and complete normally.
        * */
        System.out.println(SB.a);
        System.out.println(SA.a);
    }
}
