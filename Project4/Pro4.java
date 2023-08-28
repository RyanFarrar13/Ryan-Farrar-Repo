/*
	PrintSubSets.java
*/
import java.io.*;
import java.util.Scanner;

//2 to the 16 is equal to 65,536
//all sets read in have length of 16
public class Pro4
{
	public static void main( String[] args ) throws IOException
	{	
	   int UpperBound = 65536;
		int [] set = new int[16];
		File file = new File( args[0]);
		Scanner input = new Scanner(file);
		for(int j = 0; j<16; j++){
			set[j]=input.nextInt();
		}
		int Target = input.nextInt();
		//System.out.println("Target: " + Target); Checkpoint

		for ( int i=0 ; i<UpperBound ; ++i )
		{	String bitmap = toBitString( i, set.length );
			int Total=0;
			StringBuilder StB = new StringBuilder();
			for ( int bindx=0 ; bindx<set.length ; ++bindx )
				if ( bitmap.charAt(bindx)=='1' ){
					Total = Total + set[bindx];
					StB.append(set[bindx]);
					StB.append(" ");
				}
				
				if(Total==Target){
					System.out.println(StB.toString());
				}
		}
		
	} // END MAIN

	// i.e number 31 converted to a width of 5 bits = "11111"
	//     nuumber 7 converted to a width of 5 bits = "00111"
	static String toBitString( int number, int width )
	{
		String bitstring = "";
		while (number > 0)
		{	if (number % 2 == 0)
				bitstring = "0" + bitstring;
			else
				bitstring = "1" + bitstring;
			number /= 2 ;
		}
		while ( bitstring.length() < width )
				bitstring = "0" + bitstring;
		return bitstring;
	}
} // END CLASS