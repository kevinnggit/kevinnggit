package Prog01;
public class Naturliche_zahlen {
    public static void main (String[]args){
    int a=1;
    int count =0;
    int summe=0;
    while(a<=100){
                    //a
    System.out.print(summe + "\t");
      
         summe+=a;
        a++; 
        count++;
         if (count==10){
        System.out.print("\n");
        count =0;
    }
        
    }
System.out.println(summe);
}
}
