// 2021 FALL CS 445 LAB #4  STUDENT STARTER FILE

import java.io.*;
import java.util.*;

public class LL_Recursive<T>
{
	private Node<T> head;  // pointer to the front (first) element of the list

	public LL_Recursive()
	{
		head = null; // compiler does this anyway. just for emphasis
	}

	// INSERTS NEW NODE AT FRONT PUSHING EXISTING NODES BACK ONE PLACE
	public void insertAtFront(T data)
	{
		head = new Node<T>(data,head);
	}

 	
	// #####  W R I T E  (O R  R E-W R I T E)  T H E S E   M E T H O D S   R E C U R S I V E L Y ####


 	// MUST USE (CALL) search() METHOD IN THIS CODE TO DETERMINE THE RETURN VALUE
 	// NO LOOPS ALLOWED NO RECURSION ALLOWED.  THE SEARCH WILL BE RECURSIVE THOUGH
 	public boolean contains( T key )
 	{
		if(search(key)!=null){
			return true;
		}
 		return false; 
	}

	// YOU MUST WRITE THIS USING RECURSION
	// YOU WILL HAVE TO WRITE A HELPER METHOD. THE HELPER WILL BE RECURSIVE
	public void insertAtTail(T data)
	{
		if(head==null){
			insertAtFront(data);
			return;
		}
		 insertAtTailHelper(data, head);
		// YOUR CODE HERE. MUST USE insertAtFront() IN BASE CASE
	}
    public void insertAtTailHelper(T data, Node<T> head){
		
		if(head.next==null){
			head.next=new Node<T>(data);
			return;
		}
	     insertAtTailHelper(data, head.next);
	}
	// WE will illustrate this in class today 2/6/2022
	public int size()
	{
		return sizeHelper( head ); 
	}
	private int sizeHelper( Node<T> head )
	{
		if (head==null) return 0;
		return 1 + sizeHelper(head.next);
	}
	
	// USE THE TOSTRING AS OUR PRINT.  ***MUST RE-WRITE USING RECURSION***
	// YOU WILL HAVE TO WRITE A HELPER METHOD. THE HELPER WILL BE RECURSIVE
	public String toString()
	{
		
		String toString = "";
        
		for (Node<T> curr = head; curr != null; curr = curr.next)
		{
			toString += curr.data;		// WE ASSUME OUR T TYPE HAS toString() DEFINED
			if (curr.next != null)
				toString += " -> ";
		}

		return toString + "\n";
	}
	
      	   
	// MUST BE RECURSIVE. YOU WILL HAVE TO WRITE A HELPER METHOD. THE HELPER WILL BE RECURSIVE
	public Node<T> search( T key )
	{
		if(head==null) return null;
		return searchHelper(key, head);
		
	}
	public Node<T> searchHelper( T key, Node<T> head){
	
		if(head.data.equals(key)){
			return head;
		}
		if(head.next==null){
			return null;
		}
			return searchHelper(key, head.next);
	}
	
} //END OF LL_Recursive CLASS


///////////////////////////////////////////////////////////////////////////////////////////////////

class Node<T>
{ T data;
  Node<T> next;
  Node() { this( null, null ); }
  Node(T data){this( data, null ); }
  Node(T data, Node<T> next) { this.data=data; this.next=next; }
  public String toString() { return ""+data; }
} //END OF NODE CLASS