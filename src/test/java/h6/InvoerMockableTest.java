package h6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class InvoerMockableTest {

    ScannerWrapper scannerMock = mock(ScannerWrapper.class);
    InvoerMockable target = new InvoerMockable();

    @BeforeEach
    void setup() { target.setScanner(scannerMock); }

    @Test
    void testBepaalLengte() {
        int bram = target.bepaalLengte("Bram");
        assertEquals(bram, 4);
    }

    @Test
    void testRun() {
        when(scannerMock.getNextLine()).thenReturn("123");
        int abc = target.run();
        assertEquals(abc, 3);
    }
}