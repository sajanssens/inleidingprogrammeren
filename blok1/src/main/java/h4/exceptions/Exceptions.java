package h4.exceptions;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Exceptions {

    public static void main(String[] args) {

        // try with resources
        try (InputStream in = new BufferedInputStream(null)) {
            int available = in.available();
        } catch (IOException e) {
            e.printStackTrace();
        } // in.close()

        try {
            Catalogus catalogus = new Catalogus();
            String zoek = catalogus.zoek(2);
            System.out.println(zoek);
            return;
        } catch (VoorraadleegException e) {
            System.out.println("Er ging iets mis in het magazijn: " + e.getMessage());
        } catch (ArtikelNietGevondenException e) {
            System.out.println("Zoeken gaf geen resultaat, door: " + e.getMessage());
        } catch (Exception e) {
            // System.out.println("Zoeken gaf geen resultaat, door: " + e.getMessage());
        } finally {
            System.out.println("Einde zoeken.");
        }

        // exceptions afhandelen:
        // 1) try..catch
        // 2) throws toevoegen, dus teruggooien

        System.out.println("Einde programma.");
    }

}
