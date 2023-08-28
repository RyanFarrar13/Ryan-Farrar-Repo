/*
	Deck class (for TopCardPlacer class of project #1
*/

import java.util.*;
import java.io.*;

public class Deck
{
	private int[] deck;
	private final int MAX_DECK_SIZE = 30;
	public Deck( int numCards )
	{	if ( numCards%2 != 0 || numCards > MAX_DECK_SIZE ) 
		{
			System.out.format("\nINVALID DECK SIZE: (" + numCards + "). Must be an small even number <= %d\n", MAX_DECK_SIZE);
			System.exit(0);
		}
		deck = new int[numCards];
		for ( int i=0 ; i<numCards ; i++ ) deck[i] = i;
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
	}
	
	
	public String toBitString( int n ) 
	{
		if (n==0){
			return "";
		}
		String A="";
		int size = (int)(Math.log(n)/ Math.log(2)) + 1;
		for(int i=size-1;i>=0;i--){
             if(n-Math.pow(2,i) >= 0){
				 A+= "1";
				 n = n - (int)Math.pow(2,i);
			 }
               else{
                  A += "0";
			   }
		}			   
         return A;
		}			
	
	
}	// END DECK CLASS