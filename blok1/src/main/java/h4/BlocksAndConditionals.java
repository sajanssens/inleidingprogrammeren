package h4;

import first.Season;

public class BlocksAndConditionals {

    // XXXXXXXXXXXX

    // fields -> state

    // XXXXXXXXXXXX

    // methods -> behaviour
    // acc.modifier returntype methodname(<type> <naam>, <type> <naam>, ....){ // header
    // body
    // VVVVVVVVVVVVVVVVVVVVVVV
    // }

    public static void main(String[] args) {
        ifDemo();
        switchDemo();

        switchEnumDemo(Season.AUTUMN);
    }

    public static void ifDemo() {
        long sales = 123456;
        int bonus;
        if (sales < 200_000) {
            bonus = 250;
        } else if (sales > 200_000 && sales < 300_000) {
            bonus = 800;
        } else if (sales >= 300000) {
            bonus = 1000;
        } else {
            bonus = (int) sales / 100;
        }
    }

    public static void switchDemo() {
        int bonus = 0;

        int sales = 300_000;
        switch (sales) {
            case 200_000:
                bonus = 800; break;
            case 300_000:
                bonus = 1200; /*break;*/
            case 400_000:
                int i = 0; // break??
                // doe niks
            case 500_000:
                bonus = 1600; /*break;*/
        }

        System.out.println(bonus);

        String name = "Bram";

        switch (name.substring(0, 1)) {
            case "H":
                System.out.println("het is harry!"); break;
            case "B":
                System.out.println("Bram"); break;
            default:
                System.out.println("Tsja.......");
        }

        return; // break uit de methode;
    }

    public static String switchEnumDemo(Season eenSeizoen) {
        switch (eenSeizoen) {
            case AUTUMN:
                System.out.println("Het is herfst!"); return "H"; // break uit de methode (en dus ook de switch) EN geef daarbij "H" terug;
            case SPRING:
                System.out.println("Het is lente!"); return "L";
            default:
                System.out.println("Het is ... geen idee..."); return "U";
        }
    }

}
