package Prog01;


public class Wurzel_in_halbierung {
    public static void main(String[] args) {
        double zahl =16;
        double res= berechne_w(zahl);
        System.out.println(res);
    }
    public static double berechne_w(double eingabe){
        double a=eingabe;
        double b=1;
        if((a-b)>0.0001) {
            a=(a+b)/2;
            b=eingabe/a;
        }
        return b;
         }
}
