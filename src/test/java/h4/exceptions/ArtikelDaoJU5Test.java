package h4.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArtikelDaoJU5Test {

    private ArtikelDao target = new ArtikelDao();

    @Test
    public void whenZoekOnExistingIdThenAStringIsReturned() throws ArtikelNietGevondenException {
        String zoek = target.zoek(2);
        assertNotNull(zoek);
    }

    @Test
    public void whenZoekOnNonExistingIdThenAnExceptionIsThrown() {
        ArtikelNietGevondenException e = assertThrows(ArtikelNietGevondenException.class, () -> target.zoek(200));
        String message = e.getMessage();
        assertEquals("Artikel id is onbekend!", message);
    }

}