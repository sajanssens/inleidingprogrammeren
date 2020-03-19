package h6;

import java.util.Scanner;

public class Invoer {

    public static void main(String[] args) {
        new Invoer().run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int lengte = bepaalLengte(input);
        System.out.println("Lengte is: " + lengte);
    }

    int bepaalLengte(String input) {
        return input.length();
    }

}
