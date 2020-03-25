package unittesting.stringadder;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

class StringAdderTest {

    StringAdder adder = new StringAdder();

    @Test
    public void whenAddNullZeroIsReturned() {
        int result = adder.add(null);
        assertEquals(result, 0);
    }

    @Test
    public void whenAddEmptyStringZeroIsReturned() {
        int result = adder.add("");
        assertEquals(result, 0);
    }

    @Test
    public void whenAddWithOneDigitDigitIsReturned() {
        int result = adder.add("1");
        assertEquals(result, 1);
    }

    @Test
    public void whenAddNonDigitExceptionIsExpected() {
        assertThrows(NumberFormatException.class, () -> adder.add("a"));
    }

    @Test
    public void whenAddWithTwoDigitsSumIsReturned() {
        int result = adder.add("1,2");
        assertEquals(result, 3);

        result = adder.add("45,78");
        assertEquals(result, 123);
    }

    @Test
    public void whenAddWithTwoDigitsWithSpacesSumIsReturned() {
        int result = adder.add("1, 2");
        assertEquals(result, 3);

        result = adder.add("45,    78");
        assertEquals(result, 123);
    }
}