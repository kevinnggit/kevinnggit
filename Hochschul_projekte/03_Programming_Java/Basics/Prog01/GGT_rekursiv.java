package Prog01;
public class GGT_rekursiv {
    
     
    public static void main(String[] args) {
        int a=128, b=34;
        int resultat=ggT(a, b);
       System.out.println(resultat);
    }

    public static int ggT(int a,int b){
        if(b==0) {
            return a;
        } else {
            return ggT(b,a%b);
        }
    }
}