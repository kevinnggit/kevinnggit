package srcb;

public class Rational {
    private int zahl1, zahl2;
    
    public Rational(int zahl1, int zahl2) {
        this.zahl1 = zahl1;
        this.zahl2 = zahl2;
    }

    public void kürz_Print() {

        int num = this.zahl1 / ggT();
        int den = this.zahl2 / ggT();
        System.out.println(num + "/" + den);
    }

//Löse erstmal den ggT im privaten bereich
    private int ggT(int zahl1, int zahl2) {
    
        if(zahl2 == 0) {
           return zahl1;
        }else {
            return ggT(zahl2, zahl1%zahl2);
        }
    }
    //gibt den ggT mit einer public mthode aus
    public int ggT() {
        return ggT(zahl1, zahl2);
    }
    
}
