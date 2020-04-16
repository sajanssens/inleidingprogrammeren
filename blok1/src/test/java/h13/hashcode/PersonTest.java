package h13.hashcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PersonTest {

    @Test
    void hash() {
        Person p0 = new Person("Bram", 12);
        Person p1 = new Person("Bram", 13);
        Person p2 = new Person("Bram", 13);

        assertTrue(p0 != p1);
        assertEquals(p0, p0);
        assertEquals(p0, p1);
        assertEquals(p1, p2);

        System.out.println(p0);
        System.out.println(p1);

        Set<Person> set = new HashSet<>();
        boolean add0 = set.add(p0);
        boolean add11 = set.add(p1);
        boolean add12 = set.add(p1);
        boolean add2 = set.add(p2);
        boolean bram2 = set.add(new Person("Bram2", 13));

        System.out.println(add0);
        System.out.println(add11);
        System.out.println(add12);
        System.out.println(add2);
        System.out.println(bram2);

        for (Person person : set) {
            System.out.println(person);
        }

        int size = set.size();
        System.out.println(size);
        boolean contains0 = set.contains(p0);
        boolean contains1 = set.contains(p1);
        System.out.println(contains0);
        System.out.println(contains1);

        Map<Integer, Person> integerPersonMap = new HashMap<>();
        integerPersonMap.put(0, p0);
        integerPersonMap.put(1, p1);
        integerPersonMap.put(2, p2);
        Set<Map.Entry<Integer, Person>> entries = integerPersonMap.entrySet();
        for (Map.Entry<Integer, Person> entry : entries) {
            Integer key = entry.getKey();
            Person value = entry.getValue();
            System.out.print(key);
            System.out.print(", ");
            System.out.println(value.name);
        }
    }
}