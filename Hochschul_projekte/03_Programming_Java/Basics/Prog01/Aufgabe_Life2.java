package Prog01;
public class Aufgabe_Life2 {
   public static void main(String[] args) {
      int zeil = 5;
      int zel = 11;
      boolean[][] a = new boolean[zeil][zel];

      for (int i = 0; i < zeil; i++) {
         for (int j = 0; j < zel; j++) {
            a[i][j] = j % (i + 2) == 0;
            System.out.print(a[i][j] ? "T" : "F");

         }
         System.out.println();
      }

   
   }

}
