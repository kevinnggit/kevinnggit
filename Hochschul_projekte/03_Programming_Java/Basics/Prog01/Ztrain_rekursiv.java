 package Prog01;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;


/*class Ztrain_rekursiv {

    public static void main(String[] args) {
        int n = 5;
        String s = "Bien";
        doit(s, n);
    }

    static void doit(String s, int n){
        
        if (n > 0) {

            System.out.println(s);
            doit(s, n-1);
            
        }
    }
}*/

/*public class Ztrain_rekursiv {

    public static void main(String[] args) {
        int n = 100;
        int summe = summe_nzahlen(n);
        System.out.println(summe);
    }

    static int summe_nzahlen(int n){
        
        if (n > 0) {
             n += summe_nzahlen(n-1);
        }
        return n;
    }
}*/

/*public class Ztrain_rekursiv {

    public static void main(String[] args) {
        int basis = 2, expo = 3;
        int resultat = potenzwert(basis, expo);
        System.out.println(resultat);
    }

    static int potenzwert(int basis, int expo){
        if (expo == 0) {
            return 1;
        }else{
            return basis * potenzwert(basis, expo-1);
        }
        //return basis;
    }
}*/

/*public class Ztrain_rekursiv {

    public static void main(String[] args) {
        int [] nArray = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int n = nArray.length-1;
        ausgabe(nArray, 0);
        System.out.println();
        umgekehrt(nArray, n);
    }

    static void ausgabe(int []array, int n){
        
        if (n < array.length) {
            System.out.print(array[n] + " ");
            ausgabe(array, n+1);
        }
    }

    static void umgekehrt(int array[], int n){
        
        if (n >= 0) {
            System.out.print(array[n] + " ");
        }
        umgekehrt(array, n-1);
    }
}*/

/*public class Ztrain_rekursiv {

    public static void main(String[] args) {
        int [] nArray = {1,2,3,4,5,6,7,8,9,10};
        int mArray = summe_zweidimensional_rekursiv(nArray, 0);
        System.out.println(mArray);
    }
    static int summe_zweidimensional_rekursiv(int []array, int i){
         
        int summ = 0;
        if (i < array.length) {
            summ += array[i];
            summ += summe_zweidimensional_rekursiv(array, i+1);
        }
        return summ;
    }
}*/

/*public class Ztrain_rekursiv {
    public static void main(String[] args) {
        System.out.println("Bitte, eine Zahl eingeben : ");
        Scanner sc = new Scanner(System.in);
        int zahl = sc.nextInt();
        int anzahl = ziffern_zählen(zahl);
        System.out.println("Ihre Zahl beinhaltet " + anzahl + " Ziffern");
    }
    
    static int ziffern_zählen(int zahl){
        
        int count = 0;
        if (zahl > 0) {
            int rest = zahl % 10;
            count  = ziffern_zählen(zahl / 10);
            count++;
        }
        return count;
    }
}*/

/*public class Ztrain_rekursiv {

    public static void main(String[] args) {
        System.out.println("Bitte, eine Zahl eingeben : ");
        Scanner sc = new Scanner(System.in);
        int zahl = sc.nextInt();
        int quer = quersumme(zahl);
        System.out.println(quer);
    }

    static int quersumme(int zahl){
        int rest = 0;
        if (zahl > 0) {
            rest = quersumme(zahl / 10);
            rest += (zahl % 10);
        }
        return rest;
    }
}*/

/*public class Ztrain_rekursiv {

    public static void main(String[] args) {
        System.out.print("Bitte, zwei Zahlen eingeben : ");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int produit = x_mult_y(x, y);
        System.out.println(produit);
        
    }
    static int x_mult_y(int x, int y){
        int prd = 0;
        if (x < 0 & y < 0) {
            if (-y > 0) {
            prd = x_mult_y(-x, -y-1);
             prd += -x;
            }
            return prd;
        }else if (x > 0 & y < 0) {
            if (-y > 0) {
                prd = x_mult_y(x, -y-1);
                prd += x;
            }
            return -prd;
        } else{
            if (y > 0) {
            prd = x_mult_y(x, y-1);
            prd += x;
            }
            return prd;
        }
        
    }
}*/

/*public class Ztrain_rekursiv {

    public static void main(String[] args) {
        System.out.print("Bitte, eine Zahl eingeben : ");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int result = fakultät(x);
        System.out.println(result);
    }

    static int fakultät(int zahl){
        int fak = 1;
        if (zahl > 0) {
            fak = fakultät(zahl - 1);
            fak *= zahl;
        }
        return fak;
    }
}*/
/*public class Ztrain_rekursiv {

    public static void main(String[] args) {
        print();
        System.out.println("\n");
        
        String a [] = {"BMW"};

        System.out.print("Geben Sie einen Suchbegriff aus der obigen Liste ein : ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println();

        int auto_count = count_Name(cars, name, 0);
        System.out.println(auto_count);
        
    }

    static String[] generate_Car_Brands(String [] marken, int i, String [] cars_B){
        Random random = new Random();
    
         
        if (i < cars_B.length) {
            int index = random.nextInt(marken.length);
            cars_B[i] = marken[index];
            generate_Car_Brands(marken, i + 1, cars_B);
        }
        return cars_B;
    }

    static String [] cars;

    static void print(){
        String [] auto_Marken = { "BMW", "Mercedes", "Audi", "Volkswagen", "Porsche", "Ford", "Opel", "Skoda", "Seat", "Citroen",
        "Fiat", "Peugeot", "Renault", "Nissan", "Toyota", "Honda", "Mazda", "Subaru", "Mitsubishi", "Suzuki",
        "Hyundai", "Kia", "Volvo", "Saab", "Lamborghini", "Rolls-Royce", "Bentley", "Aston Martin",
        "Ferrari", "Lancia", "Alfa Romeo", "Maserati", "Pagani", "Koenigsegg", "McLaren", "Aston Martin",
        "Lotus", "Jaguar", "Land Rover", "Mini", "Rover", "MG", "Triumph", "Spyker", "TVR", "Reliant",
        "Morgan", "Bugatti", "Lamborghini", "Rolls-Royce"};
    cars = generate_Car_Brands(auto_Marken, 0, new String[500]);
    int i = 0;
         while (i < cars.length) {
            System.out.print(cars[i] + " ");
            i++;
         }
    
    }

    static int count_Name(String [] car, String name, int i){
        
        int counter = 0;
        if (i < car.length) {

            
            counter = car[i].equals(name) ? 1 : 0;
            // Füge den inkrementierten Wert der Rekursion hinzu
            counter += count_Name(car, name, i + 1);
            
        }
        return counter;
    }
}*/
public class Ztrain_rekursiv {

    public static void main(String[] args) {
        int basis = 2, potenz = 3;
        int fin = potenzieren(basis, potenz);
        System.out.println(fin);
        int zahl = 19;
        Rückwert(zahl);
    }

    static int potenzieren(int basis, int potenz){
            int res = 0;  //1
        if (potenz != 0) {
            res = potenzieren(basis, potenz-1);
            res *= basis;
        }else{
            res = 1;
        }
        return res;
    }
    static void Rückwert(int zahl){

        if (zahl > 0) {
            System.out.print(zahl + " ");
            Rückwert(zahl-1);
        }else if (zahl < 0) {
            System.out.print(zahl + " ");
            Rückwert(zahl+1);
        }
    }
}