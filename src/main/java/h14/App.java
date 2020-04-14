package h14;

import h13.hashcode.Person;

import java.util.*;

import static java.lang.Integer.compare;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class App {

    public static void main(String[] args) {
        List<Integer> getallen = new ArrayList<>();
        getallen.add(2);
        getallen.add(0);
        getallen.add(4);
        getallen.add(1);
        getallen.add(3);

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

        System.out.println("max ----------------");

        // Collections and Arrays
        // .max()/min()
        // .binarySearch

        Integer max = Collections.max(getallen);
        System.out.println(max);

        Person[] people1 = {new Person("A", 30), new Person("B", 10), new Person("C", 0)};
        List<Person> people = Arrays.asList(people1);
        Person maxByAge = Collections.max(people);
        System.out.println(maxByAge);

        // Comparator<Person> nameComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());
        // new Comparator<Person>() {
        //     @Override public int compare(Person o1, Person o2) {
        //         return o1.getName().compareTo(o2.getName()); // single return statement in body
        //     }
        // };

        // Person maxByName = Collections.max(people, (o1, o2) -> o1.getName().compareTo(o2.getName()));

        Person maxByName = Collections.max(people, comparing(Person::getName));
        Person minByName = Collections.min(people, comparing(Person::getName));
        System.out.println(maxByName);
        System.out.println(minByName);

        int i = Collections.binarySearch(getallen, 3, Integer::compareTo);
        System.out.println(i);

        // Arrays
        // .asList
        // .toString
        // .equals
        // .copyOf  copyOfRange

        System.out.println("Arrays ---------------------");
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        Integer[] integers1 = integers.toArray(new Integer[0]);
        Integer[] integers2 = {1, 2, 3, 4, 5};
        String s = Arrays.toString(integers1);
        System.out.println(s);
        System.out.println(integers1);
        System.out.println(integers1.toString());
        System.out.println(Arrays.equals(integers1, integers2));

        Integer[] integers3 = Arrays.copyOf(integers1, integers1.length);
        Integer[] integers4 = Arrays.copyOfRange(integers1, integers1.length - 2, integers1.length);
        System.out.println(Arrays.toString(integers4));

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
                System.out.println("gevonden " + person);
            }
        }

        System.out.println("STREAMS ------------------------------------");

        // Streams demo
        personSet.stream()
                .filter(p -> p.getAge() > 20)
                .map(p -> p.getName())
                .sorted()
                .limit(3)
                .forEach(p -> System.out.println(p));

        System.out.println();

        personSet.stream()
                .map(p -> p.getName())
                .filter(n -> n.equalsIgnoreCase("BRAM"))
                .findFirst()
                .ifPresent(p -> System.out.println("gevonden: " + p));

        // max van getallenSet
        int max1 = getallenSet.stream().mapToInt(Integer::intValue).max().orElse(0);

        // sorteer getallenSet en maak er een list van
        List<Integer> collect = getallenSet.stream().sorted().collect(toList());

        // sorteer personSet en ...
        Person reduce = personSet.stream()
                .sorted(comparing(Person::getName))
                .reduce(new Person("", 0), (p, p2) -> new Person(p.getName() + p2.getName(), p.getAge() + p2.getAge()));

        System.out.println(reduce);

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
        return new Person(name, age);
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
