package first;

import org.junit.jupiter.api.Test;

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

        int maxValue = Integer.MAX_VALUE;
        int minValue = Integer.MIN_VALUE;

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

        boolean voorwaarde = pp > 0; // true or false

        if (voorwaarde == true) {
            // then
            System.out.println(pp);
        } else {
            System.out.println("Bedrag pp mag niet negatief zijn.");
        }

    }

    public void testBoolean() {
        boolean executeTest;
        executeTest = false;
        boolean fiveLowerThanOne = (5 < 1);

        executeTest = true;  // FIX

        System.out.println(fiveLowerThanOne);
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
        Long i = 8L;
        IntWrapper iRef = new IntWrapper(8);

        verhoogEnPrint(iRef);
        verhoogEnPrint(iRef);
        verhoogEnPrint(iRef);
    }

    void verhoogEnPrint(IntWrapper n) {
        n.value = n.value + 1;
        System.out.println(n.value);
    }
}
