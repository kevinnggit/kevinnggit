package Prog01;
public class SortZeitMess {
    public static void main(String[] args) {
        int size = 10000;

        double [] tab1 = new double [size];
        
       // print_Arrays(tab1);
    long start = System.currentTimeMillis();
       selection_sort(tab1);
    long end = System.currentTimeMillis();
    System.out.println(end-start);
    long start1 = System.currentTimeMillis();
    insertion_sort(tab1);
    long end1 = System.currentTimeMillis();
    System.out.println(end1-start1);
    long start2 = System.currentTimeMillis();
    bubble_sort_opt(tab1);
    long end2 = System.currentTimeMillis();
    System.out.println(end2-start2);



    }


    static void print_Arrays(double[] tab){
        
        for (int i = 0; i < tab.length; i++) {
            tab [i] = Math.random()*1000;
            System.out.println(tab[i]);
        }
    }


    static void selection_sort(double [] field) {
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

        static void insertion_sort(double[] field) {
            for(int i1 = 1;i1 < field.length;++i1) {
            double val = field[i1];
            int i2 = i1;
            while (i2 > 0 && field[i2 - 1] > val) {
            field[i2] = field[i2 - 1];
            --i2;
            }
            field[i2] = val;
            }
            }

            static void bubble_sort_opt(double [] field) {
                for(int i1 = 1; i1 < field.length; ++i1) {
                boolean bAtLeastOneSwap = false;
                for(int i2 = 0; i2 < field.length-i1;++i2) {
                if (field[i2] > field[i2 + 1]) {
                swap(field, i2, i2+1);
                bAtLeastOneSwap = true;
                }
                }
                if (!bAtLeastOneSwap)
                return;
                }
                }
}
