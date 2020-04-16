package h4.exceptions;

public class ArtikelDao {

    public String zoek(int id) throws ArtikelNietGevondenException {
        if (id == 1) {
            return "CD";
        }
        if (id == 2) {
            return "TV";
        }
        if (id == 3) {
            return "Schoen";
        }

        // return Exception;
        throw new ArtikelNietGevondenException("Artikel id is onbekend!");
    }

}
