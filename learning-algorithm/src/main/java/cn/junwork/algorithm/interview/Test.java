package cn.junwork.algorithm.interview;

import java.util.Stack;

/**
 * @author coderjunjun@gmail.com
 * @date 2020/11/19
 */
public class Test {

    public static void main(String[] args) {

    }

    class QueueWithStack {
        private Stack<Integer> stack1 = new Stack<>();
        private Stack<Integer> stack2 = new Stack<>();

        public void offer(Integer num) {
            stack1.push(num);
        }

        public Integer poll() {
            if (!stack2.isEmpty()) {
                return stack2.pop();
            }
            if (stack1.isEmpty()) {
                throw new RuntimeException("queue is empty");
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }
}
