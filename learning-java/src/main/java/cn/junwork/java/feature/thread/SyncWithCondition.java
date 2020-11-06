package cn.junwork.java.feature.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 通过Condition来实现3个线程循环依次打印A B C
 *
 * @author coderjunjun@gmail.com
 * @date 2020/10/9
 */
public class SyncWithCondition {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition[] conditions = new Condition[]{lock.newCondition(), lock.newCondition(), lock.newCondition()};

    public static void main(String[] args) {
        new EchoThread(0, "A").start();
        new EchoThread(1, "B").start();
        new EchoThread(2, "C").start();

        lock.lock();
        conditions[0].signal();
        lock.unlock();
    }

    static class EchoThread extends Thread {
        private int index;
        private String name;

        public EchoThread(int index, String name) {
            this.index = index;
            this.name = name;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    conditions[index].await();

                    System.out.printf("[%d] %s\n", index + 1, name);
                    Thread.sleep(1000);

                    conditions[(index + 1) % conditions.length].signal();
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
