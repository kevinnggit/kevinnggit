package Prog01;
import java.util.Arrays;

public class Call_By {
    public static void main(String[] args) {
       int[] a = {10,20,30}; 
        int[] b = {1,2,3,4,5};

                                    // call by value
        swap(a[n],b[n]);               //
          System.out.println(a[n]); //20
          System.out.println(b[m]); //2
          System.out.println(m);    //1
          System.out.println(n);    //1
          swap1(a, n, b, m);
          System.out.println(Arrays.toString(a));
          System.out.println(Arrays.toString(b));
          
    }
        
       static int n = 0, m = 0; 
    
    static void swap(int x, int y) { 
        
         ++n; 
        int tmp =x; 
         x = y; 
        y = tmp; 
         ++m; 
       // System.out.println(n);
       // System.out.println(m);
    }
    static void swap1(int[] a,int x ,int[] b,int y) {
        int tmp = a[x];
        a[x] = b[y];
        b[y] = tmp;
    }
}
