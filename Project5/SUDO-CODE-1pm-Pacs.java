import java.io.*;
import java.util.*;

public class Pacs
{	public static void main( String args[] ) throws Exception
	{	BufferedReader memberToPacsFile = new BufferedReader(new FileReader( "member2Pacs.txt"));
		BufferedReader AllPacsFile= new BufferedReader(new FileReader("allPacs.txt"));
		TreeSet<String> allPacs= new TreeSet<String>();
		while( AllPacsFile.ready())
			allPacs.add(AllPacsFile.readLine());

		TreeMap<String, TreeSet<String>> pacToMembers = new TreeMap<String, TreeSet<String>>(); // THE MAP THAT GETS PRINTED
		// POPULATE THE TREE MAP ABOVE - it is the INVERSE of the file we are given
		while( memberToPacsFile.ready())
		{
			String tokens[] = memberToPacsFile.readLine().split("\\s+"); // [bgates] [BFPR] [AFCTC]
			member = tokens[0];

			for each PAC in the rest of the tokens array 1 .. .length-1
				if that PAC is NOT found as a key in the map  use .containsKey()
					define TreeSet member and add the above member to it
					.put( PAC,  TreeSet );
				else // this PAC is alread in the keys of the map
					pull out the set of members already stored with this PAC key
					TreeSet members = pacToMembers.get( PAC );
					then add in this new member
					add to that set of member the above member tokens[0]
					.put( PAC, members   );
		}

		NOw PRINT THAT MAP (see output)

		for each PAC in the set of all PACS
			print PAC + " "
			TreeSet members = pacToMembers.get( PAC );
			enhanced for loop to print out all the members from this sest
			println()
		end for
	} // END MAIN
} // CLASS
