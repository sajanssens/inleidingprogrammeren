package h13;

import h11.Person;

import java.util.ArrayList;

public class GenericsDemo {

    // Generic Types

    public static void main(String[] args) {
        GenericsDemo demo = new GenericsDemo();
        ArrayList<String> tekstjes = demo.maakLijst();

        StringBuilder sb = new StringBuilder();
        for (String tekstje : tekstjes) {
            sb.append(tekstje);
        }
        System.out.println(sb);

        BakjeInt bakjeInt = demo.maakBakjeInt();
        Integer value = bakjeInt.getValue();
        System.out.println(value);

        Bakje<Integer> integerBakje = demo.maakBakjeInteger(43);
        Integer value1 = integerBakje.getValue();
        System.out.println(value1);

        Bakje<String> stringBakje = demo.maakBakjeString("43s");
        String value2 = stringBakje.getValue();
        System.out.println(value2);

        Bakje<Integer> integerBakje1 = demo.maakBakje(42);
        Bakje<String> stringBakje1 = demo.maakBakje("44s");
        Bakje<Float> floatBakje = demo.maakBakje(4.2f);
        Bakje<Double> doubleBakje = demo.maakBakje(4.2d);

        Person bram = Person.builder().name("Bram").build();
        PersonContainer<Person> personPersonContainer = demo.maakPersoonContainer(bram);

        PersonContainer<Person> personPersonContainer1 = new PersonContainer<>(bram);
    }

    private ArrayList<String> maakLijst() {
        String[] tekstjes = new String[10];
        tekstjes[0] = "Bram";
        tekstjes[1] = "1";

        ArrayList<String> lijst = new ArrayList<>();
        lijst.add("Bram");
        lijst.add("Bram2");
        lijst.add("Bram3");
        // lijst.add(1);
        // lijst.add(true);
        return lijst;
    }

    private BakjeInt maakBakjeInt() {
        return new BakjeInt(42);
    }

    private Bakje<Integer> maakBakjeInteger(Integer newValue) {
        return new Bakje<>(newValue);
    }

    private Bakje<String> maakBakjeString(String newValue) {
        return new Bakje<>(newValue);
    }

    private <TypeVanValue> Bakje<TypeVanValue> maakBakje(TypeVanValue newValue) {
        return new Bakje<>(newValue);
    }

    private <P extends Person> PersonContainer<P> maakPersoonContainer(P newValue) {
        return new PersonContainer<>(newValue);
    }

}
