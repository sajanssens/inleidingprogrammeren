package h11;

import static h10.person.Gender.MALE;
import static java.awt.Color.BLUE;

public class App {

    public static void main(String[] args) {
        Person bram = Person.builder().name("Bram").age(40).gender(MALE).kleurOgen(BLUE).build();
        System.out.println(bram);
    }
}
