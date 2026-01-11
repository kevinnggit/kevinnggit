package Prog01;
public class Life1001 {
    
    int zeile;
    int spalte;
    int [][] table;

    public Life1001(int zeile, int spalte){

        this.zeile=zeile;
        this.spalte=spalte;
        this.table=new int[zeile][spalte];

    }

    public void ausfüllen (){

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = j % (i + 2);
            }
        }
    }

    public void ausgabe () {

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j] == 0 ? "T" : "F");
            }
            System.out.println();
        }
    }
}
