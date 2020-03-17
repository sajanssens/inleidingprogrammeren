package h4;

import java.util.Iterator;

public class Verzameling implements Iterable<Integer> {

    private int counter = 0;

    private int i1 = 100;
    private int i2 = 200;
    private int i3 = 300;

    @Override public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override public boolean hasNext() {
                return counter < 3;
            }

            @Override public Integer next() {
                counter++;
                if (counter == 1) return i1;
                if (counter == 2) return i2;

                return i3;
            }
        };
    }
}
