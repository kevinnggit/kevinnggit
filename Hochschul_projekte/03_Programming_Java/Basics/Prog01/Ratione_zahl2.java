package Prog01;

public class Ratione_zahl2 {
        public static void main(String[] args) {
            int [] nbre1= {4,6};
            int [] nbre2= {15,24};
              int a=addmun(nbre1, nbre2);
              int b=addden(nbre1, nbre2);
              int c=multnum(nbre1, nbre2);
              int d=multden(nbre1, nbre2);
            System.out.println("vor dem kürzen \n");
            System.out.println("summe = "+a+"/"+b);
            System.out.println("Produkt = "+c+"/"+d+"\n");
           
            int []x= {a,b};
            int []y= {c,d};
            kürzen(x);
            kürzen(y);

             System.out.println("nach dem kürzen \n");
            System.out.println(x[0]+"/"+x[1]);
            System.out.println(y[0]+"/"+y[1]+"\n");
            
            

           // int kürzen(multnum(nbre1, nbre2));
           
            kürzen(nbre1);
            kürzen(nbre2);
            System.out.println(nbre1[0] +"/"+ nbre1[1]); 
            System.out.println(nbre2[0] +"/"+ nbre2[1]);
    
        }
        static void kürzen(int [] nbrRationel){
           int gt=ggt(nbrRationel[0],nbrRationel[1]);
           nbrRationel[0] /=gt;
           nbrRationel[1] /=gt;
        }
        static int ggt(int nbre1,int nbre2){
                   int r=nbre1%nbre2;
                while (nbre1%nbre2!=0&&nbre1%nbre2<nbre2) {
                    nbre1=nbre2;
                    nbre2=r;
                    r=nbre1%nbre2;
    
                }
                return nbre2;
        }
        static int addmun(int nbre1[],int nbre2[]){
           int numerateur= nbre1[0]*nbre2[1]+nbre1[1]*nbre2[0];
           
           return numerateur; 
            }
            static int addden(int nbre1[],int nbre2[]){
                 int denominateur= nbre1[1]*nbre2[1];
               return denominateur;
           }
        static int multnum(int nbre1[],int nbre2[]){
           int numerateur= nbre1[0]*nbre2[0];
           
           return numerateur;
        } 
       static int multden(int nbre1[],int nbre2[]){
            int denominateur= nbre1[1]*nbre2[1];
            return denominateur;

        }
    }
    

