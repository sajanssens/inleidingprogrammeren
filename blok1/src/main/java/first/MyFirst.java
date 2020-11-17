package first;

import static first.Season.*;

public class MyFirst {

    public static void main(String[] args) {
        String bericht = geefBericht();
        System.out.println(bericht);
        Season seizoentje1 = SPRING;
        Season seizoentje2 = SUMMER;
        Season seizoentje3 = AUTUMN;
        Season seizoentje4 = WINTER;
        int ordinal = seizoentje1.ordinal();
        String name = seizoentje1.name();

        System.out.println(seizoentje1.geefWaarde());
    }

    static String geefBericht() { return "Hello world!"; }
}
