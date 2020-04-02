package h13;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAccumulator;

public class Variance {
    public static void main(String[] args) {
        // allowed: T's extend Number and Number itself
        coVariant(new ArrayList<Number>());
        coVariant(new ArrayList<Integer>());
        coVariant(new ArrayList<Float>());
        // not allowed: T's super Number
        // coVariant(new ArrayList<Object>());

        // allowed: T's super Number and Number itself
        contraVariant(new ArrayList<Number>());
        contraVariant(new ArrayList<Object>());
        // not allowed: T's extend Number
        // contraVariant(new ArrayList<Integer>());
        // contraVariant(new ArrayList<Float>());
    }

    // Co, since list type moves along the content type, i.e. Integer < Number, List<Integer> < List<Number>
    static void coVariant(List<? extends Number> list) {
        Number number = list.get(0);// it's a Number, since that's the only thing we know for sure

        // disallowed are all additions, since the list instance can contain any specific subclass of Number
        //   T's extend Number and Number itself
        //   list.add(0);
        //   list.add(1L);
        //   list.add(2D);
        //   list.add(new AtomicInteger());
        //   list.add(new LongAccumulator((a, b) -> a + b, 1l));

        //   T's !extends Number
        //   list.add(new Number());
        //   list.add(new Object());
    }

    // Contra, since provided list type vs. wanted list type moves against the content type, i.e. Integer < Number, but List<Integer> !< List<Number>
    static void contraVariant(List<? super Number> list) {
        Object object = list.get(0); // can be anything...

        // allowed are T's that extend Number and Number itself, since that's the only thing we know for sure:
        list.add(0);
        list.add(1L);
        list.add(2D);
        list.add(new AtomicInteger());
        list.add(new LongAccumulator(Long::sum, 1l));

        // disallowed are T's !extends Number, since the list instance can contain anything
        // list.add(new Object());
        //list.add("0");
    }

    static void coVariantForObject(List<?> list) {
        Object o = list.get(0);

        // additions not allowed:
        // list.add(1);
        // list.add("1");
        // list.add(new Object());
    }
}
