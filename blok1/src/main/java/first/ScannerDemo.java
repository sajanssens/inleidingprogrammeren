package first;

import java.util.Scanner;

public class ScannerDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nextInt;
        do {
            System.out.println("Geef wat input: ");
            String input = scanner.nextLine();
            System.out.println("Input is: " + input);

            nextInt = scanner.nextInt(); // doesn't read newline, so next call to nextLine will read this newline and nothing new... :-(
            System.out.println("nextInt is: " + nextInt);
        } while (nextInt != 0);
    }

}
