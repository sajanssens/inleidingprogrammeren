package h11.nesting;

public class StaticNestedClassStandalone {
    static int countStatic = 9;
    int count = 5;

    public void doeIets() {
        // String s = EnclosingClass.data.toUpperCase(); //nok; data is static but private
        int count = 1;

        System.out.println(countStatic); //ok; data is static

        System.out.println(count);
        System.out.println(this.count);
    }
}
