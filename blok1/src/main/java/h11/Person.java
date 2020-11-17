package h11;

import h10.person.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.awt.*;

/**
 * Note: this class has a natural ordering that is inconsistent with equals.
 */
@Data
@AllArgsConstructor
@Builder
public class Person implements Comparable<Person> {

    private final String name;
    private int age;
    private Gender gender;
    private int schoenmaat;
    private String address;
    private Color kleurOgen;

    // @Override
    // public boolean equals(Object p) {
    //     return
    // }

    @Override
    public int compareTo(Person o) {
        // this<o  negatief
        // this>o  positief
        // this==o 0
        if (this.age < o.getAge()) return -1;
        if (this.age > o.getAge()) return 1;
        if (this.age == o.getAge()) return 0;

        return 0;
    }
}
