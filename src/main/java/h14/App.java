package h14;

import h11.Person;

import java.util.*;

import static java.lang.Integer.compare;

public class App {

    public static void main(String[] args) {
        List<Integer> getallen = new ArrayList<>();
        getallen.add(0);
        getallen.add(1);
        getallen.add(2);
        getallen.add(3);
        getallen.add(4);

        // Zoeken:
        // O(1) // constant, altijd even goedkoop
        // O(log n) //
        // O(n) // als er 10 elementen in zitten, kost het 10, maar bij twintig 20, dus twee keer zoveel
        // O(n^2)  // als er 10 elementen in zitten, kost het 10, maar bij twintig 20, dus vier keer zoveel
        // O(n^3) // ...:-(
        // doeIetsMetEenList(getallen);

        // CRUD Read Update Delete
        Integer integer = getallen.get(0); // goedkoop
        getallen.add(3, 3);

        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(9);
        linkedList.add(6);
        linkedList.add(3);
        linkedList.add(3);
        linkedList.add(1);

        print(linkedList);
        Integer integer1 = linkedList.get(3); // duurder

        // Utility classes:
        // Collections
        // Arrays

        Collections.sort(linkedList, (o1, o2) -> compare(o2, o1));
        print(linkedList);

        Set<Integer> getallenSet = new TreeSet<>((o1, o2) -> compare(o2, o1));
        getallenSet.add(9);
        getallenSet.add(6);
        getallenSet.add(3);
        getallenSet.add(3);
        getallenSet.add(1);
        getallenSet.add(-1);
        getallenSet.add(10);

        print(getallenSet);

        Set<Person> personSet = new TreeSet<>();
        Person bram = person("Bram", 40);
        Person bram2 = person("Bram", 45);
        Person harry = person("Harry", 56);
        Person mieke = person("Mieke", 5);
        Person gijs = person("Gijs", 6);
        personSet.add(bram);
        personSet.add(bram2);
        personSet.add(harry);
        personSet.add(mieke);
        personSet.add(gijs);
        print(personSet);
        personSet.add(person("Wesley", 25));
        print(personSet);

        for (Person person : personSet) {
            if (person.getName().equalsIgnoreCase("BRAM")) {
                System.out.println("gevonden");
            }
        }

        Map<String, Person> personMap = new HashMap<>();
        add(bram, personMap);
        add(harry, personMap);
        add(gijs, personMap);
        add(mieke, personMap);

        Person bram1 = personMap.get("Bram");
        System.out.println(bram1);
        System.out.println(bram1.equals(bram));
    }

    private static Person person(String name, int age) {
        return Person.builder().name(name).age(age).build();
    }

    private static void add(Person p, Map<String, Person> personMap) {
        personMap.put(p.getName(), p);
    }

    public static void print(Collection<?> lijstje) {
        System.out.println("Printing... " + lijstje.getClass().getName());

        for (Object o : lijstje) {
            boolean contains = lijstje.contains(o);
            System.out.println(o);
        }
    }

}
