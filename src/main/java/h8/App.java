package h8;

public class App {

    public static void main(String[] args) {
        App app = new App();
        // app.vergelijkCoordinaten();
        // app.vergelijkPersonen();
        app.increment();
        app.printPerson();
    }

    private void increment() {
        Coordinate c1 = new Coordinate();
        c1.x = 2;
        c1.y = 3;
        incrementCoordinate(c1);

        System.out.println(c1);
    }

    private void printPerson() {
        Person p = new Person();
        p.age = 40;
        System.out.println(p);
    }

    public void incrementCoordinate(Coordinate c) {
        c.x++;
        c.y++;
    }

    public void vergelijkCoordinaten() {
        Coordinate c1 = new Coordinate();
        c1.x = 6.12;
        c1.y = 4.2;

        Coordinate c2 = new Coordinate();
        c2.x = 6.12;
        c2.y = 4.2;

        if (c1 == c2) { // NIET DE BEDOELING!
            System.out.println("Gelijk!");
        } else {
            System.out.println("Niet gelijk!");
        }

        if (c1.equals(c2)) { // Objecten vergelijk je met eneObject.equals(andereObject)
            System.out.println("Gelijk!");
        } else {
            System.out.println("Niet gelijk!");
        }

    }

    public void vergelijkPersonen() {
        Person p1 = new Person();
        Person p2 = new Person();
        p1.age = 40;
        p2.age = 40;

        if (p1.equals(p2)) {
            System.out.println("P's gelijk!");
        } else {
            System.out.println("P's niet gelijk!");
        }
    }

}
