package h4.exceptions;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ArtikelDaoJU4Test {

    private ArtikelDao target = new ArtikelDao();

    @Test
    public void whenZoekOnExistingIdThenAStringIsReturned() throws ArtikelNietGevondenException {
        String zoek = target.zoek(2);
        assertNotNull(zoek);
    }

    @Test(expected = ArtikelNietGevondenException.class)
    public void whenZoekOnNonExistingIdThenAnExceptionIsThrown() throws ArtikelNietGevondenException {
        String zoek = target.zoek(200);
    }

}