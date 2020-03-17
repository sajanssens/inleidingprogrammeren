package h7;

public class Telefoon {

    // FIELDS
    private String merk = null;
    private double prijs = 0.0d;
    private String nummer;

    // METHODS

    //public <typevanveld> get<Veldnaam>(){ return <hetveld>; }
    public double getPrijs() {
        return prijs;
    }

    // public void set<Veldnaam>(<typevanveld> nieuweWaarde){ <veld> = nieuweWaarde; }
    public void setPrijs(double nieuwePrijs) {
        if (nieuwePrijs >= 0) {
            prijs = nieuwePrijs;
        }
    }

    public void setMerk(String m) {
        merk = m;
    }

    public void setNummer(String n) {
        nummer = n;
    }

    // ....

}
