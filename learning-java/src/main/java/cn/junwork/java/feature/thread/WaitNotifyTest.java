package cn.junwork.java.feature.thread;

/**
 * @author coderjunjun@gmail.com
 * @date 2020/11/17
 */
public class WaitNotifyTest {

    private static Object condition = new Object();

    public static void main(String[] args) throws InterruptedException {
        synchronized (condition) {
            condition.notify();
        }
    }
}
