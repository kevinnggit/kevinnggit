package srcb;

//import java.util.scanner;

public class Sortierverfahren {
    
      private double []table;

      public Sortierverfahren(double []table) {
        this.table= new double[10];
        
      }

      public void  bubble(double[]table) {
      double temp;
      for (int i = 0; i < table.length-1; i++) {
        for (int j=0; j < table.length-(1+i); j++) {
            if (table[j] > table [j+1]) {
             temp = table[j+1];
              table[j+1] = table[j];
              table[j] = temp;
            }
           

      }
    }
}


public void printtable(double[] tab){
    for (int i=0; i<tab.length; i++){
    System.out.print(tab);
    }
}
}

