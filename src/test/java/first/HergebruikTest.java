package first;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HergebruikTest {
    @Test
    void alsSnelheidLaagDanSeinIsGroen() {
        int snelheid = 30;
        String kleurSein;

        if (snelheid <= 30) {
            kleurSein = "groen";
        } else {
            if (snelheid <= 50) {
                kleurSein = "oranje";
            } else {
                kleurSein = "rood";
            }
        }

        assertThat(kleurSein).isEqualTo("groen");
    }
}
