package Prog01;
import java.util.Scanner;

public class Schaltjahr {
    public  static void main (String[]args){
    Scanner sc = new Scanner(System.in);

     System.out.println("Geben Sie ein Jahr");
    int Jahr= sc.nextInt();
     do{
        System.out.println("Geben Sie ein 4-stelliges Jahr");
    Jahr= sc.nextInt();
      } while(Jahr<999||Jahr>9999);
       
    if(Jahr%400==0){
    System.out.println("Das ist ein Schaltjahr");
    }else{
         System.out.println("Das ist kein Shaltjahr");
    
    
      }
    }
}
