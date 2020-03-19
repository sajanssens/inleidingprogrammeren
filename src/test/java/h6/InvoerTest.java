package h6;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class InvoerTest {

    @Test
    void testBepaalLengte() {
        Invoer target = new Invoer();
        int bram = target.bepaalLengte("Bram");
        assertEquals(bram, 4);
    }
}