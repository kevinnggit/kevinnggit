package Prog01;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/*public class ztrain2 {
    public static void main(String[] args) {
        int size = 10;
        int [] fill = fillint(size);
     
        for (int i = 0; i < fill.length; i++) {
            System.out.print(fill[i] + " ");
        }
        System.out.println();

        System.out.print("Geben Sie eine Zahl ein: ");
        Scanner sc = new Scanner(System.in);
        int zahl = sc.nextInt();
        
        int index = suche(fill, zahl);
        System.out.println(index);
        
    }

    public static int [] fillint(int size){
        int [] temp = new int [size];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = ThreadLocalRandom.current().nextInt(-100,100);
        }
        return temp;
    }

    public static int suche(int [] array, int zahl){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == zahl) {
                return i;
            }
        }
        return -1;
    }
    
}*/

/*public class ztrain2 {

     public static void main(String[] args) {
        int size = 10;
        int [] fill = fillint(size);
        for (int i = 0; i < fill.length; i++) {
            System.out.print(fill[i] + " ");
        }
        System.out.println();
        int element = suche_groesste_zahl(fill);
        System.out.println(element);
        int index = suche_Id_groesste_zahl(fill);
        System.out.println(index);
        int element1 = suche_kleinste_zahl(fill);
        System.out.println(element1);
     }

     public static int [] fillint(int size){
        int [] temp = new int[size];
        for (int i = 0; i < temp.length; i++){
            temp[i] = ThreadLocalRandom.current().nextInt(-100, 100);
        }
        return temp;
     }

     public static int suche_groesste_zahl(int [] array){
            int gr = array[0];
        for (int i = 0; i < array.length; i++) {
            if(array[i] > gr){
                gr = array[i];
            }
            //array[i] = array[i+1];
        }
        return gr;
     }

     public static int suche_Id_groesste_zahl(int [] array){
        int gr = array [0];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > gr) {
                gr = array[i];
                index = i;
            }
        }
        return index;
     }

     public static int suche_kleinste_zahl(int [] array){
        int kl = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < kl) {
                kl = array[i];
            }
        }
        return kl;
     }
}*/

 /*public class ztrain2 {
 
     public static void main(String[] args) {
        int size = 10;
        int fill[] = fillint(size);

        for (int i = 0; i < fill.length; i++) {
            System.out.print(fill[i] + " ");
        }

        System.out.println();

            int index2 = zweit_groesster(fill);
            System.out.println(index2);
        
     }
     public static int [] fillint(int size){
        int [] temp = new int[size];
        for (int i = 0; i < temp.length; i++){
            temp[i] = ThreadLocalRandom.current().nextInt(-100, 100);
        }
        return temp;
     }

     static int zweit_groesster(int [] array){
        int gr = array[0];
        int b = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > gr) {                    //avant que la valeur de gr(plus grand) ne soit initialiser
                                                    //sa derniere valeur est sauvegarder dans b(dexieme plus grand)
                b = gr;
                gr = array[i];
                
            }    
            
        }
       
        return b;
     }
 }*/

 /*public class ztrain2 {                              //summe des chiffres eindimensional
    public static void main(String[] args) {
        int size = 10;
        int [] fill = fillint(size);
        for (int i = 0; i < fill.length; i++) {
            System.out.print(fill[i] + " ");
        }
        System.out.println();
         int summearr =summe_eindimensional(fill);
         System.out.println(summearr);
    }

    public static int[] fillint(int size){
        int []temp = new int[size];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = ThreadLocalRandom.current().nextInt(-100,100);
        }
        return temp;
    }

    static int summe_eindimensional(int []array){
        int summe = 0;
          for(int i = 0; i < array.length; i++){
            summe += array[i];
          }
          return summe;
    }
 }*/

 /*public class ztrain2 {
    public static void main(String[] args) {
        int [][] zd = print_fillint();
        //System.out.print(zd);
        System.out.println();
       int somm = summe_zweidimensional(zd);
       System.out.println(somm);
    }

    public static int [][] fillint(int size_long, int size_large){
        int [][] temp = new int[size_long][size_large];
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                temp[i][j] = ThreadLocalRandom.current().nextInt(-100,100);
            }
        }
        return temp;
    }

    static int [][] print_fillint(){
        int size_long = 5, size_large = 5;
        int [][]zweid = fillint(size_long, size_large);

          for (int i = 0; i < zweid.length; i++) {
            for (int j = 0; j < zweid.length; j++) {
                System.out.print(zweid[i][j] + "\t");
            }
            System.out.println();
          }
          return zweid;
    }

    static int summe_zweidimensional(int [][]array){
        int summe = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                summe += array[i][j];
            }
        }
        return summe;
    }
 }*/

 /*public class ztrain2 {
 
    public static void main(String[] args) {
        int size = 10;
        int []arr = fillint(size);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        swap(arr);

    }
    public static int []fillint(int size){
        int temp[] = new int[size];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = ThreadLocalRandom.current().nextInt(-100,100);
        }
        return temp;
    }
    static void swap(int [] array){
        int a = array[0];
        array[0] = array[array.length-1];
        array[array.length-1] = a;
        System.out.print(array[0] + " ");
        for (int i = 1; i < array.length-1; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.print(a);
    }
 }*/

 /*public class ztrain2 {
 
    public static void main(String[] args) {
        int size_long = 5, size_large = 5;
        int [][]arr = fillint(size_long, size_large);
        print(arr);
        swap_gr_kl(arr);
        
        
    }

    static void print(int [][]arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int [][] fillint(int size_long, int size_large){
        int [][] temp = new int[size_long][size_large];
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                temp[i][j] = ThreadLocalRandom.current().nextInt(-100,100);
            }
        }
        return temp;
    }

    static int suche_groesste_zahl(int [][]array){
        int gr = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] > gr){
                    gr = array[i][j];
                } 
            }
        }
        return gr;
    }
    static int suche_kleinste_zahl(int [][]array){
        int kl = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] < kl) {
                    kl = array[i][j];
                }
            }
        }
        return kl;
    }

    static void swap_gr_kl(int [][]array){
        int gr1 = suche_groesste_zahl(array);
        int kl1 = suche_kleinste_zahl(array);
        System.out.print(gr1 + " " + kl1);
        System.out.println("\n");
        int a = gr1;
          gr1 = kl1;
          kl1 = a;
          for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] == a) {
                    System.out.print(gr1 + "\t");
                } else if (array[i][j] == gr1 ) {
                    System.out.print(kl1 + "\t");
                }else{
                    System.out.print(array[i][j] + "\t");
                }
            }
            System.out.println();
          }
          
    }
 }*/

 public class ztrain2 {
 
    public static void main(String[] args) {
        int []arr1 = {1,3,5,7,9,11,13,15,40};
        int []arr2 = {2,4,20,6,8,10,12,14,16,17,18,19};
        int [] arr3 = marge(arr1, arr2);
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }
        sort(arr3);
        System.out.println();
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }
    }

    static int[] marge(int []array1, int []array2){
        int [] marge_result = new int[array1.length + array2.length];

        int i =0, j = 0, k = 0;
        
        while (i < array1.length && j < array2.length) {
            if (array1[i] > array2[j]) {
                marge_result[k] = array2[j];
                j++;
            } else if (array2[j] > array1[i]) {
                marge_result[k] = array1[i];
                i++;
            } else {
                marge_result[k] = array1[i];
                i++;
                j++;
            }
            k++;
        }
        while (i < array1.length) {
            marge_result[k] = array1[i];
            i++;
            k++;
        }
        while (j < array2.length) {
            marge_result[k] = array2[j];
            j++;
            k++;
        }

        
        return marge_result;
    }

    static int[] sort(int []marge_result){
        for (int i = 0; i < marge_result.length-1; i++) {
        for (int l = 0; l < marge_result.length-i-1; l++) {
            if (marge_result[l] > marge_result[l+1]) {
                int a = marge_result[l];
                marge_result[l] = marge_result[l+1];
                marge_result[l+1] = a;
            }
        }
    }
        return marge_result;
    }
 }