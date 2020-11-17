package misc;

import h13.hashcode.Person;

public class App {

    public static void main(String[] args) throws InterruptedException {
        Person p = new Person("", 0);

        // Sequential processing:
        // haveBirthdayTenThousandTimes(p);
        // haveBirthdayTenThousandTimes(p);

        // Parallel processing:
        new Thread(() -> haveBirthdayTenThousandTimes(p)).start();
        new Thread(() -> haveBirthdayTenThousandTimes(p)).start();
        Thread.sleep(1000);

        System.out.println(p.getAge());
    }

    private static void haveBirthdayTenThousandTimes(Person p) {
        for (int i = 0; i < 10_000; i++) p.birthday();
    }
}
