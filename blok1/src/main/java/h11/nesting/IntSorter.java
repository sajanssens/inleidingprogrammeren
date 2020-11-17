package h11.nesting;

import java.util.Comparator;

public class IntSorter implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        // if (o2 < o1) { return -1; }
        // else if (o2 > o1) { return 1; }
        // else { return 0; }

        // ... is the same as:
        return o2.compareTo(o1);
    }
}
