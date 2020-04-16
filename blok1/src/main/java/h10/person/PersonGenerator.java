package h10.person;

public class PersonGenerator {

    public static void main(String[] args) {
        Person p = new Person("Bram", 41, 45, Gender.FEMALE);
        System.out.println(p.getName());

        Person p2 = new Person("Bram", 40, 43, Gender.MALE);

        System.out.println(p.equals(p2));
        System.out.println(p.toString());

        int i = p.hashCode();
    }
}
