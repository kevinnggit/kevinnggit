package srcb;

public class All_Ausführer {

    public static void main(String[] args) {
        
        // Life 1001
        int zeil = 10;
        int spalt = 10;
        //Life1001 life = new Life1001(zeil, spalt);
        //
       // life.ausfüllen();   
        //life.ausgabe();

        System.out.println("😄 \n");

        //Rationale Zahlen
        int zahl1 = 10;
        int zahl2 = 20;
        
        
        Rational rational = new Rational(zahl1, zahl2);
        rational.kürz_Print();


        //Stone
        int x =20;
        int y =30;
    Life life = new Life( x,  y);
    life.run();
        
        
        //bubble
      //  double []tab = {10.3,4.5,7.1,8.3,0.5,1.7,2.9,5.4,8.1,46.8}; 
        //Sortierverfahren sort = new Sortierverfahren(tab);
        //sort.printtable(tab);
        //System.out.println();
        //sort.bubble(tab);
        //sort.printtable(tab);
        

    }
    
}




