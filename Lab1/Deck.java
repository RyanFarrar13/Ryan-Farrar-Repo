/*
	Deck class
*/

import java.util.*;
import java.io.*;

public class Deck
{
	private int[] deck;
	private final int MAX_DECK_SIZE = 20;
	public Deck( int numCards )
	{	if ( numCards%2 != 0 || numCards > MAX_DECK_SIZE ) 
		{
			System.out.format("\nINVALID DECK SIZE: (" + numCards + "). Must be an small even number <= %d\n", MAX_DECK_SIZE);
			System.exit(0);
		}
		deck = new int[numCards];
		for(int i=0; i< numCards;i++)
		deck[i] = i;
		//YOU DO THIS => init deck to be exactly numCards long
		// YOU DO THIS => fill deck with with 0 1 2 3 ... numCards-1 in order
	}

	public String toString()
	{
		String deckStr = "";
		for ( int i=0 ; i < deck.length ; ++i )
			deckStr += deck[i] + " ";
		return deckStr;
	}

	// ONLY WORKS ON DECK WITH EVEN NUMBER OF CARDS
	// MODIFIES THE MEMBER ARRAY DECK
	public void inShuffle()
	{    
		int[] temp = new int[deck.length];
		int counter = 0;
		for(int i = 0; i<deck.length-1;i+=2){
			temp[i]=deck[(deck.length/2)+counter];
			temp[i+1]=deck[counter];
			counter++;
		}
	    for(int i = 0; i<deck.length;i+=1){
			deck[i] = temp[i];
		}
	   
		// YOUR CODE HERE DELETE LINE
	}

	// ONLY WORKS ON DECK WITH EVEN NUMBER OF CARDS
	// MODIFIES THE MEMBER ARRAY DECK
	public void outShuffle()
	{
		int[] temp = new int[deck.length];
		int counter = 0;
		for(int i = 0; i<deck.length-1;i+=2){
			temp[i]=deck[counter];
			temp[i+1]=deck[(deck.length/2)+counter];
			counter++;
			
		}
	    for(int i = 0; i<deck.length;i+=1){
			deck[i] = temp[i];
		}
		
		
		// YOUR CODE HERE DELETE LINE	
	}
	
	// RETURNS TRUE IF DECK IN ORIGINAL SORTED:  0 1 2 3 ...
	public boolean inSortedOrder()
	{
		 for(int i = 0; i<deck.length-1;i+=1){
			 if(deck[i]>deck[i+1]){
				 return false;
			 }
		// YOUR CODE HERE DELETE LINE
		 // JUST HERE TO COMPILE
		 }
		 return true;
	}
	
}	// END DECK CLASS