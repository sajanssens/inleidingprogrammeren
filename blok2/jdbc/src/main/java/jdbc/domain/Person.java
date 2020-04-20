package jdbc.domain;

public class Person {
    public final String name;
    public final int age;
    public final Gender gender;

    public Person(String name, int age) {
        this(name, age, Gender.Onbekend);
    }

    public Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
