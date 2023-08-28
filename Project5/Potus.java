import java.util.*;
import java.io.*;

public class Potus
{
	public static void main( String[] args )  throws Exception
	{
		BufferedReader state2PresidentsFile = new BufferedReader( new FileReader("state2Presidents.txt") );
		TreeMap<String,TreeSet<String>> state2Presidents= new TreeMap<String,TreeSet<String>>();

		BufferedReader allPresidentsFile = new BufferedReader( new FileReader("allPresidents.txt") );
		TreeSet<String> allPresidents = new TreeSet<String>();

		BufferedReader allStatesFile = new BufferedReader( new FileReader("allStates.txt") );
		TreeSet<String> allStates = new TreeSet<String>();

		while(allPresidentsFile.ready()){
			allPresidents.add(allPresidentsFile.readLine());
		}
		
		while(allStatesFile.ready()){
			allStates.add(allStatesFile.readLine());
		}




		System.out.println( "THESE STATES HAD THESE POTUS BORN IN THEM:\n");
		
		String[] Fortnite;
		String keyyy;
		while(state2PresidentsFile.ready()){
			TreeSet<String> A1 = new TreeSet<String>();
		Fortnite = state2PresidentsFile.readLine().split("\\s+");
		for(int i = 1;i<Fortnite.length;i++){
		A1.add(Fortnite[i]);
		}
		state2Presidents.put(Fortnite[0],A1);
		}
		for(String keyy : state2Presidents.keySet()){
				   System.out.print(keyy+" ");
				  TreeSet<String> but = state2Presidents.get(keyy);
				  for(String buttt: but){
					  System.out.print(buttt+" ");
					  
				  }
				   System.out.println("");
			   }
		
		
		System.out.println( "\nLIST OF POTUS AND STATE THEY WERE BORN IN:\n");
	for(String Key : allPresidents ){
			for( String rip   : state2Presidents.keySet()){
			if(state2Presidents.get(rip).contains(Key)){
				System.out.println(Key + " " + rip);
			}
			
			}
			
		}
		System.out.println( "\nTHESE POTUS BORN BEFORE STATES WERE FORMED:\n");
		TreeSet<String> NT = new TreeSet<String>();
		for( String key : state2Presidents.keySet()){
		NT.addAll(state2Presidents.get(key));
		}			
		TreeSet<String> Fin = new TreeSet<String>();
		Fin = difference(allPresidents,NT);
		
		for(String keyy : Fin){
			System.out.println(keyy);
		}
		
		
		System.out.println( "\nTHESE STATES HAD NO POTUS BORN IN THEM:\n");	
	    
		TreeSet<String> s2p = new TreeSet<String>();
		s2p.addAll(state2Presidents.keySet());
	   
		
	
		for(String keyy : difference( allStates, s2p)){
			System.out.println(keyy);
		}
	} // END MAIN

	//       - - - - - - - - - - -  H E L P E R    M E T H O D S - - - - - - - -

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
	
}	// END CLASS