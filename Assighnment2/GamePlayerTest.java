// CS 0401 Fall 2022
// Program to test your GamePlayer class.
// This program should run with your GamePlayer class and should produce
// the same output as shown in GamePlayer-out.txt.

// Note that this program will NOT RUN correctly until you have implemented
// GamePlayer. However, you can see how the output should look in File
// GPT-out.txt.

// See the comments below for the specific functionality required in the
// GamePlayer class.

import java.util.*;
import java.io.*;

public class GamePlayerTest
{
	// Note that this method throws IOException.  This is necesary since it is
	// using files.  See also FileTest.java.
	public static void main(String [] args) throws IOException
	{
		// Initially assume that none of the files below exist.
		System.out.println("Testing GamePlayer class");
		
		GamePlayer P = new GamePlayer("Mortimer");  // Create a new GamePlayer.  In
						// this constructor, the remaining instance variables for
						// the player are all initialized to 0
		System.out.println("Player Info:");
		System.out.println(P.toString());  // Show info with toString() method
						// See the output file for the data and formatting. The
						// Ratio value is the total number of edits for all rounds
						// that were successful divided by the optimal number of
						// edits needed.  Note that in this initial output there is
						// a special case (output as 1) since the optimal number of 
						// edits is 0.  Without this special case we would have an
						// the value NaN (not a number) for the output.
		System.out.println();
		
		// The success() method takes two arguments -- the number of tries and
		// the optimal number of tries.  These get added to the respective totals
		// for the user.  In the examples below, player P first succeeds in 5 tries
		// where the optimal was 4.  In the second example, player P succeeds in 6
		// tries, which is the optimal number.  The toString() method then shows the
		// updated statistics.  Clearly, in your main program, you would call this
		// method only after a GamePlayer wins a round of the game.
		int tries = 5;  int opt = 4;
		P.success(tries, opt);
		tries = 6;  opt = 6;
		P.success(tries, opt);
		System.out.println("Player Info:");	
		System.out.println(P.toString());
		System.out.println();

		// The failure() method does not take any arguments.  However, it still
		// mutates the player but updating its total number of rounds without
		// increasing its successes.
		P.failure();
		System.out.println("Player Info:");	
		System.out.println(P.toString());
		System.out.println();
		
		// Now we want to save the player's information back to a file.  We will use
		// the player's name for the file name (so it should be a single word with no
		// unusual characters in it).  We can get the player's name with the appropriate
		// accessor, as shown below.
		
		String pName = P.getName();
		String fName = pName + ".txt";   // add txt extension
		System.out.println("Saving player info to file " + fName);
		// Make a PrintWriter with the file name
		PrintWriter w = new PrintWriter(fName);
		
		// Print to the file the contents of the player data via the method
		// toStringFile().  This method returns the raw fields in the object, with
		// newline characters ("\n") between them.  After running this program, see
		// the contents of Mortimer.txt to see the required file formatting.
		w.println(P.toStringFile());
		w.close();  // Don't forget to always close output files.  Most systems use
					// buffered output and the close() method makes sure that all of the
					// data is actually written to the file.
					
		System.out.println("Restoring player from file " + fName);
		// Now we will read the player back from the file.  We are relying on the proper
		// formatting of the file here.  First we create the File and the Scanner.  The file
		// will store (in order, per line, each as an integer):
		
		// rounds_played
		// successful_rounds
		// optimal_edits_needed
		// total_edits_needed
		
		// Note that failures is shown in the output but not stored in the file.  This is
		// because we can determine failures from rounds_played and successful_rounds and
		// thus do not need the extra variable.
		
		File inFile = new File(fName);
		Scanner fileIn = new Scanner(inFile);
		// Next we read in all of the data from the file.
		int rounds = fileIn.nextInt();  fileIn.nextLine();  // how many rounds played?
		int success = fileIn.nextInt();  fileIn.nextLine(); // how many successes?
		opt = fileIn.nextInt();  fileIn.nextLine();  // optimal number of edits for all successes
		tries = fileIn.nextInt();  fileIn.nextLine();  // actual edits for all successes
		
		// Now we create the player object.  Note the data passed into the constructor.
		// Your constructor will need to match these values and types.
		GamePlayer P2 = new GamePlayer(pName, rounds, success, opt, tries);
		
		System.out.println("Player Info:");
		System.out.println(P2.toString());
		// Note that now we have two player objects with the same data.  However, they
		// are NOT the same object, so if we mutate one, the other is not affected.
		tries = 8; opt = 6;
		P2.success(tries, opt);
		System.out.println();
		System.out.println("Player P info: ");
		System.out.println(P.toString());
		System.out.println();
		System.out.println("Player P2 info: ");
		System.out.println(P2.toString());
		System.out.println(); 
		// We do not save the updated P2 back to the file, if you look at the file
		// after running this program you will see it does not have the last success
		// recorded.
		//
		// Furthermore, if you run this program more than once, you will notice that the
		// player information does not change from run to run.  This is because each time
		// we make a new player rather than restoring the player from the file at the
		// beginning.  In your main game program, you will restore each returning player
		// from the file so that their information is updated each time they play
		// the game.
	}		
}