package h6;

import java.util.Scanner;

public class ScannerWrapper {
    Scanner scanner = new Scanner(System.in);

    public String getNextLine() { return scanner.nextLine(); }

}
