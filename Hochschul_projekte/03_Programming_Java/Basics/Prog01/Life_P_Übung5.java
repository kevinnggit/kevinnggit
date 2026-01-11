package Prog01;
public class Life_P_Übung5 {

   /*  public static void main (String[]args){
         life1();
    }
    static void life1(){ 
        int zeil=5;
        int zell=6;
    boolean [][] erste_tabelle= new boolean[zeil][zell];

    for (int i=0;i<erste_tabelle.length;i++){
        for (int j=0;j<erste_tabelle[zell].length;j++){
            erste_tabelle[i][j]=j%(i+2)==0;
          System.out.print(erste_tabelle[i][j]? "T" : "F");
        }
      }
      System.out.println();
      
    }
    */
    public static void main(String[] args) {



    }
    
        static void tabelle1(){
        int  zeil = 5;
        int  zel = 11;
        boolean[][] a = new boolean[zeil][zel];

        for (int i = 0; i < zeil; i++) {
           for (int j = 0; j < zel; j++) {
              a[i][j] = j % (i + 2) == 0;
              System.out.print(a[i][j] ? "T" : "F");
  
           }
           System.out.println();
        
        }
  
     
     }
     static int nachbarn_Zähler(int [][] a, int zeilen, int spalten){
       int nachbarn=0;
       int zeil=a.length;
       int zel=a[0].length;
       for (int i=-1; i<=1; i++){
        for(int j=-1; j<=1; j++){
           int newzeilen=zeilen +1;
           int newspalten=spalten +1;

           if (newzeilen>=0 && newzeilen<zeil && newspalten>=0 && newspalten<zel){
            if (i!=0 && j!=0){
                nachbarn++;
            }
           }
        }

       }
       return nachbarn;

      static boolean[][]  tabelle2(boolean[][]tabelle1){
         int  zeill = tabelle1.length;
        int  zell = tabelle1[0].length;
        
        boolean[][] b = new boolean[zeil][zel];

        for (int i = 0; i < zeil; i++) {
           for (int j = 0; j < zel; j++) {
            //int nachbarn= nachbarn_Zähler(tabelle1, i, j);
            if (tabelle1[i][j]) {
                b[i][j] = nachbarn == 2 || nachbarn == 3;
            } else {
                b[i][j] = nachbarn == 3;
            }
                
           }
           
       
        }
       
       }
       
     }
}