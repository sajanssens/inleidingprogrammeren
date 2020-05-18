package h6;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InvoerTest {

    Invoer target = new Invoer();

    @Test
    void testBepaalLengte() {
        int bram = target.bepaalLengte("Bram");
        assertEquals(bram, 4);
    }

    @Test
    @Disabled
    void testRun() {
        Invoer target = new Invoer();
        target.run();
        // assert??
    }
}