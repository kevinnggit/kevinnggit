package Prog01;

/*public class ztrain {                    //summe
    public static void main (String [] args){
     int num =0;
     for (int i=0; i < 10; ++i) {
          num =num +i;        
     }   
     System.out.println(num);
}
}*/
/*public class ztrain {                    //call by...
     public static void main(String[] args) {                       
         int x =  10;
         System.out.println("Vor dem Aufruf von changeValue: " + x);
         changeValue(x); //call by value
         System.out.println("Nach dem Aufruf von changeValue: " + x);
         x = changeValue(x); //call by reference
         System.out.println("Nach dem Aufruf von changeValue: " + x);
     }
 
     public static int changeValue(int value) {
         return 20;
     }
 }*/
/*public class ztrain {                   //modify_array
     public static void main(String[] args) {
         int[] numbers = {1,  2,  3};
         System.out.println("Vor dem Aufruf von modifyArray: " + java.util.Arrays.toString(numbers));
         modifyArray(numbers);
         System.out.println("Nach dem Aufruf von modifyArray: " + java.util.Arrays.toString(numbers));
     }
 
     public static void modifyArray(int[] arr) {
         arr[0] =  10;
         arr[1] =  20;
         arr[2] =  30;
     }
 }*/
/*public class ztrain {                   //xyz
     static int i = 0;
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
     for (int i : n)
     System.out.print(i);
     }
     }*/
/*public class ztrain {               //doit
          public static void main(String[] args) {
              boolean i = true; 
               doit(); 
               System.out.println(i);

          }
          public static void makeit(){
              System.out.println("laid");
          }
          
               public static void doit(){
                    int i = 0;
                    System.out.println(i);
                    i = 42;
                    makeit();
               }
          }*/
/*public class ztrain {                    //print_Rechteck
      public static void main(String[] args) {
             int a = 10, b = 10;
          print_rechteck(a, b);
          
      }
      public static void print_rechteck(int a, int b){
              for (int i = 0; i < a; i++) {
               System.out.print("_");
              }
              System.out.println();
          for (int i = 0; i < a; i++) {
              
               for (int j = 0; j < b; ++j) {
                    System.out.print("+");
               for (int k = 0; k < a-2; k++) {
                    System.out.print(" ");
               }
                     System.out.print("+");
                     System.out.println();
          }
          }
              for (int i = 0; i < a; i++) {
               System.out.print("_");
              }
      }
}*/
/*public class ztrain {                    //doit 2
    public static void main(String[] args) {
        n =0;
        doit(n);
        System.out.println(n);
        System.out.println(n+2);
        System.out.println((n+2)+1);
    }
    static int n;
    static void doit(int k){
        ++n;
        k += 4;
        System.out.println(n);
    }
}*/
/*public class ztrain{                       //(num_separator)je dois encore reussir a sauvegarder le resultat dans un array
    static int r;
    public static void main(String[] args) {
        int a = 173456789;
        int [] b = new int [9];
        
        while(a!=0){
            r = a % 10;
           System.out.println(r);
            a = a / 10;
        }
          for (int i = 0; i < b.length; i++){
            System.out.print((b[i] = r) + "\t");
          }

        
    }
}*/

/*public class ztrain{                      //Quotient
    public static void main(String[] args) {
        quotient_calculator(1578434654, 10);
    }
        static void quotient_calculator(int a, int b){
        
        while(a > b){
          a = a / b;
          System.out.println(a);
        }
    }
}*/
/*public class ztrain{      // (num_counter)hier kann ich es mit parameterübergabe tun oder mit einer statischen variable arbeiten
    static int a;
    public static void main(String[] args) {
        System.out.println(12345);
        //int a = 12345;
        a = 12345;
        num_counter();
        
        
    }

    static void num_counter(){
        
        int count=0;
       while (a > 0) {
        
         int r  = a / 10;
         a = r;
         count++;
       }
       System.out.println(count);
        
    }
}*/

/*public class ztrain{                       //Test aus der vorlesung
    public static void main(String[] args) {
        int [] i1 = new int [4];
        int [] i2 = new int [3];
        System.out.println(store(strange(i2)));

        
    }
    public static int[] strange(int [] i){
        if(i.length > 3)
        return i;
        else
        return new int[4];
    }

    public static void store(int[] j){
       j[2] =13;
    }
}*/
/*public class ztrain {                       //Quersumme

    public static void main(String[] args) {
        quersumme(12345);
    }

    static void quersumme(int a){
        
          int sum= 0;
        while (a > 0){

        int r = a % 10;
            sum += r;
            a = a / 10;
          
        }
        System.out.println(sum);

    }
}*/
/*public class ztrain {                      //teiler
    public static void main(String[] args) {
        int nbre = 4268;
        teiler(nbre);
        
    }

    static void teiler(int a){
        int arr = 32;
        int [] table = new int[arr];
         int diviseur = 1;
         int summe = 0;
        while(a >= diviseur){
            int res = a % diviseur;
            if(res == 0){
                table[summe] = diviseur;
                summe++;
                } else {
                //continue;
            }

            diviseur++;
        }
       
        for (int j = 0; j < table.length; j++) {
            
        System.out.print(table[j] + " ");
        
        }
        System.out.println();

        System.out.println(summe);
    }
}*/
/*import java.util.Scanner;

public class ztrain{
    static int zahl;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Zahl eingeben: ");
        zahl = sc.nextInt();
        System.out.println(zahl);
        primZahl();
    }

    static void primZahl(){
        int [] table = new int[zahl];
        int count = 0;
        int diviseur = 1;
        while (zahl >= diviseur) {
            table[count] = zahl % diviseur;
            count++;
            diviseur++;
        }
        for (int i = 0; i < table.length; i++) {
            System.out.print(table[i] + " ");
        }
            System.out.println();

            boolean erste_letzte = table[0] == 0 & table[table.length -1] == 0;
            boolean anders = true;
            for (int i = 1; i < table.length -1; i++) {
                if (table[i] == 0) {
                    anders = false;
                    
                }
            }
            if (erste_letzte & anders) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            
        
    }


}*/
/*public class ztrain{                          //palindrome
    static int countern;
    static int [] table;
    public static void main(String[] args) {
        int a = 21212;
        countern = nbre_chiffres(a);
        table = new int[countern];
        in_array(a);
        palindrome();

        boolean p = true;
        for (int i = 0; i < table.length / 2; i++) {     
        if (table[i] != table[table.length-1-i]) {
            p = false;
        }
    }
        System.out.println(p);
    
    }

    static void palindrome(){
        
         for (int i = table.length-1; i >= 0; i--) {
            System.out.print(table[i] + " ");
         }
         System.out.println();
    }

    
    static void in_array(int a){
        
        int count = 0;
        while (a > 0) {
            int r = a % 10;
             table[count] = r;
             count++;
            a = a / 10;
            
        }
        for (int i = 0; i < table.length; i++) {
            System.out.print(table[i] + " ");
            
        }
        System.out.println();
    }

    static int nbre_chiffres(int a){
         countern = 0;
        while (a > 0) {
             a = a / 10;
            countern++;
            }
         return countern;
    }
}*/
/*public class ztrain{                         //Dezimalzahl in binär
    public static void main(String[] args) {
        int zahl = 42;
        convert(zahl);
    }
    
    public static void convert(int zahl){
        int []  table = new int[32];
        int count = 1;
        while (zahl > 0) {
            int r = zahl % 2;
            table [count] = r;
            System.out.println(table[count]);
            count++;
            zahl /= 2;
            
        }

        for (int i = table.length-1; i > 0; i--) {
            System.out.print(table[i]);
        }
    }
}*/

/*public class ztrain{                               //Binär to dezimal

    static int [] table;
    static int produit;
    public static void main(String[] args) {
        int a = 1110;
        in_array(a);
        System.out.println();
        convert();
        
        
    }

    static void  in_array(int a){
       int b = a ;
        int count = 0;
        while (b > 0) {
            b /= 10;
            count++;
        }

        table = new int[count];

        int count1 = 0;
        while (a > 0) {
            int r = a % 10;
            table[count1] = r;
            count1++;
            a /= 10;
           
        }

        for (int i = table.length-1; i >= 0; i--) {
            System.out.print(table[i]);
        }
        
    }

    static void convert(){
        int counter = 0;
        produit = 0;
        
        //boolean erst = table[0] == 1;
        //if (erst){
        //    produit += 1;
        //}else {
        //    produit += 0;
        //}
        for (int i = table.length-1; i > 0; i--) {
            int pro = 1;

            if (table[i] == 0) {
                
            }  else if (table[i] == 1 && i == 0){
                pro = 1;
            }else{
             
               for (int j = 0; j < i; j++) {
                
                pro *= 2;
                
               }
               //produit += pro;
               
            }
            produit += pro;
            counter++;
        }
    

        System.out.println(produit);
        
    }
}*/

/*public class ztrain{

    public static void main(String[] args) {
        int bit = 32;
        int zahl = 42;
        
        convert_to_binär(zahl, bit);
    }

    static void convert_to_binär(int zahl, int bit){
         int [] array = new int[bit];
        for (int i = array.length-1; i > 0; i--){
               array[i] = (zahl >> i) & 1;
        }

        for (int i = array.length-1; i >= 0; i--) {
            System.out.print(array[i]);
        }
    }
}*/

/*public class ztrain {                     //nbr avec le plus de 1 dans son binär

    public static void main(String[] args) {
        int bit = 32;
        int zahl = 42;
        int [] a = {4,5,6,10,3,7,2,};
        groesste_Anzahl(a);
        
        //convert_to_binär_and_count(zahl, bit);
        
        
    }
   
    static int convert_to_binär_and_count(int zahl, int bit){
        int [] array = new int[bit];
       for (int i = array.length-1; i >= 0; i--){
              array[i] = (zahl >> i) & 1;
       }
                 int count = 0;
          for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                count++;
            }
          }
          return count;
       }
    
       static void groesste_Anzahl(int [] a){
        int tab []= new int [a.length];
        for (int i = 0; i < a.length; i++) {
           
            tab[i] = convert_to_binär_and_count(a[i], 32);
           
        }
        int gr = tab[0];
        int index_gr = 0;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] > gr) {
                gr = tab[i];
                index_gr = i;
            }
        }

        for (int i = 0; i < a.length; i++) {
            if (index_gr == i) {
                System.out.println(a[i]);
            }
        }
       }
    }*/

    public class ztrain {
    
        public static void main(String[] args) {
            int b = 18;
            System.out.println(pruef(b));
        }
        static boolean pruef(int zahl){
            int n = 2;
            boolean a = true;
            if (zahl < n) {
                 a = false;
            }
            while (n < zahl) {
                if (zahl % n == 0) {
                    a = false;
                    
                }
                n++;
                
            }
            return a;
        }
    }