package h7;

import java.awt.*;

public class Hoesje {

    private Color kleur;
    private boolean heeftFlap;

    public Hoesje(Color kleur, boolean heeftFlap) {
        this.kleur = kleur;
        this.heeftFlap = heeftFlap;
    }

    public Color getKleur() {
        return kleur;
    }

    public void setKleur(Color kleur) {
        this.kleur = kleur;
    }

    public boolean isHeeftFlap() {
        return heeftFlap;
    }

    public void setHeeftFlap(boolean heeftFlap) {
        this.heeftFlap = heeftFlap;
    }
}
