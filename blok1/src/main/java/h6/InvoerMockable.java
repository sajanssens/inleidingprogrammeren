package h6;

public class InvoerMockable {

    ScannerWrapper scanner = new ScannerWrapper();

    public static void main(String[] args) {
        int lengte = new InvoerMockable().run();
        System.out.println("Lengte is: " + lengte);
    }

    public int run() {
        String input = scanner.getNextLine();

        int lengte = bepaalLengte(input);

        return lengte;
    }

    int bepaalLengte(String input) {
        return input.length();
    }

    public void setScanner(ScannerWrapper scanner) {
        this.scanner = scanner;
    }
}
