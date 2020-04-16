package first;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyFirstTest {

    @Test
    void testDeMain() {
        String bericht = MyFirst.geefBericht();
        assertEquals("Hello world!", bericht);
    }

}