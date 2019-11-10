package cn.junwork.java.feature.generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://docs.oracle.com/javase/tutorial/extra/generics/wildcards.html">官方文档</a> <p/>
 * <a href="https://stackoverflow.com/a/19739576">相关概念：协变、逆变和不变</a> <p/>
 *
 * 对于任意一个{@code C<T>}, 都可以使用通配符隐式转换到以T为上界的{@code C<? extends T>}
 * or 以T为下界的{@code C<? super T>} <p/>
 *
 * 静态类型安全: 编译时静态检查, 确保没有类型错误(有运行时转换的保证不了) <p/>
 *
 * PECS原则: 作为Provider(get)时使用extends，作为Consumer(add)时使用super。<p/>
 *
 * @author coderjunjun@gmail.com
 * @date 2019-01-24
 */
public class Wildcard {

    public static void main(String[] args) {
        List<Number> ln = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        List<Serializable> ls = new ArrayList<>();

        // 无界通配符
        unbounded(ln);
        unbounded(li);
        unbounded(ls);

        // Number是上界
        provider(ln);
        provider(li);
        // error
        //provider(ls);

        // Number是下界
        consumer(ln);
        consumer(ls);
        // error
        //consumer(li);
    }


    /**
     * 任意List的父类型不是{@code List<Object>} , 而是{@code List<?>} <p/>
     * 因此任意一个List都可以赋值给{@code List<?>}
     *
     * @param list
     */
    private static void unbounded(List<?> list) {
        // add的参数类型必须是?的子类, 然而现在?都没确定
        // 所以也是出于安全考虑, 禁止add任何类型对象, 除了null
        //list.add(1);
        list.add(null);

        // Object是任何类型的祖先
        Object o = list.get(0);
    }


    /**
     * 持有Number或其子类元素的List可以赋值给{@code List<? extends Number>}
     *
     * @param list
     */
    private static void provider(List<? extends Number> list) {
        // Number的子类都可以隐式转换到Number或其父类
        Number a = list.get(0);
        Serializable s = list.get(0);

        // 编译器只知道list持有的是Number的子类型, 但不知道具体类型
        // 所以保险起见, 这里不能add, 不然list在其他地方get可能就会类型错误了
        //list.add(a);
    }


    /**
     * 持有Number或其父类元素的List可以赋值给{@code List<? super Number>}
     *
     * @param list
     */
    private static void consumer(List<? super Number> list) {
        // Number及其子类, 自然是可以隐式转换到Number父类型的，因此都可以放入
        Number num = new Float(1);
        list.add(num);
        list.add(new Integer(1));
        list.add(new Double(1));

        // 还是出于静态类型安全考虑, Number的任何父类都不允许放入, 因为不知道list实际持有的类型是什么
        //list.add(new Object());

        // 编译器只知道list持有的是Number的父类型, 但是不知道具体什么类型
        // 所以是不能直接get的(可以用强制类型转换)
        //Number n = list.get(0);
    }
}
