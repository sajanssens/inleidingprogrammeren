package h7;

public class Telefoon {

    // FIELDS
    private String merk = "";
    private double prijs = 0.0d;
    private String nummer = "";
    private Hoesje hoesje;

    public static final double MINIMALE_PRIJS = 0.0d;

    // METHODS

    // constructor:
    // public <classname>(){  }
    public Telefoon() {
        this("", -150.0d, "");
        System.out.println("Default ctor.");
        // return ..; GEEN!
    }

    public Telefoon(String beginMerk, String beginNummer) {
        this(beginMerk, 0.0d, beginNummer);
    }

    public Telefoon(String beginMerk, double beginPrijs, String beginNummer) {
        setMerk(beginMerk);
        setPrijs(beginPrijs);
        setNummer(beginNummer);
    }

    public static String geefLandcodes() {
        return "NL 31, DU 44, ...";
    }

    //public <typevanveld> get<Veldnaam>(){ return <hetveld>; }
    public double getPrijs() {
        return prijs;
    }

    // public void set<Veldnaam>(<typevanveld> nieuweWaarde){ <veld> = nieuweWaarde; }
    public void setPrijs(double nieuwePrijs) {
        if (nieuwePrijs >= MINIMALE_PRIJS) {
            this.prijs = nieuwePrijs;
        }
    }

    public String getMerk() { return merk; }

    public void setMerk(String merk) { this.merk = merk; }

    public String getNummer() { return nummer; }

    public void setNummer(String nummer) { this.nummer = nummer; }

    public void setHoesje(Hoesje hoesje) { this.hoesje = hoesje; }

    public Hoesje getHoesje() { return hoesje; }
}
