package cn.junwork.algorithm.other.math;

import cn.junwork.algorithm.common.util.Printer;

/**
 * Created by Jun on 2017/7/17.
 */
public class Permutation {
    
    public static void main(String[] args) {
        permutation(new int[]{1, 2, 3, 4}, 0);
    }
    
    
    /**
     * 输出全排列
     * @param arr 要排列的元素
     * @param curIndex 当前处理位置
     */
    public static void permutation(int[] arr, int curIndex) {
        if (curIndex == arr.length) { //到达最后一个位置，本轮所有元素的位置已确定，可以输出了
            for (int n : arr) {
                Printer.print(n + " ");
            }
            Printer.println();
        } else {
            for (int i = curIndex; i < arr.length; ++i) { //对于当前位置，可从剩余元素（当前位置及其后面的元素）中任选一个放进去，我们按照顺序来
                //选中的元素交换到当前位置
                int t = arr[curIndex]; arr[curIndex] = arr[i]; arr[i] = t;
                //递归处理下一个位置
                permutation(arr, curIndex + 1);
                //因为我们是按照顺序选择元素的，所以递归调用返回时要交换回去，才不会出现重复的情况
                t = arr[curIndex]; arr[curIndex] = arr[i]; arr[i] = t;
            }
        }
    }
}
