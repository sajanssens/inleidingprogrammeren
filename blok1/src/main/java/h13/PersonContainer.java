package h13;

import h11.Person;

public class PersonContainer<T extends Person> {

    T value;

    public PersonContainer(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
