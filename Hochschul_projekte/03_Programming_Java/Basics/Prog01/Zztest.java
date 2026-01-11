package Prog01;

public class Zztest {
    /*public static void main(String[] args) {
        int n = 5;
        //doitB(n);
        doitA(n);
    }

    static void doitB (int n){

        if (n > 0) {

            doitB(n-1);
            System.out.println(n);
            
        }
    }

    static void doitA (int n){

        if (n > 0) {
            
            System.out.println(n);
            doitA(n-1);
        }
    }*/


    //static int x = 0;
    /*public static void main(String[] args) {
        int n = 5;
        System.out.println(doitA(n));
    }

    static int doitA(int n){
        
        if (n > 0) {
            ++x;
         return doitA(n-1)+x;
           

        }
    
        return 0;
    }
}*/
       /*
        doitA(5) = doit(4)+1 = 4+1   4+1
                             = 3+2   3+1 +1
                             = 2+3   2+1 +1 +1
                             = 1+4   1+1 +1 +1 +1
                             = 0+5   1+1 +1 +1 +1+ +1
         5+5+5+5+5                    
        */

        
        /*static int i = 0;
        static void xyz(int a, int b) {
        ++a;
        ++i;
        a = b;
        a = b;
        }
        public static void main(String[] args) {
        int[] n = { 10, 20, 30 };
        xyz(n[i], ++i);
        for (int i : n)
            System.out.print(i + "\t");
        System.out.println();
        System.out.println(i);
    */

    /*public static void main(String[] args) {
        int a[] = {2,5,6,16,24,32,64,50};
        int [] c = potenz(a);
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + " ");
        }
    }

    static int[] potenz(int [] a){
          
        int [] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
         if (a[i] > 0 && (a[i] &(a[i]-1)) == 0) {
             b[i] = a[i];
         }else{
            
            }
         }
        
        return b;
    }*/

/*public static void main(String[] args) {

    int [] zahl = {2,4,5,12,7,32,16};
     int [] c = search(zahl, 0);
     
    
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + " ");
        }
     

   }

   static int div(int zahl){
       while (zahl != 1 && zahl % 2 == 0) {
         zahl /= 2;
       }
       return zahl;
    }

   static int[] search (int a [], int index){

    int [] b = new int[a.length];
    while (index < a.length) {
        if (div(a[index]) == 1 || div(a[index]) == -1) {
            b[index] = a[index];
        }else{

        }
        
        index++;
    }
    return b;
   }*/

   /*public static void main(String[] args) {
      int [][] a = {
        {4,67,5,8,9,87,2},
        {2,1,89,65,34,90},
        {45,2,12,46,78,96},
                   };
                
                   find_gl_kl(a);
   }
   static void find_gl_kl(int [][] a){


      for (int i = 0; i < a.length; i++) {
        double kl = a[i][0], gl = a[i][0];
        for (int j = 0; j < a[i].length; j++) {
            if (a[i][j] > gl) {
                gl = a[i][j];
            }
            if (a[i][j] < kl) {
               kl = a[i][j];
            }
            
        }
        System.out.print(kl + " + " + gl + "  = ");
        double durchschnitt = (kl + gl)/2;
        System.out.println(durchschnitt);
    }
          
      }*/
   
    public static void main(String[] args) {
        int zahl = 42;
        convert(zahl);
    }

    static void convert(int zahl){
        int [] a = new int[32];
        for (int i = a.length-1; i > 0; i--) {
            a[i] = (zahl >> i) & 1; 
        }

        for (int i = a.length-1; i > 0; i--) {
            System.out.print(a[i]);
        }
    }
}