package h8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompareLongsTest {

    CompareLongs target = new CompareLongs();

    @Test
    void compareValues() {
        boolean result = target.compareValues(new Long(123), new Long(123));
        assertEquals(false, result);
    }

    @Test
    void compareEquals() {
        boolean result = target.compareEquals(new Long(123), new Long(123));
        assertEquals(true, result);
    }

    @Test
    void comparePrimitives() {
        long n1 = 123;
        long n2 = 123;
    }
}