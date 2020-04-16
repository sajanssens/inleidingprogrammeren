package h5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FiboTest {

    @Test
    void fibo1() {
        // class object = constructoraanroep;

        // given
        Fibo f1 = new Fibo();

        // when
        long result = f1.run(6);

        // then
        assertEquals(8, result);
    }

    @Test
    void fibo2() {
        Fibo f1 = new Fibo();
        long run = f1.run(4, 6);
        assertEquals(32, run);
    }

    @Test
    void fibo3() {
        assertEquals(37, new Fibo().run(4, 5, 6));
    }

    @Test
    void goldenratioTest() {
        Fibo f1 = new Fibo();
        float gr = f1.goldenRatio(10);

        assertEquals(1.617647f, gr);
    }

    @Test
    void goldenratioFindN() {
        Fibo f1 = new Fibo();

        int result = 0;
        for (int n = 47; n < 10000; n++) {
            float gr = f1.goldenRatio(n);
            if (gr > 1.7d || gr < 1.6d) {
                result = n;
                break;
            }
        }
        System.out.println();
        System.out.println(result);

        // assertEquals(1.617647f, gr);
    }
}