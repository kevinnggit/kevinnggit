package srcb;

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
                //System.out.print(table[i][j] == 0 ? "T" : "F");
                switch (table[i][j]) {
                    case 0:
                    System.out.print(" \t");
                    break;
                        
                    case 1:
                    System.out.print(".\t");
                    break;
                    
                    case 2:
                    System.out.print("o \t");
                    break;
                    
                    case 3:
                    System.out.print("O \t");
                    break;
                
                    default:
                    System.out.print("* \t");
                    break;
                }
            }
            System.out.println();
        }
    }
}