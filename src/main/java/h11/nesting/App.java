package h11.nesting;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class App {

    public static void main(String[] args) {
        // use static nested class
        EnclosingClass.StaticNestedClass snc = new EnclosingClass.StaticNestedClass();
        int sta = EnclosingClass.StaticNestedClass.countStatic;
        int nonsta = snc.count;
        snc.doeIets();

        // ... compared to StaticNestedClassStandalone
        StaticNestedClassStandalone sncsa = new StaticNestedClassStandalone();
        int sta1 = StaticNestedClassStandalone.countStatic;
        int nonsta1 = sncsa.count;
        sncsa.doeIets();

        // using inner class
        EnclosingClass.InnerClass ic = new EnclosingClass().new InnerClass();
        ic.doeIets();

        // creating an anonymous inner class's object
        Comparator<Integer> intSorterAnonymous = new Comparator<Integer>() {
            @Override public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };

        // ... compare this to non-anonymous (standalone) class and lambda
        Comparator<Integer> intSorterStandalone = new IntSorter();
        Comparator<Integer> intSorterAnonymousLambda = (o1, o2) -> o2.compareTo(o1);

        // ... and using the anonymous inner class's object:
        SortedSet<Integer> sortedSet = new TreeSet<>(intSorterAnonymous);
        sortedSet.add(3);
        sortedSet.add(-3);
        sortedSet.add(2);
        sortedSet.add(98);
        sortedSet.add(0);

        for (Integer i : sortedSet) { System.out.println(i); }
    }
}
