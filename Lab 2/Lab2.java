//Ryan Farrar 

import java.util.Scanner;
public class Lab2   
{                             
      public static void main (String [] args)
  {
      Scanner inScan = new Scanner(System.in);
      System.out.print(" Enter an integer: ");
      int UEI = inScan.nextInt(); //UEI = User Entered Int
      System.out.println(UEI);
      
      int LD; // Last Digit
      LD = UEI % 10;
      System.out.println("The last Digit is " + LD);
      
      int SLD;  // Second Last Digit
      double SLDPA, SLDPB, SLDPC,SLDPD; // Second Last Digit Part A,B,C,D
      SLDPA = UEI % 100;
      SLDPB = SLDPA/10;
      SLD = (int)SLDPB;
      System.out.println("The Second to last digit is " + SLD);
      
      System.out.println(" Enter a Double: ");
      double UED = inScan.nextDouble();// User Entered Double
      System.out.println(UED);
      
      double UEDPA;//UserEntered Double Part A
      UEDPA = (int)(UED * 1000 + 0.5) / 1000.0;
      System.out.println("the input rounded to the 3rd digit is " + UEDPA);
      //fin

      }
}
