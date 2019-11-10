package cn.junwork.algorithm.other.stack;

import java.util.Stack;

/**
 * Created by Jun on 2017/6/5.
 */
public class SortStackByStack {
    
    public static void sort(Stack<Integer> stack) {
        Stack<Integer> tmpStack = new Stack<>();
        
        //移动数据到临时栈中
        tmpStack.addAll(stack);
        stack.clear();
        
        //循环从临时栈中取最小值，push到原栈中
        while (!tmpStack.isEmpty()) {
            stack.push(popMin(tmpStack, 0, 0, tmpStack.peek())[1]);
        }
    }
    
    
    private static int[] popMin(Stack<Integer> stack, int index, int minIndex, int minValue) {
        if (stack.isEmpty()) {
            return new int[]{minIndex, minValue};
        }
        
        int v = stack.pop();
        if (v < minValue) {
            minIndex = index;
            minValue = v;
        }
        
        int[] minInfo = popMin(stack, index + 1, minIndex, minValue);
        if (index != minInfo[0]) {
            stack.push(v);
        }
        
        return minInfo;
    }
}
