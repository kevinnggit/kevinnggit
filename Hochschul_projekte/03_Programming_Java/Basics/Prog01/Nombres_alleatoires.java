package Prog01;

import java.util.Random;

public class Nombres_alleatoires {
    public static void main(String[] args) {
        int[][] tab1 = new int[6][6];
        // Random r= new Random();
        // for(int i=0; i<tab1.length; i++){
        // for(int j=0; j<tab1[i].length; ++j){

        // tab1[i][j]= (int)Math.random()*99;
        // r.nextInt(90);

        // }
        // }
        printtab1(tab1);
        // for (int i = 0; i < tab1.length; i++) {
        // for (int j = 0; j < tab1[i].length; j++) {

        // }

        // }
        System.out.println(summtab1(tab1));

    }

    public static void printtab1(int[][] tab1) {
        System.out.println("----------------------------------------");

        for (int i = 0; i < tab1.length; i++) {
            for (int j = 0; j < tab1[i].length; j++) {
                tab1[i][j] = 10 + (int) (Math.random() * 90);
                System.out.print(tab1[i][j] + "\t");

            }

            int summe = 0;

            for (int j = 0; j < tab1[i].length; j++) {

                summe += tab1[i][j];
            }
            System.out.println(summe);

        }
        System.out.println("---------------------------------------");
    }

    public static int summtab1(int[][] tab1) {
        int summe = 0;
        for (int i = 0; i < tab1.length; i++) {
            for (int j = 0; j < tab1[i].length; j++) {
                summe += tab1[i][j];

            }

        }
        return summe;
    }

}
