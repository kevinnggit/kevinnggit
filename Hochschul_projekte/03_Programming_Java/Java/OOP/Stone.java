package srcb;

/**
 * Repräsentiert einen Stein (Zelle) im "Game of Life" oder einer ähnlichen Simulation.
 * Jeder Stein hat ein Alter und eine Position (x,y).
 */
public class Stone {

    private int age;
    private int x, y, nextAge;

    /**
     * Konstruktor für einen neuen Stein.
     * @param age Das initiale Alter (0 = tot, >0 = lebendig).
     * @param x X-Koordinate.
     * @param y Y-Koordinate.
     */
    public Stone(int age, int x, int y){
        this.age = age;
        this.x = x;
        this.y = y;
    }

    /**
     * Gibt eine visuelle Repräsentation des Steins auf der Konsole aus,
     * basierend auf seinem Alter.
     */
    public void print() {
        switch (age) {
            case 0:
                System.out.print(" ");
                break;
            case 1:
                System.out.print(".");
                break;
            case 2:
                System.out.print("o");
                break;
            case 3:
                System.out.print("O");
                break;
            default:
                System.out.print("*");
                break;
        }
    }

    /**
     * Prüft, ob der Stein "lebt" (Alter > 0).
     * @return true, wenn lebendig, sonst false.
     */
    public boolean isAlive() {
           return age > 0;
    }

    /**
     * Berechnet den Zustand (Alter) für den nächsten Zeitschritt.
     * Regeln basieren auf der Anzahl der Nachbarn.
     * @param field Das gesamte Spielfeld als 2D-Array.
     */
    public void computeNext(Stone[][] field) {
        this.nextAge = this.age;
        int neighbours = countNeighbour(field);
        
        // Logik: Bleibt am Leben bei 2 oder 3 Nachbarn.
        if (this.isAlive() && (neighbours == 2 || neighbours == 3)) {
            this.nextAge++;
        } 
        // Wird geboren (oder belebt), wenn tot und genau 3 Nachbarn.
        else if (!isAlive() && neighbours == 3) {
            this.nextAge++;
        } 
        // Stirbt in allen anderen Fällen (Unterbevölkerung oder Überbevölkerung).
        else {
              this.nextAge = 0;
        }
    }

    /**
     * Übernimmt den berechneten nächsten Zustand als aktuellen Zustand.
     */
    public void commit() {
        this.age = this.nextAge;
    }

    /**
     * Zählt die lebenden Nachbarn um die aktuelle Position.
     * Berücksichtigt periodische Randbedingungen (Torus-Welt).
     * @param a Das Spielfeld.
     * @return Anzahl der lebenden Nachbarn.
     */
    public int countNeighbour(Stone[][] a) {
        int zaehler = 0;
        int zeilen = a.length;
        int spalten = a[0].length;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                // Torus-Logik: Wrap-around an den Rändern
                int nachbarZeile = (x + i + zeilen) % zeilen;
                int nachbarSpalte = (y + j + spalten) % spalten;

                if (i == 0 && j == 0) {
                    continue; // Sich selbst überspringen
                }

                if (a[nachbarZeile][nachbarSpalte].isAlive()) {
                    zaehler++;
                }
            }
        }

        // Korrektur: Falls Logik vorher sich selbst mitzählte (Legacy Check?)
        if (a[x][y].isAlive()) {
            zaehler--;
        }
        return zaehler;
    }
}