package cn.junwork.java.feature.exception;

/**
 * checked异常，指编译器强迫开发者检查了的异常
 *
 * @author coderjunjun@gmail.com
 * @date 2019-03-12
 */
public class CheckedExceptionTest {

    public static void main(String[] args) {
        if (args.length == 0) {
            try {
                //checked异常，必须要catch或者声明向上层抛出
                throw new CheckedException();
            } catch (CheckedException e) {
            }
        }

        //非checked异常，编译器不会强制我们处理
        throw new UnCheckedException();
    }

    //直接继承自Exception的异常是checked异常
    static class CheckedException extends Exception {

    }

    //继承关系：UnCheckedException -> RuntimeException -> Exception
    static class UnCheckedException extends RuntimeException {
    }
}
