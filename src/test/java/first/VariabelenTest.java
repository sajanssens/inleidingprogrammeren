package first;

import org.junit.jupiter.api.Test;

import static first.Integer.box;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VariabelenTest {

    // hier mag je niet programmeren

    @Test
    void rekenenMetGeheleGetallen() {
        // tussen deze accolades ga ik programmeren
        int aantalReizigersInDeTrein; // declareren; eenmalig; int is een geheel getal (+/-)
        aantalReizigersInDeTrein = 4;

        System.out.println("Het aantal" + "reizigers is: " + aantalReizigersInDeTrein); // string concatenatie

        char reizigersPerBak = 35;
        int aantalPersoneelsledenPerTrein = 33;
        aantalReizigersInDeTrein = 4 * reizigersPerBak + aantalPersoneelsledenPerTrein;

        System.out.println("Het aantal" + "reizigers is: " + aantalReizigersInDeTrein); // string concatenatie

        aantalReizigersInDeTrein = 143;
        reizigersPerBak = (char) ((aantalReizigersInDeTrein - aantalPersoneelsledenPerTrein) / 4); // + - / *

        int maxValue = java.lang.Integer.MAX_VALUE;
        int minValue = java.lang.Integer.MIN_VALUE;

        long coronaBeestjesPerReiziger = 200_000_000_000L;
        long aantalCoronaBeestjesPerTrein = coronaBeestjesPerReiziger * aantalReizigersInDeTrein;
        long andereLong = 50L;

        System.out.println(maxValue);
        System.out.println(minValue);

        assertEquals(143, aantalReizigersInDeTrein);
        assertEquals(35, reizigersPerBak);
        assertEquals(200_000_000_000L * aantalReizigersInDeTrein, aantalCoronaBeestjesPerTrein);
    }

    @Test
    void rekenenMetGebrokenGetallen() {
        // float 32 bits
        // double 64 bits
        double gemaakteKostenMaaltijd = 23.45f;
        int aantalMeeeters = 4;
        double pp = gemaakteKostenMaaltijd / aantalMeeeters;

        boolean voorwaarde1 = pp > 0; // true or false
        // boolean voorwaarde2 = aantalMeeeters < 10; // true or false

        if ((pp > 0 && aantalMeeeters < 20) || gemaakteKostenMaaltijd <= 100) {
            // then
            System.out.println(pp);
        } else {
            System.out.println("Bedrag pp mag niet negatief zijn.");

        }

        aantalMeeeters -= 2;

    }

    @Test
    public void testBoolean() {
        boolean executeTest;
        executeTest = false;
        boolean fiveLowerThanOne = (5 < 1);

        executeTest = true;  // FIX

        byte b = (byte) 0b1111_0000;
        byte c = (byte) ~b; // 0000_1111
        byte d = (byte) (b & c); // 0000_0000
        byte e = (byte) (b | c); // 1111_1111

        int j = -9;
        int k = +j;

        System.out.println(d);
        System.out.println(e);

        System.out.println(!fiveLowerThanOne);
    }

    @Test
    void charTest() {
        char a = 'a';
        char b = 'b';
        char c = 'c';

        long j = 9L;

        // verhoogEnPrint(j);

        String i = 3 + "=text";

        System.out.println(a + 0);
        System.out.println(b + 0);
        System.out.println(i);
    }

    @Test
    void boxing() {
        Integer iRef = box(8);
        java.lang.Number i = 7;

        Class<? extends Number> aClass = i.getClass();
        if (aClass == Number.class) {
            System.out.println("i is een Number");
        }

        if (i instanceof java.lang.Integer) {
            java.lang.Integer n = (java.lang.Integer) i;
            n = n + 1;
        }

        verhoogEnPrint(iRef);
        verhoogEnPrint(iRef);
        verhoogEnPrint(iRef);
    }

    @Test
    void equalsOrIsIs() {
        Client c1 = new Client();
        Client c2 = new Client();
        c1.name = "Bram";
        c2.name = "Bram";

        String s1 = "Bram";
        String s2 = "bram";

        if (c1.equals(c2)) {
            System.out.println("Ze zijn gelijk!");
        } else {
            System.out.println("Ze zijn niet gelijk!");
        }

        if (s1.equalsIgnoreCase(s2)) {
            System.out.println("Ze zijn gelijk 2!");
        } else {
            System.out.println("Ze zijn niet gelijk 2!");
        }

    }

    void verhoogEnPrint(Integer n) {
        n.value = n.value + 1;
        System.out.println(n.value);
    }
}

class Client {
    public String name;
}
