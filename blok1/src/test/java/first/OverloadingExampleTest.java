package first;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OverloadingExampleTest {

    private OverloadingExample target;

    @BeforeEach
    void setUp() {
        target = new OverloadingExample();
    }

    @Test
    void addTest() {
        String add = target.add("10", "20");
        int add1 = target.add(10, 20, 30);
        float add2 = target.add(10f);
        int add3 = target.add(10, 20);
    }

    @Test
    void sum() {
        int result = target.sum(10);
        assertThat(result).isEqualTo(55);
    }
}