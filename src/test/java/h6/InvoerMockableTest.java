package h6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

class InvoerMockableTest {

    InvoerMockable target = new InvoerMockable();
    ScannerWrapper scannerMock = mock(ScannerWrapper.class);

    @BeforeEach
    void setup() {
        target.setScanner(scannerMock);
        when(scannerMock.getNextLine()).thenReturn("123");
    }

    @Test
    void testBepaalLengte() {
        int bram = target.bepaalLengte("Bram");
        assertEquals(bram, 4);
    }

    @Test
    void testRun() {
        int lengte = target.run();
        assertEquals(lengte, 3);

        target.run();
        target.run();
        // verify(scannerMock, atLeastOnce()).getNextLine();
        verify(scannerMock, times(3)).getNextLine();
    }
}