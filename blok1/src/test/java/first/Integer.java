package first;

public class Integer {

    public int value;

    private Integer(int i) { value = i; }

    public static Integer box(int i) { return new Integer(i); }

}
