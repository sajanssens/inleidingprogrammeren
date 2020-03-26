package h10;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TempEmployeeTest {

    @Test
    void testToString() {
        TempEmployee te = new TempEmployee("", 0);
        String s = te.toString();
        System.out.println(s);
        assertThat(s).contains("name=");
    }
}