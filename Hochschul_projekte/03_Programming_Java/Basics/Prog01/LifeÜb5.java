package Prog01;

public class LifeÜb5 {
    public static void main(String[] args) {
        int zeil = 5;
        int zel = 11;
        boolean[][] a = new boolean[zeil][zel];
        
  
        for (int i = 0; i < zeil; i++) {
           for (int j = 0; j < zel; j++) {
              a[i][j] = j % (i + 2) == 0;
              System.out.print(a[i][j] ? "T" : "F");
  
           }
           System.out.println();
        }
  boolean[][] b= new boolean[zeil][zel];

   for(int i=0;i<zeil;i++){
      for(int j=0;j<zeil;j++){
           int nachbarn=0;

        for(int x=-1;x<zeil;x++){
      for(int y=-1;y<zeil;y++){
       int nachbarzeil=i+x;
       int nachbarzell=j+y;

       if (x!=0 && y!=0 && nachbarzeil>= 0 && nachbarzeil < zeil && nachbarzell>=0 && nachbarzell<zel) {
            if (a[nachbarzeil][nachbarzell]) {
                nachbarn++;
            }        
       }
   }
   }
         if (a[i][j]) {
      b[i][j]= nachbarn==2 || nachbarn==3;
   }else{
    b[i][j]=nachbarn==3;

    for ( i = 0; i < zeil; i++) {
           for ( j = 0; j < zel; j++) {
              b[i][j] = j % (i + 2) == 0;

              System.out.print(b[i][j] ? "T" : "F");
  
           }
           System.out.println();
        }
   }
   }
   }

        
    }
     
     
     }


/*import java.util.Scanner;

public class LifeÜb5{
    public static void main (String[] args){
	Scanner sc = new Scanner (System.in);
	int z = sc.nextInt();
	int s = sc.nextInt();
	//	int i = 1;
	boolean[][] a =new boolean [z][s];
       

	for (int i=0; i<a.length; ++i){
	    for (int k = 0; k<a[i].length; ++k){
	       	a[i][k]= k%(i+2)==0;
		//a[i][k]=true;
	    }
	    
	}
	
	for (int i=0; i<a.length; ++i){
	    for (int k=0; k<a[i].length; ++k){
		System.out.print(a[i][k]);
		
	    }
	    System.out.println();
	}
	boolean [][] b= new boolean [a.length][a[0].length];
	System.out.println();
	
	for(int i=0; i<b.length; ++i){
	    for(int k=0;k<b[i].length; ++k){
		int c=0;
		if(a[i][k]==true){
		    if(k-1>=0 && i-1>=0 && a[i-1][k-1]==true){
			 c+=1;}
		    if(i-1>=0 && a[i-1][k]== true){
			c+=1;}
		    
		    if(i-1>=0 &&k+1<b[i].length && a[i-1][k+1]==true){
			c +=1; }
		    
		    if(k-1>=0 && a[i][k-1]==true){
			c +=1;}
		    if(k+1<b[i].length && a[i][k+1]==true){
			c+=1;}
		    
		    if(i+1<b.length && k-1>=0 && a[i+1][k-1]==true){c+=1;} 
		     
		    if(i+1<b.length && a[i+1][k]==true){
			c +=1;}
		    
		    if(k+1<b[i].length && i+1<b.length && a[i+1][k+1]==true){
			c +=1;}
		    
		    
		    if(c==2 || c==3){
			b[i][k]=true;}
		    else {b[i][k]=false;}
		
		
		if(a[i][k]==false){ if(k-1>=0 && i-1>=0 && a[i-1][k-1]==true){
			 c+=1;}
		    if(i-1>=0 && a[i-1][k]== true){
			c+=1;}
		    
		    if(i-1>=0 &&k+1<b[i].length && a[i-1][k+1]==true){
			c +=1; }
		    
		    if(k-1>=0 && a[i][k-1]==true){
			c +=1;}
		    if(k+1<b[i].length && a[i][k+1]==true){
			c+=1;}
		    
		    if(i+1<b.length && k-1>=0 && a[i+1][k-1]==true){c+=1;} 
		     
		    if(i+1<b.length && a[i+1][k]==true){
			c +=1;}
		    
		    if(k+1<b[i].length && i+1<b.length && a[i+1][k+1]==true){
			c +=1;}
		    
		    if(c==3){
			b[i][k]=true;}
		   
		}
		System.out.print(b[i][k]);
		
	    }
	    System.out.print("\n");
	}
	}}}*/
