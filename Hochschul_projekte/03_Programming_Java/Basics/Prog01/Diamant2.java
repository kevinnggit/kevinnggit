package Prog01;

public class Diamant2 {
    public static void main (String[]args){
        int n=5;
        for(int i=1; i<=n; i++){

            for(int k=1; k<=i; k++){
                System.out.print("*");
            }
           System.out.println();
        }
        for(int i2=1; i2<=n; i2++){
             for(int k2=i2; k2<n; k2++){
                 System.out.print("*");
             }
             System.out.println();
        }
    }
}
