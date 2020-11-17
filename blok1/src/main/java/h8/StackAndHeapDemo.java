package h8;

public class StackAndHeapDemo {
    public static void main(String[] args) {
        // declareren: <type> naam;
        // toekennen:  naam = waarde;

        StackAndHeapDemo app; // declaration
        app = new StackAndHeapDemo(); // assignment
        app.doeIets();
    }

    public /*niet static*/ void doeIets() {
        // this = app;
        Coordinate c1;
        c1 = new Coordinate();
        c1.x = 6.12;
        c1.y = 4.2;
        // HIER
        c1 = null;
    }
}