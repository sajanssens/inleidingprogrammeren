package h5;

public class Fibo {

    long run(long f1, long f2, int n) {
        long fOne = f1;
        long fTwo = f2;
        long sum = fOne + fTwo;

        System.out.print(fOne + " ");
        System.out.print(fTwo + " ");

        for (int i = 0; i < n - 2; i++) {
            System.out.print(sum + " ");
            fOne = fTwo;
            fTwo = sum;
            sum = fOne + fTwo;
        }

        return fTwo;
    }

    long run(long start, int n) {
        return run(start, start, n);
    }

    long run(int n) {
        return run(1, n);
    }

    float goldenRatio(int n) {
        long run1 = run(n);
        long run2 = run(n - 1);
        return (float) run1 / run2;
    }

}
