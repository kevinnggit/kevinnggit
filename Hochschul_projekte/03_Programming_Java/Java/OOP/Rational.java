package srcb;

/**
 * Repräsentiert eine rationale Zahl (Bruch).
 * Ermöglicht das Kürzen und Ausgeben von Brüchen.
 */
public class Rational {
    
    private int zaehler;
    private int nenner;
    
    /**
     * Erstellt eine neue rationale Zahl.
     * @param zaehler Der Zähler des Bruchs.
     * @param nenner Der Nenner des Bruchs (darf nicht 0 sein).
     * @throws IllegalArgumentException Wenn der Nenner 0 ist.
     */
    public Rational(int zaehler, int nenner) {
        if (nenner == 0) {
            throw new IllegalArgumentException("Nenner darf nicht 0 sein");
        }
        this.zaehler = zaehler;
        this.nenner = nenner;
    }
    
    /**
     * Kürzt den Bruch und gibt ihn auf der Konsole aus.
     * Das Vorzeichen wird im Zähler normalisiert.
     */
    public void kürz_Print() {
        int ggt = ggT(Math.abs(zaehler), Math.abs(nenner));
        int gekürztZaehler = zaehler / ggt;
        int gekürztNenner = nenner / ggt;
        
        // Negative Vorzeichen normalisieren (nur im Zähler anzeigen)
        if (gekürztNenner < 0) {
            gekürztZaehler = -gekürztZaehler;
            gekürztNenner = -gekürztNenner;
        }
        
        System.out.println(gekürztZaehler + "/" + gekürztNenner);
    }
    
    /**
     * Berechnet den größten gemeinsamen Teiler (ggT) zweier Zahlen rekursiv.
     * @param a Erste Zahl.
     * @param b Zweite Zahl.
     * @return Der größte gemeinsame Teiler.
     */
    private int ggT(int a, int b) {
        if (b == 0) {
            return a;
        }
        return ggT(b, a % b);
    }
}
