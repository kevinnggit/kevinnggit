package Prog01;
/*public class Rekursion {
    public static void doit(int i){
       if (i>0) {
        
        doit(i-1);
        System.out.println(i);
        doit(i-1);
       }
    }
    public static void main(String[] args) {
        doit(10);
    }
}*/

/*public class Rekursion{
public static int m(int n){
if (n>100)
return n-10;
else
return m(m(n+11));
}
public static void main(String [] args){
for(int i=0; i<200; ++i){
System.out.println("carthy("+i+")="+m(i));
}
}
}*/

public class Rekursion {

    public static int f(int n){
         if (n==1){
            return 1;
         }else if (n % 2 ==0){
            return f(n/2);
         }else{
            return f(n*3+1);
            }
         
         }
         public static void main(String[] args) {
            System.out.println(f(21));
         }
    }
