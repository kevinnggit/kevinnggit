package srcb;

public class Rational {
    
    private int zaehler;
    private int nenner;
    
    public Rational(int zaehler, int nenner) {
        if (nenner == 0) {
            throw new IllegalArgumentException("Nenner darf nicht 0 sein");
        }
        this.zaehler = zaehler;
        this.nenner = nenner;
    }
    
    public void kürz_Print() {
        int ggt = ggT(Math.abs(zaehler), Math.abs(nenner));
        int gekürztZaehler = zaehler / ggt;
        int gekürztNenner = nenner / ggt;
        
        // Negative Vorzeichen normalisieren (nur im Zähler)
        if (gekürztNenner < 0) {
            gekürztZaehler = -gekürztZaehler;
            gekürztNenner = -gekürztNenner;
        }
        
        System.out.println(gekürztZaehler + "/" + gekürztNenner);
    }
    
    private int ggT(int a, int b) {
        if (b == 0) {
            return a;
        }
        return ggT(b, a % b);
    }
}
