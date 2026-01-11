public class Charakter {
    //attributes

    String name;
    int old;
    double tail;
    boolean isAlive;

    //constructor
    public Charakter (String name, int old, double tail, boolean isAlive) {

        this.name = name;
        this.old = old;
        this.tail = tail;
        this.isAlive = isAlive;

    } 
    //methods

    public void  identify_typ() {
       if (this.isAlive == true && this.old < 18) {
        System.out.println(this.name + " ist minderjährig");
       }else if (this.isAlive = true && this.old >= 18) {
        System.out.println(this.name + " ist großjährig");
       }
    }
}
