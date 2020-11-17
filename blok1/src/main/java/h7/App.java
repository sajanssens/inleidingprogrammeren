package h7;

import java.awt.*;

public class App {

    public static void main(String[] args) {
        double minimalePrijs = Telefoon.MINIMALE_PRIJS;
        String landcodes = Telefoon.geefLandcodes();

        Telefoon t1 = new Telefoon();

        System.out.println(t1.getHoesje());

        t1.setMerk("Moto");
        t1.setPrijs(250.99d);
        t1.setNummer("+31612345678");

        Hoesje h1 = new Hoesje(Color.BLACK, true);
        t1.setHoesje(h1);
        System.out.println(t1.getHoesje());

        System.out.println(t1.getPrijs());

        Telefoon t2 = new Telefoon("Nokia", -150d, "+316623846238");
        System.out.println(t2.getPrijs());
    }
}
