package Java.jav;
 
public class Sortierverfahren {
    
    public static void main(String[]args){
       
    
    
    double [] field = new double[10];

       
     for (int i = 0; i < field.length; i++) {
        field [i]=(Math.random()*9000);

        System.out.print(field[i] + "\t");
     }    
     System.out.println();
     long start= System.currentTimeMillis();
            sort(field);
     long end= System.currentTimeMillis();
     System.out.println(6);
     System.out.println(end-start);       
     for (int i = 0; i < field.length; i++) {
       // field [i]= (int) (Math.random()*90);

        System.out.print(field[i] + "\t");
     }
    }
    static void sort(double [] field) {
        for(int i1 = 0;i1 < field.length - 1;++i1) {
        int min = i1;
        for(int i2 = i1 + 1;i2 < field.length;++i2) {
        if (field[i2] < field[min])
        min = i2;
        }
        swap(field, min, i1);
        }
        }
        static void swap(double[] field,int iPos1,int iPos2) {
        double tmp = field[iPos1];
        field[iPos1] = field[iPos2];
        field[iPos2] = tmp;
        }
}
