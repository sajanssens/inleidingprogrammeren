package h4.exceptions;

public class MagazijnDao {

    private int voorraad = 105;

    public void verlaagVoorraad() {
        voorraad--;
        if (voorraad < 100) {
            throw new VoorraadleegException("Voorraad te laag! voorraad=" + voorraad);
        }
    }

}
