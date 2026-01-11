package Prog01;
public class Dezimal_in_binär {
        /*int nbr= 7;
        String res= "";
        do {
             res = nbr % 2 + res;
            nbr = nbr / 2;
            
        } while (nbr!=0);

        System.out.println(res);*/

        /*long nbre = 7L;
        

        System.out.println(binärzahl(nbre));

        }
        static String binärzahl(long a){
           String zahl = "";

           do {
            zahl = (a & 1) + zahl;
            a >>>= 1;
           } while (a != 0);

           return zahl;*/
    public static void main(String[] args) {

           long nbre = 4874633734538743584L;
        int [] binär = binärzahl(nbre);
        tab(binär);
       

        }
        static int [] binärzahl(long a){
           int [] zahl = new int [64];

           for(int i=63; a != 0 && i>=0; i--){
            
            zahl  [i] = (int) (a & 1L);
            a >>>= 1;
            
           }

           return zahl;

        }
        static void tab(int [] tob){
        
        for (int i : tob) {
            System.out.print(i);
        }
        System.out.println();
        }
    }

