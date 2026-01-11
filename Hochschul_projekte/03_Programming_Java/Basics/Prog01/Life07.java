package Prog01;
import java.util.Random;

public class Life07 {
    public static void main(String[] args) {
        boolean [][] zufall= new boolean [5][5];
        /*Random random = new Random();

        for (int i = 0; i < zufall.length; i++) {
            for (int j = 0; j < zufall[i].length; j++) {
                zufall[i][j] = random.nextBoolean();
                System.out.print(zufall[i][j] + "\t");
            }
            System.out.println();
        }*/

        for (int i = 0; i < zufall.length; i++) {
            for (int j = 0; j < zufall[i].length; j++) {
                zufall[i][j] = Math.random() < 0.5;
                System.out.print(zufall[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
