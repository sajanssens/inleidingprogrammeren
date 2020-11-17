package first;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HergebruikTest {

    // fields:
    private int snelheid;
    private int gewicht = 200;

    // methods:

    public String bepaalSeinkleur(int snelheid) {
        // snelheid
        int gewicht = 100;

        System.out.println(this.snelheid);
        String kleurSein;
        if (snelheid <= 30) {
            kleurSein = "groen";
        } else if (snelheid <= 50) {
            kleurSein = "oranje";
        } else {
            kleurSein = "rood";
        }

        System.out.println(this.gewicht);

        return kleurSein;
    }

    @Test
    void alsSnelheidLaagDanSeinIsGroen() {
        String resultaat = bepaalSeinkleur(30);

        assertThat(resultaat).isEqualTo("groen");
    }

    @Test
    void alsSnelheidMediumDanSeinIsOranje() {
        String resultaat = bepaalSeinkleur(40);

        assertThat(resultaat).isEqualTo("oranje");
    }

    @Test
    void alsSnelheidHoogDanSeinIsRood() {
        String resultaat = bepaalSeinkleur(140);

        assertThat(resultaat).isEqualTo("rood");
    }
}
