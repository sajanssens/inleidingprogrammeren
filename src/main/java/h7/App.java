package h7;

public class App {

    public static void main(String[] args) {
        Telefoon t1 = new Telefoon();

        t1.setMerk("Moto");
        t1.setPrijs(250.99d);
        t1.setNummer("+31612345678");

        System.out.println(t1.getPrijs());
    }
}
