package Prog01;
public class GGT {
    public static void main (String[]args){
        int a=40, b=24;
       //int C=a%b;
        while (a%b !=0 && a%b<b) {
            int C=a%b;
            
             a=b;   //a prend la valeur de b 
             b=C;   //et b celle de c afin de continuer le calcul
           // C=a%b;
           
        }
         int ggt=b;
            System.out.println(ggt);
        int d=a, e=b, f=ggt;
        int kgV= d*e/f;
        System.out.println(kgV);


    }
    
}
