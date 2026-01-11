package Prog01;

public class Diamant_fn {
    public static void main (String[]args){
        int n=5;
        for(int i=1; i<=n; i++){
             for(int j=i; j<n; j++){
                   System.out.print("^");
             }
            for(int k=1; k<(i*2); k++){
                System.out.print("*");
            }
           System.out.println();
        }
        for(int i2=1; i2<=n; i2++){
            for(int j2=1; j2<=i2; j2++){
               System.out.print("^");
            }                                            //(n*2)-((n+1)-n)
             for(int k2=i2; k2<n; k2++){
                 System.out.print("*");
             }
             for(int k3=i2; k3<n-1; k3++){
                 System.out.print("*");
             }
             System.out.println();
        }
    }
}
