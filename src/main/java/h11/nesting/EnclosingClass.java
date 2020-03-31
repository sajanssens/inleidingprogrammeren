package h11.nesting;

import h11.bank.BankAccount;
import lombok.Data;

public class EnclosingClass {
    private int count = 10;
    private int countOuter = 20;
    private static String data = "abc";

    public void doeIets() {
        int count = 9;
        System.out.println(this.count);
        System.out.println(count);
    }

    // Behaves like other members (fields and methods) of EnclosingClass, so
    // can access EnclosingClass's state
    public class InnerClass {
        private int count = 5;

        public void doeIets() {
            String s = EnclosingClass.data.toUpperCase();//ok; data is static
            int count = 1;

            System.out.println(countOuter); // ok; accessible

            // shadowing
            System.out.println(count);
            System.out.println(this.count);
            System.out.println(EnclosingClass.this.count); // strange notation!

            @Data
            class LocalInner {
                private int x;
                private int y;
            }

            LocalInner li = new LocalInner();
            li.x = 10;
            li.y = 20;

            System.out.println(li);

            BankAccount ba = new BankAccount(34234234, 400, 1.04) {
                @Override
                public double interest() {
                    return 1000;
                }
            };
            System.out.println(ba.interest());

        }
    }

    // Behaves just like a non-nested class outside EnclosingClass, so
    // can NOT access EnclosingClass's state.
    public static class StaticNestedClass {
        static int countStatic = 9;
        int count = 5;

        public void doeIets() {
            String s = EnclosingClass.data.toUpperCase(); //ok; data is static
            int count = 1;

            System.out.println(countStatic); //ok; data is static
            // System.out.println(countOuter); // NOT accessible!

            // shadowing not an issue here
            System.out.println(count);
            System.out.println(this.count);
            // System.out.println(EnclosingClass.this.count); // NOT accessible!
        }

    }

}