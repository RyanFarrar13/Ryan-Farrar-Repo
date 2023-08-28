
import java.util.Scanner;
import java.util.*;
public class Lab3
{ 
    
static void RollDice (int RN, Random y){
    int D1, D2 = 0;
    int C2=0, C3=0, C4=0, C5=0, C6=0,C7=0,C8=0,C9=0,C10=0,C11=0,C12=0;
    int Z = 0;
    while ( RN > 0 ){
      D1 = y.nextInt(6);
      D1++;
      D2 = y.nextInt(6);
      D2++;
      int T = D1 + D2;
    
      switch(T)
      {
        case 2:
              C2++;
              break;
        case 3:
            C3++;
            break;
        case 4:
            C4++;
            break;
        case 5:
            C5++;
            break;
        case 6:
            C6++;
            break;
        case 7:
            C7++;
            break;
        case 8:
            C8++;
            break;
        case 9:
            C9++;
            break;
        case 10:
            C10++;
            break;
        case 11:
            C11++;
            break;
        case 12:
            C12++;
            break;  
      }       
      RN--;
      Z++;
    }  
    double Cc2 = (double)C2/(Z);
    double Cc3 = (double)C3/(Z);
    double Cc4 = (double)C4/(Z);
    double Cc5 = (double)C5/(Z);
    double Cc6 = (double)C6/(Z);
    double Cc7 = (double)C7/(Z);
    double Cc8 = (double)C8/(Z);
    double Cc9 = (double)C9/(Z);
    double Cc10 =(double)C10/(Z);
    double Cc11 = (double)C11/(Z);
    double Cc12 = (double)C12/(Z);
    
    
    System.out.println("the dice were roled" + Z + " times, ");
    System.out.println("The Value 2 was ruled " + C2 + "times, the fraction of how many time it was roled is " + Cc2);
    System.out.println("The Value 3 was ruled " + C3 + "times, the fraction of how many time it was roled is " + Cc3 );
    System.out.println("The Value 4 was ruled " + C4 + "times, the fraction of how many time it was roled is " + Cc4 );
    System.out.println("The Value 5 was ruled " + C5 + "times, the fraction of how many time it was roled is " + Cc5);
    System.out.println("The Value 6 was ruled " + C6 + "times, the fraction of how many time it was roled is " + Cc6 );
    System.out.println("The Value 7 was ruled " + C7 + "times, the fraction of how many time it was roled is " + Cc7 );
    System.out.println("The Value 8 was ruled " + C8 + "times, the fraction of how many time it was roled is " + Cc8 );
    System.out.println("The Value 9 was ruled " + C9 + "times, the fraction of how many time it was roled is " + Cc9 );
    System.out.println("The Value 10 was ruled " + C10 + "times, the fraction of how many time it was roled is " + Cc10 );
    System.out.println("The Value 11 was ruled " + C11 + "times, the fraction of how many time it was roled is " + Cc11);
    System.out.println("The Value 12 was ruled " + C12 + "times, the fraction of how many time it was roled is " + Cc12 );
        }
        
  
               
public static void main (String [] args){  
    int f = 0;
 while(f==0){
    System.out.println("How Many times would you like to roll the dice? Enter negative number to end program.");
    Scanner theInput = new Scanner(System.in);
  int RN = theInput.nextInt();
  if(RN<=0){
      System.exit(0);
      
  }
    Random RAN = new Random();
    RollDice(RN, RAN); 
    
    
    
    
    
   }       
}
    }
   




    

