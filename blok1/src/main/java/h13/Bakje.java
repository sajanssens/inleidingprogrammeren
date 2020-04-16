package h13;

public class Bakje<T> {

    T value;

    public Bakje(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
