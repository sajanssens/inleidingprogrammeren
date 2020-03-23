package h8;

public class Person {

    public int age;

    @Override // annotatie
    public boolean equals(Object o) {
        Person p2 = (Person) o;
        return this.age == p2.age;
    }

    @Override
    public String toString() {
        return "Ik ben " + this.age + " jaar oud.";
    }

}
