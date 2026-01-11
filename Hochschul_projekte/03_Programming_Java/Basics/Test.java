public class Test{
    public static void main(String [] args){

         int a = 0110;
         convert(a);
    }

    

static void convert(int nbre) {
    int dez =   1;
    while (nbre >   0) {
        int bit = nbre %   10; // Überprüfen Sie das am weitesten rechts stehende Bit
        if (bit ==   1) {
            dez +=   1; // Addieren Sie den Wert des Bits zu dez
        }
        nbre /=   10; // Verschieben Sie die Bits nach links
        if (nbre >   0) {
            dez *=   2; // Verdoppeln Sie dez, wenn es noch Bits gibt
        }
    }
    System.out.println("Die Dezimalzahl ist: " + dez);
}
}

