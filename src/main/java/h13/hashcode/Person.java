package h13.hashcode;

import java.util.Objects;

public class Person {

    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return /*age == person.age &&*/
                Objects.equals(name, person.name);
    }

    @Override public int hashCode() {
        // return super.hashCode(); // returns the 'address' of this object; unique for each instance
        // return 1; // every person has the same hashcode: functionally ok, but no performance benefits in hash tables since every person wil be stored under the same key
        return Objects.hash(name, age); // unique hashcode for each name/age combination; if more specific than equals, two equal persons can get different has codes; that's not good, since they will be added to a hashset though they are equal...

    }
}
