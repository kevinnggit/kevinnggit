public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Charakter charakter1 = new Charakter("john",17,1.77, true);
        Charakter charakter2 = new Charakter("alice",48,1.65,true);
        Charakter charakter3 = new Charakter("jane",25,1.80,false);
        
        Charakter [] list = {charakter1, charakter2, charakter3};
        int counter = 0;
        for (int i = 0; i < list.length; i++) {
            
            list[i].identify_typ();
            if (list[i].old >= 18) {

                counter++; 
            }
           System.out.println(counter + "Charakters sind voljährig");
        }
    }
}
