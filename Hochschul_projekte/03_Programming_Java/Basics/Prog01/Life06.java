package Prog01;
public class Life06 {
    
    public static void main (String[]args){
    int zeil=5;
    int zel=11;
    boolean  [][] a= new boolean [zeil][zel];
    
    tab1(a);
    for (int i = 0; i < a.length; i++) {
        
            
        
    }
    
    }
 static void tab1(boolean[][]a){
       
        
    for (int i = 0; i < a.length; i++) {
        for (int j = 0; j <a[i].length; j++) {
           a[i][j] = j % (i + 2) == 0;
           System.out.print(a[i][j] ? "T" : "F");

        }
        System.out.println();
     }
      System.out.println();
       System.out.println();
       System.out.println(zaehleNachbarn(a, 4, 1));

       
       for (int i = 0; i < a.length; i++) {
        for (int j = 0; j < a[i].length; j++) {
           int voisins = zaehleNachbarn(a, i, j);
             a[i][j] = j % (i + 2) == 0;
             if (a[i][j] && voisins==2 || voisins==3 ) {
                System.out.print("T");
             }else if(!(a[i][j]) && voisins==3 ){
                System.out.print("T");
             }else{
                System.out.print("F");
             }
        }
        System.out.println();
       }
    }

    
     
     
   
    
   
      static int zaehleNachbarn(boolean[][] a, int zeil, int zel) {
        int zaehler = 0;
        int zeilen = a.length;
        int spalten = a[0].length;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nachbarZeile = (zeil + i + zeilen) % zeilen;
                int nachbarSpalte = (zel + j + spalten) % spalten;

                // Randüberprüfung und Zelle selbst ausschließen
                //if (nachbarZeile >= 0 && nachbarZeile < zeilen && nachbarSpalte >= 0 && nachbarSpalte < spalten
                      //  && !(i == 0 && j == 0)) {
                        if (i == 0 && j == 0) {
                            continue;
                        }
                    if (a[nachbarZeile][nachbarSpalte]) {
                        zaehler++;
                    }
                }
            }
        //}
        if (a[zeil][zel]) {
            zaehler--;
        }
        return zaehler;


 }
}  
    



