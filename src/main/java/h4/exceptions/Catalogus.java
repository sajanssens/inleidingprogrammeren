package h4.exceptions;

public class Catalogus {

    private ArtikelDao artikelDao = new ArtikelDao();
    private MagazijnDao magazijnDao = new MagazijnDao();

    public String zoek(int id) throws ArtikelNietGevondenException {
        magazijnDao.verlaagVoorraad();
        return artikelDao.zoek(id);
    }

}
