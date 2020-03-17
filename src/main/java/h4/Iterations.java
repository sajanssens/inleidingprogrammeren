package h4;

public class Iterations {

    public static void main(String[] args) {
        int i = whileDemo();
        // System.out.println(i);
        forDemo();
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

        for (int i = 11; i <= 20; i++) {
            System.out.println(i);
        }
    }

}
