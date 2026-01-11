package Prog01;
public class Aufgabe_Live3 {
    
        public static void main(String[] args) {
          // int zeil = 5;
           //int zel = 11;
           boolean[][] a = new boolean[5][11];
     
           for (int i = 0; i < a.length; i++) {
              for (int j = 0; j < a[j].length; j++) {
                 a[i][j] = j % (i + 2) == 0;
                 System.out.print(a[i][j] ? "T" : "F");
     
              }
              
              System.out.println();
           }
     
        
        }
     
     }

