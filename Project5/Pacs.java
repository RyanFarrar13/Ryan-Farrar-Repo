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
		
		while( memberToPacsFile.ready()){
			String tokens[] = memberToPacsFile.readLine().split("\\s+"); // [bgates] [BFPR] [AFCTC]
			 String member = tokens[0];
			for(int i = 1; i<tokens.length; i++){
					if(!pacToMembers.containsKey(tokens[i])){
				TreeSet<String> poope = new TreeSet<String>();
				poope.add(member);
				pacToMembers.put(tokens[i], poope);
			}
			else{
				TreeSet<String> PP = new TreeSet<String>();
				PP = pacToMembers.get(tokens[i]);
				PP.add(member);
				pacToMembers.put(tokens[i], PP);
			}
			
			
		}
		}
		pacToMembers.put("ACRONYM", new TreeSet<String>());
		//POPULATE THE TREE MAP ABOVE- inverse of the file we are given
               for(String keyy : pacToMembers.keySet()){
				   System.out.print(keyy+" ");
				  TreeSet<String> but = pacToMembers.get(keyy);
				  for(String buttt: but){
					  System.out.print(buttt+" ");
					  
				  }
				   System.out.println("");
			   }
			   
		//NOw PRINT THAT MAP (see output)
	} // END MAIN
} // CLASS
