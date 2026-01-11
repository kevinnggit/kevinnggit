package srcb;

public class Life {
    
    Stone [][]field;
    
    public Life(int zeil, int spalt) {
        this.field = new Stone[zeil][spalt];
        for (int i = 0; i < zeil; i++) {
            for (int j = 0; j < spalt; j++) {
                this.field[i][j] = new Stone(Math.random() > 0.5 ? 1 : 0, i, j);
            }
        }
        

    }

    public void run(){
        while (true){
            for (int i = 0; i < this.field.length; i++) {
                for (int j = 0; j < this.field[0].length; j++) {
                    this.field[i][j].computeNext(this.field);
                    
                }

            }
            for (int i = 0; i < this.field.length; i++) {
                for (int j = 0; j < this.field[0].length; j++) {
                    this.field[i][j].commit();
                    
                }

            }

            this.render();
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                // TODO: handle exception
            }
           
        }
    } 
    
    public void render(){
        for (int i = 0; i < this.field.length; i++){
            for (int j = 0; j < this.field[0].length; j++){
                this.field[i][j].print();
            }
            System.out.println();
        }
    }

}