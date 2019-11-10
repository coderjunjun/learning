package cn.junwork.java.feature.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author coderjunjun@gmail.com
 * @date 2019-09-11
 */
public class SummaryTest {

    public static void main(String[] args) {
        sepLine("integer list");
        List<Integer> li = new ArrayList<>();
        li.add(1);
        li.add(10);
        li.add(5);
        System.out.println( Collections.max(li) );
        System.out.println( myMax(li) );

        sepLine("list of myInt with comparator");
        List<MyIntWithCmp> mli = new ArrayList<>();
        mli.add(new MyIntWithCmp(1));
        mli.add(new MyIntWithCmp(10));
        mli.add(new MyIntWithCmp(5));
        System.out.println( Collections.max(mli) );
        System.out.println( myMax(mli) );

        sepLine("list of myInt with object comparator");
        List<MyIntWithObjCmp> mliWithObjCmp = new ArrayList<>();
        mliWithObjCmp.add(new MyIntWithObjCmp(1));
        mliWithObjCmp.add(new MyIntWithObjCmp(10));
        mliWithObjCmp.add(new MyIntWithObjCmp(5));
        System.out.println( Collections.max(mliWithObjCmp) );
        System.out.println( myMax(mliWithObjCmp) );

        sepLine("list of myInt with integer comparator");
        List<MyIntWithIntCmp> mliWithIntCmp = new ArrayList<>();
        mliWithIntCmp.add(new MyIntWithIntCmp(1));
        mliWithIntCmp.add(new MyIntWithIntCmp(10));
        mliWithIntCmp.add(new MyIntWithIntCmp(5));
        //System.out.println( Collections.max(mliWithIntCmp) );
        //System.out.println( myMax(mliWithIntCmp) );

        sepLine("unbounded wildcard list");
        List<?> lu = li;
        //System.out.println( Collections.max(lu) );
        //System.out.println( myMax(lu) );

        sepLine("object list");
        List<Object> lo = new ArrayList<>();
        li.add(1);
        li.add(10);
        li.add(5);
        //System.out.println( Collections.max(lo) );
        //System.out.println( myMax(lo) );

        List<SubMyIntWithObjCmp> mliWithObjCmpSub = new ArrayList<>();
        MyIntWithObjCmp r1 = myMax(mliWithObjCmpSub);
        Comparable<Object> r2 = Collections.max(mliWithObjCmpSub);
    }


    /**
     * T的边界增加Object是为了让泛型擦除到Object, 而不是Comparable, 从而兼容老的调用代码 <p/>
     * 参数中使用? extends T是为了限制发生修改 <p/>
     *
     * @param coll
     * @param <T>
     * @return
     */
    private static <T extends Object & Comparable<? super T>> T myMax(Collection<T> coll) {
        Iterator<T> i = coll.iterator();
        T candidate = i.next();

        while (i.hasNext()) {
            T next = i.next();
            if (next.compareTo(candidate) > 0)
                candidate = next;
        }
        return candidate;
    }

    private static class MyIntWithCmp implements Comparable<MyIntWithCmp> {

        private Integer v;

        public MyIntWithCmp(Integer v) {
            this.v = v;
        }

        @Override
        public String toString() {
            return v.toString();
        }

        @Override
        public int compareTo(MyIntWithCmp o) {
            return v.compareTo(o.v);
        }
    }

    private static class MyIntWithObjCmp implements Comparable<Object> {

        private Object v;

        public MyIntWithObjCmp(Integer v) {
            this.v = v;
        }

        @Override
        public String toString() {
            return v.toString();
        }

        @Override
        public int compareTo(Object o) {
            return v.toString().compareTo(o.toString());
        }
    }

    private static class MyIntWithIntCmp implements Comparable<Integer> {

        private Object v;

        public MyIntWithIntCmp(Integer v) {
            this.v = v;
        }

        @Override
        public String toString() {
            return v.toString();
        }

        @Override
        public int compareTo(Integer o) {
            return v.toString().compareTo(o.toString());
        }
    }

    private static class SubMyIntWithObjCmp extends MyIntWithObjCmp {
        public SubMyIntWithObjCmp(Integer v) {
            super(v);
        }
    }



    private static void sepLine(String title) {
        System.out.println("\n===========" + title + "===========");
    }
}
