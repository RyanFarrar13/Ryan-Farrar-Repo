// CMPINF 0401 Fall 2022
// MyDeque class to implement a simple deque
// Complete the methods indicated.  Be careful about the
// special cases indicated.  See lab for details on how
// to implement the methods.

public class MyDeque implements SimpleDeque
{
	Object [] theData;
	int numItems;

	public MyDeque(int maxItems)
	{
		theData = new Object[maxItems];
		numItems = 0;
	}
	
	public boolean isEmpty()
	{
		return (numItems == 0);
	}
	
	public void addFront(Object X)
	{
		if(theData[theData.length-1] != null){
			return;
		}
		for(int i = theData.length; i >= 0; i--){
			if(theData[i] != null){
				theData[i+1] = theData[i];
			}
		}
		theData[0] = X;
		
		// Add new item at front of list (shifting old items
		// to right first).  If the list is full, do not add
		// the item (just do nothing).
	}

	public void addRear(Object X)
	{
		if(theData[theData.length-1] != null){
			return;
		}
		for(int i = theData.length-1; i >= 0; i--){
			if(theData[i] != null){
				theData[i-1] = theData[i];
			}
		}
		theData[theData.length-1] = X;
		// Add new item at rear of list.  If the list is full,
		// do not add the item (just do nothing).
	}

	public Object removeFront()
	{
		if(theData[0]==null){
			return null;
		}
	    Object VXT = theData[0];
		theData[0] = theData[1];
		for(int i = 1; i < theData.length; i++){//Migght need less than and eqyal
			if(theData[i] != null){
				theData[i] = theData[i+1];
				
			}
		}
		// Remove and return front item from list, shifting remaining
		// items to the left to fill the spot.  If list is empty,
		// return null.
		return VXT;
	}

	public Object removeRear()
	{
		if(theData[0]==null){
			return null;
		}
	Object VTX =theData[theData.length];
	       theData[theData.length] = null;
		return VTX;
		// Remove and return rear item from list.  If list is empty,
		// return null.
	}
}