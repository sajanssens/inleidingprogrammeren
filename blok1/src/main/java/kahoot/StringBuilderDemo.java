package kahoot;

public class StringBuilderDemo {

    public static void main(String[] args) {
        int i = 10 + 2;
        String s1 = i + "ABC";
        String str = s1 + 4 + 5;
        StringBuilder s = new StringBuilder(str);
        String substring = s.substring(3, 6);
        StringBuilder result = s.delete(3, 6);
        s.append(result.toString());
        System.out.println(s);
    }

}
