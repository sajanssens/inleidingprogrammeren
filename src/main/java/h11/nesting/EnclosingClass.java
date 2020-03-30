package h11.nesting;

import h11.bank.BankAccount;
import lombok.Data;

public class EnclosingClass {
    private int count = 10;
    private static String data = "abc";

    public void doeIets() {
        int count = 9;
        System.out.println(this.count);
        System.out.println(count);
    }

    public class InnerClass {
        private int count = 5;

        public void doeIets() {
            EnclosingClass.data.toUpperCase();    //ok; data is static
            int count = 1;

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

    public static class StaticNestedClass {
        static int sta = 9;
        int notSta = 90;

        public StaticNestedClass() {
            // count++;               //not accessible here
            EnclosingClass.data.toUpperCase();    //ok; data is static
            System.out.println(sta);
        }

    }

}