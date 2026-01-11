package srcb;

public class Stone {

    private int age;
    private int x,y,nextAge;
    public Stone(int age, int x, int y){
        this.age = age;
        this.x=x;
        this.y=y;
    }

    public void print() {

        switch (age) {
            case 0:
                System.out.print(" ");
                break;
            case 1:
                System.out.print(".");
                break;
            case 2:
                System.out.print("o");
                break;
            case 3:
                System.out.print("O");
                break;

            default:
                System.out.print("*");
                break;
        }
    }

    public boolean isAlive() {
           return age > 0;
    }

    public void computeNext(Stone[][] field) {
        
        this.nextAge=this.age;
        int neighbours=countNeighbour(field);
        if (this.isAlive() && (neighbours == 2 || neighbours == 3)) {
            this.nextAge++;
        } else if (!isAlive() && neighbours == 3) {
            this.nextAge++;
        } 
         else {
              this.nextAge = 0;
        }
    }

    public void commit() {
        this.age = this.nextAge;
    }

    

    public int countNeighbour(Stone[][] a) {
        int zaehler = 0;
        int zeilen = a.length;
        int spalten = a[0].length;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nachbarZeile = (x + i + zeilen) % zeilen;
                int nachbarSpalte = (y + j + spalten) % spalten;

                if (i == 0 && j == 0) {
                    continue;
                }

                if (a[nachbarZeile][nachbarSpalte].isAlive()) {
                    zaehler++;
                }
            }
        }

        if (a[x][y].isAlive()) {
            zaehler--;
        }
        return zaehler;
    }
}