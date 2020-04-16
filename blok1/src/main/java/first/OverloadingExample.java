package first;

public class OverloadingExample {
    public int getal;

    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public float add(float a) {
        return a + a;
    }

    public String add(String a, String b) {
        return a + b;
    }

    public int sum(int n) {
        if (n == 0) { return 0; }
        return n + sum(n - 1);
    }

    public Season selecteerSeason(int i) {
        Season result;
        switch (i) {
            case 10:
                result = Season.SPRING; break;
            case 11:
                result = Season.SUMMER; break;
            case 12:
                result = Season.AUTUMN; break;
            case 13:
                result = Season.WINTER; break;
            default:
                result = null;
        }
        return result;

        // return switch (i) {
        //     case 10 -> Season.SPRING;
        //     case 11 -> Season.SUMMER;
        //     case 12 -> Season.AUTUMN;
        //     case 13 -> Season.WINTER;
        //     default -> null;
        // };

    }
}