// CMPINF 0401 Fall 2022
// Lab 12
// You must modify this file so that it works as described in the lab handout.
// For details of where the modifications need to be made see the comments and
// the lab text.
// Your output should match that shown in lab12out.txt

// Note: As written this program will NOT COMPILE due to an uncaught IOException.
// Once you handle that exception (and the others required) it should compile
// and run.

import java.util.*;
import java.io.*;
public class lab12
{
	public static void main(String [] args)
	{
		Scanner inScan, fScan = null;
		int [] A = new int[5];
		inScan = new Scanner(System.in);
		
		// If file fName does not exist this could cause an exception
		// Add a loop to handle this and make the user re-enter the
		// file name
		int x = 0;
		while(x==0){
			try{
		System.out.println("Please enter the file to read from: ");
		String fName = inScan.nextLine();
		fScan = new Scanner(new File(fName));
		x++;
			}
			catch(IOException e){
				System.out.println("Please enter a valid File Name.");
				
			}
			
		}
		String nextItem;
		int nextInt = 0;
		int i = 0;
		
		while (fScan.hasNextLine())
		{
			try{
			nextItem = fScan.nextLine();
			nextInt = Integer.parseInt(nextItem);
			}
			catch(NumberFormatException a){
				System.out.println(" Text from file may not be just Int.");
				i--;
			}
			// If the nextItem is not an int this could cause an exception
			// Include an exception handler to simply ignore a number that
			// is not a valid int
			
			
			// If i is >= A.length this will cause an exception.  Add an
			// exception handler to resize the array and add the new item
			// to it that the number can actually be stored.
			try{
			A[i] = nextInt;
			i++;
			}
			catch( ArrayIndexOutOfBoundsException p){
				int ALen = A.length*2;
				int[] NewArray = new int[ALen];
			    int ii =0;
				while(ii<A.length){
					NewArray[ii] = A[ii];
					
					ii++;
				}
					
				A = NewArray;
				A[i] = nextInt;
				i++;
			}
		}

		System.out.println("Here are your " + i + " items:");
		for (int j = 0; j < i; j++)
		{
			System.out.println(A[j] + " ");
		}
	}
}
