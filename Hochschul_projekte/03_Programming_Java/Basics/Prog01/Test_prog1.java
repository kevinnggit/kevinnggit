package Prog01;
public class Test_prog1 {
    public static void print_Rechteck(int iBreite){
       System.out.print("+");
       for(int i=0;i<iBreite-2;++i){
         System.out.print("-");
       }
       System.out.println("+");
    

for(int j=0;j<4;++j){
    System.out.print("|");
    for(int i=0;i<iBreite-2;++i){
      System.out.print(" ");
    }
    System.out.println("|");
}
 System.out.print("+");
       for(int i=0;i<iBreite-2;++i){
         System.out.print("-");
       }
       System.out.println("+");
    }
    public static void main (String [] args){
         print_Rechteck(10);
         print_Rechteck(8);
         print_Rechteck(5);
    }
}



