package cn.junwork.java.feature.cast;

/**
 * 父类数组类型（实例化时的真实类型）不能向子类数组类型转换，反过来可以
 *
 * @author coderjunjun@gmail.com
 * @date 2020/10/4
 */
public class ArrayTypeCast {

    public static void main(String[] args) {
        Number[] arr1 = new Integer[100];
        // ok
        Integer[] arr2 = (Integer[]) arr1;

        //  [Ljava.lang.Number; cannot be cast to [Ljava.lang.Integer;
        Integer[] arr3 = (Integer[]) new Number[100];
    }
}
