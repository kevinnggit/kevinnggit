package Prog01;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
public class Aa {
    /*public static void main(String[] args) {
        int X = 13;
        doit(X);
        System.out.println(X);
    }

    static void doit(int i){
        i = 43;
        System.out.println(i);
    }*/
    /*static int [] a = {10,20,30};
    static int [] b = {1,2,3,4,5};
    static int n = 0;
    static int m = 0;
    public static void main(String[] args) {
        swap(a[n], b[m]);
        
        System.out.println(m + " " + n + " " + a[n] + " " + b[m]);
        print(a);
        print(b);
    }

    static void swap (int x, int y){
        ++n;
        int tmp = x;
        x = y;
        y = tmp;
        ++m;
    }

    static void print (int []temp){
        for(int i : temp)
        System.out.print(i + " ");
        System.out.println();
    }*/

    /*public static void a(int i)
    {
        b(i+1);
        System.out.println("a" + i);
    }
    public static  void b(int i)
    {
        System.out.println("b" + i);
        a(i+1);
    }
    public static void main(String[] args)
    {
        int i = 0;
        
            a(i);
        
    }*/
    
/*public static void main(String[] args)
    {
        int i = 10;
        int [] a = {3,4};
        teilbare_z(i, a);
    }
static void teilbare_z(int o, int [] array)
    {
        ArrayList<Integer> b = new ArrayList<>();
        
        for (int j = 0; j < array.length; j++)
        {
            int i = o;
          while (i > 0)
          {
              b.add(pruefe_Teilbarkeit(i, array[j]));
              i--;
          }
        }

        for(int l : b)
        {
            if (l != 0) {
                System.out.print(l + " ");
            }
        }
    }

    static int pruefe_Teilbarkeit(int i, int x)
    {
        int r = i % x;
        if (r == 0) {
            return i;
        }else
        {
            return 0;
        }
        
    }*/

    /*public static void main(String[] args)
    {
        int i = 10;
        int [] a = {3,4};
        teilbare_z(i, a);
    }
static void teilbare_z(int i, int [] array)
    {
        int k = i * array.length;
        int[] b = new int[k];
        
        
        //for (int j = 0; j < array.length; j++)
        //{
            int a = 0;
        while (i > 0)
          {
            
            for (int j = 0; j < array.length; j++)
        {
            b[(k-1)-a] = pruefe_Teilbarkeit(i, array[j]);
            if (b[(k-1)-a] != 0) {
                a++;
            }
            i--;  
        }
        }

        for(int l : b)
        {
            if (l != 0) {
                System.out.print(l + " ");
            }
        }
    }

    static int pruefe_Teilbarkeit(int i, int x)
    {
        int r = i % x;
        if (r == 0) {
            return i;
        }else
        {
            return 0;
        }
        
    }*/

    /*public static void main(String[] args) {
        char [] s = {'D','s',' ','A','C',' ','D'};
        char search = ' ';
        int [] res = positions(s, search);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    static int [] positions (char []s, char search){

        
        int n = compte(s, search);
        int array [] = new int [n];
        int a = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == search) {
                array[a] = i;
                a++;
            
        }
        
    }
    return array;
  }

  static int compte (char []s, char search){

    int counter = 0;
           for (int i = 0; i < s.length; i++) {
            if (s[i] == search) {
                counter++;
            }
           }
           return counter;
  }*/

  /*public static void main(String[] args) {
    char [] s = {'D','s',' ','A','C',' ','D'};
        char search = ' ';
        System.out.println(count(s, search));
  }

  static int count (char []s, char search){
           int index = 0;
           int res = count1(s, search, index);
           return res;
  }

  static int count1 (char []s, char search, int index){
   
    if (index >= s.length) {
        return 0;
    }
    
    if (s[index] == search) {
        return 1 + count1(s, search, index + 1);
    } else {
        return count1(s, search, index + 1);
    }
  }*/

  public static void main(String[] args) {
    int size = 10;
    //int [] arr = fill(size);
    int [] arr = {3,5,46,37,8,3};
    print(arr);
  }

  static int [] fill(int size){
    int [] temp = new int [size];
    for (int i = 0; i < temp.length; i++) {
        temp [i] = ThreadLocalRandom.current().nextInt(-100,100);
    }
    return temp;
  }
  static void print(int [] temp){
    int i = 0;
    while(i < temp.length){
    System.out.print(++temp[i] + " ");
    ++i;
    }
    System.out.println("\n");
  }
}


