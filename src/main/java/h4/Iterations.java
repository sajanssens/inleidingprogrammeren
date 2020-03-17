package h4;

public class Iterations {

    public static void main(String[] args) {
        int i = whileDemo();
        System.out.println("i=" + i);
        forDemo();
        System.out.println("----------------------");
        int j = doWhileDemo();
        System.out.println("j=" + j);

        forEachDemo(21, 22, 23, 24, 25);
    }

    public static int whileDemo() {
        int i = 1; // initialisatie van een teller
        while (i <= 10) { // while met voorwaarde zolang je {...} wilt doen
            System.out.println(i); // = wat je wilt doen
            i++; // ophogen teller (NIET VERGETEN!!!!)
        }

        return i;
    }

    public static void forDemo() {
        // voor i van 11 tot en met 20 met stapgrootte 1, doe:
        loopEnd:
        for (int i = 11; i <= 20; i = i + 1) {
            if (i == 18) {
                continue;
            }
            System.out.print(i + ": ");
            for (int j = 0; j < 5; j++) {
                System.out.print(j + "-");
                if (j == 2) {
                    break loopEnd;
                }
            }
            System.out.println();
        }
    }

    public static int doWhileDemo() {
        int i = 1; // initialisatie van een teller
        do {
            System.out.println(i); // = wat je wilt doen
            i++; // ophogen teller (NIET VERGETEN!!!!)
        } while (i <= 10); // while met voorwaarde zolang je do{...} wilt doen

        return i;
    }

    public static void forEachDemo(int... getallen) {
        // enhanced for
        // iterable
        for (int getal : getallen) { // voor elk getal in getallen, doe:
            System.out.println(getal);
        }

        Verzameling verzameling = new Verzameling();
        for (int i : verzameling) {
            System.out.println(i);
        }
    }

}
