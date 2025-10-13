import java.io.*;
import java.util.*;

public class TreeSetOps
{
	public static void main( String args[] ) throws Exception
	{
		BufferedReader infile1 = new BufferedReader( new FileReader( args[0] ) );
		BufferedReader infile2 = new BufferedReader( new FileReader( args[1] ) );

		TreeSet<String> set1 = loadSet( infile1 );
		TreeSet<String> set2 = loadSet( infile2 );
		printSet( "set1: ",set1 );
		printSet( "set2: ",set2 );

		TreeSet<String> union = union( set1, set2 );
		printSet( "\nunion: ", union );

		TreeSet<String> intersection = intersection( set1, set2 );
		printSet( "\nintersection: ",intersection );

		TreeSet<String> difference = difference( set1, set2 );
		printSet( "\ndifference: ",difference );

		TreeSet<String> xor = xor( set1, set2 );
		printSet("\nxor: ", xor );

		System.out.println( "\nSets Echoed after operations.");

		printSet( "set1: ", set1 );
		printSet( "set2: ", set2 );

	}// END MAIN

	// Y O U    W R I T E   T H I S     M E T H O D

	static TreeSet<String> loadSet( BufferedReader infile ) throws Exception
	{
		TreeSet<String> TS = new TreeSet<String>();
		while( infile.ready()){
			TS.add(infile.readLine());
		}
		return TS;
	}

	// Y O U    W R I T E   T H I S     M E T H O D
	//BufferedReader infile1 = new BufferedReader( new FileReader( args[0] ) );
		//BufferedReader infile2 = new BufferedReader( new FileReader( args[1] ) );

		//TreeSet<String> set1 = loadSet( infile1 );
		//TreeSet<String> set2 = loadSet( infile2 );
	static void printSet( String caption, TreeSet<String> set )
	{
		System.out.println();
      System.out.print(caption);
	  for(String word : set){
		  System.out.print(" " + word);
	  }
	}

	// Y O U    W R I T E   T H I S     M E T H O D
	static TreeSet<String> union( TreeSet<String> set1, TreeSet<String> set2 )
	{
		TreeSet<String> NS = new TreeSet<String>();
		NS.addAll( set1);
		NS.addAll(set2);
		// YOU ARE NOT ALLOWED TO MODIFY this set. MAKE A COPY OF this set
		// NO LOOPS ALLOWED

		// create a deep copy of this TreeSet
		// apply the built in method(s) to modify it to be the union or intersect or diff or xor
		// return the modified version of the this set that has been transformed into a union or diff etc
		// NO LOOP ALLOWED. should really be only about 3 lines or so of code

		return NS;  // JUST TO MAKE IT COMPILE. REPLACE WITH YOUR CODE

	}

	static TreeSet<String> intersection( TreeSet<String> set1, TreeSet<String> set2 )
	{
		TreeSet<String> NS1 = new TreeSet<String>();
		NS1.addAll( set1);
		NS1.addAll(set2);
		NS1.retainAll(set1);
		NS1.retainAll(set2);
		// YOU ARE NOT ALLOWED TO MODIFY this set. MAKE A COPY OF this set
		// NO LOOPS ALLOWED

		// create a deep copy of this TreeSet
		// apply the built in method(s) to modify it to be the union or intersect or diff or xor
		// return the modified version of the this set that has been transformed into a union or diff etc
		// NO LOOP ALLOWED. should really be only about 3 lines or so of code

		return NS1;  // JUST TO MAKE IT COMPILE. REPLACE WITH YOUR CODE
	}

	static TreeSet<String> difference( TreeSet<String> set1, TreeSet<String> set2 )
	{
		TreeSet<String> NS2 = new TreeSet<String>();
	
		NS2.addAll( set1);
		
		NS2.removeAll(set2);
		// YOU ARE NOT ALLOWED TO MODIFY this set. MAKE A COPY OF this set
		// NO LOOPS ALLOWED

		// create a deep copy of this TreeSet
		// apply the built in method(s) to modify it to be the union or intersect or diff or xor
		// return the modified version of the this set that has been transformed into a union or diff etc
		// NO LOOP ALLOWED. should really be only about 3 lines or so of code

		return NS2;  // JUST TO MAKE IT COMPILE. REPLACE WITH YOUR CODE
	}

	static TreeSet<String> xor( TreeSet<String> set1, TreeSet<String> set2 )
	{
		return difference(union(set1, set2), intersection(set1, set2));  // JUST TO MAKE IT COMPILE. REPLACE WITH YOUR CODE
	}


} // END CLASS