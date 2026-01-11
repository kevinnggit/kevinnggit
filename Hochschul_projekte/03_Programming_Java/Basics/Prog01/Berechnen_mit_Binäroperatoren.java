package Prog01;
import java.util.Scanner;

public class Berechnen_mit_Binäroperatoren {
    public static void main(String[]args){
       Scanner sc= new Scanner(System.in);
       System.out.print("Geben Sie Zahl1 ein: ");
       int zahl1= sc.nextInt();
       System.out.print("Geben Sie Zahl2 ein: ");
        int zahl2= sc.nextInt(); 
        System.out.println("Die Differenz von zahl1 und zahl2 ist: "+ difference(zahl1, zahl2));    
    }
    static int difference(int m, int n){
     int diff = m + ~n +1;
     return diff;
    }
}
