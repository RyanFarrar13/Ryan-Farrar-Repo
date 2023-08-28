/*
	PrintSubSets.java
*/
import java.io.*;

public class PrintSubSets
{
	public static void main( String[] args )
	{	int[] set = { 2,5,7,8,3 }; // 5 elements produces 2^5 subsets ( 32 subsets )
		System.out.print( "original set: { " );
		for ( int i=0 ; i<set.length ; ++i )
			System.out.print( set[i] + " " );
		System.out.println("}" );

		for ( int i=0 ; i<32 ; ++i )
		{	String bitmap = toBitString( i, set.length );
			System.out.format("bitmap %s  { ", bitmap );
			for ( int bindx=0 ; bindx<set.length ; ++bindx )
				if ( bitmap.charAt(bindx)=='1' )
					System.out.print( set[bindx] + " " );
				else
					System.out.print( "  " );
			System.out.println( "}");
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