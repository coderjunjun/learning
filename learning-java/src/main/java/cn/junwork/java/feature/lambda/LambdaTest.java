package cn.junwork.java.feature.lambda;

/**
 * @author coderjunjun@gmail.com
 * @date 2019-01-29
 */
public class LambdaTest {

    interface IFunc {
        void func();
    }

    static void doFunc(IFunc iFunc) {
        if (iFunc != null) {
            iFunc.func();
        } else {
            System.out.println("接口对象为null，无法执行！");
        }
    }

    public static void main(String[] args) {
        doFunc(() -> System.out.println("执行..."));
    }
}
