import java.io.*;
import java.util.*;

public class CDLL_List<T>
{
	private CDLL_Node<T> head;  // pointer to the front (first) element of the list
	private int count=0;

	public CDLL_List()
	{
		head = null; // compiler does this anyway. just for emphasis
	}

	// LOAD LINKED LIST FORM INCOMING FILE

	public CDLL_List( String fileName, String insertionMode ) throws Exception
	{
			BufferedReader infile = new BufferedReader( new FileReader( fileName ) );
			while ( infile.ready() )
			{	@SuppressWarnings("unchecked")
				T data = (T) infile.readLine(); // CAST CUASES WARNING (WHICH WE CONVENIENTLY SUPPRESS)
				if ( insertionMode.equals("atFront") )
					insertAtFront( data );
				else if ( insertionMode.equals( "atTail" ) )
					insertAtTail( data );
				else
					die( "FATAL ERROR: Unrecognized insertion mode <" + insertionMode + ">. Aborting program" );
			}
			infile.close();
	}

	private void die( String errMsg )
	{
		System.out.println( errMsg );
		System.exit(0);
	}

	// ########################## Y O U   W R I T E / F I L L   I N   T H E S E   M E T H O D S ########################

	// OF COURSE MORE EFFICIENT TO KEEP INTERNAL COUNTER BUT YOU COMPUTE IT DYNAMICALLY WITH A TRAVERSAL LOOP
	@SuppressWarnings("unchecked")
	public int size()
	{
		int count = 0;
		CDLL_Node<T> curr = head;
		do{
			count++;
			curr=curr.next;
		}
		while(curr!=head&&curr!=null);
		
		
		
		return count;
	}


	// TACK A NEW NODE ONTO THE FRONT OF THE LIST
	
	public void insertAtFront(T data)
	{	
	CDLL_Node<T> newNode = new CDLL_Node<T>(data);
	    newNode.next = head;
        newNode.prev = null;
		 if (head != null) {
            head.prev = newNode;
        } 
		else {
            insertAtTail(data);
        }

        head = newNode;
        //System.out.print(data+"<=>");
		// you could call insertAtTail here
		// then "adjust" the head pointer
	}

	// TACK ON NEW NODE AT END OF LIST
	@SuppressWarnings("unchecked")
	public void insertAtTail(T data)
	{
		  CDLL_Node<T> newNode = new CDLL_Node<T>(data);
        
        if (head == null) {  // empty list
            head = newNode;
        } else {
            CDLL_Node<T> curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
            newNode.prev = curr;
        }
		
		// you could call insertAtFront here
		// then "adjust" the head pointer
 	
	}

	// RETURN TRUE/FALSE THIS LIST CONTAINS A NODE WITH DATA EQUALS KEY
	public boolean contains( T key )
	{
		return search (key) != null;
	}

	// RETURN REF TO THE FIRST NODE (SEARCH CLOCKWISE FOLLOWING next) THAT CONTAINS THIS KEY. DO -NOT- RETURN REF TO KEY ISIDE NODE
	// RETURN NULL IF NOT FOUND
	public CDLL_Node<T> search( T key ){
	CDLL_Node<T> curr = head;
		do{
		if(curr.data.equals(key)){
			return curr;
		}
		curr=curr.next;
	}
		while(curr!=head&&curr!=null);
		
		return null;
	}

	// RETURNS CONATENATION OF CLOCKWISE TRAVERSAL
	@SuppressWarnings("unchecked")
	public String toString()
	{
		StringBuilder SB = new StringBuilder();
		CDLL_Node<T> curr = head;
		do{
			SB.append(curr.data);
			if(curr.next!=null){
				SB.append("<=>");
			}
			curr=curr.next;
		}
		while(curr!=head&&curr!=null);
		
		
		return SB.toString();
	}

} // END CDLL_LIST CLASS

// PRIVATE TO CODE OUTSIDE FILE. BUT PUBLIC TO CODE INSIDE
class CDLL_Node<T>
{
  T data; // DONT DEFINE MEMBERS AS PUBLIC OR PRIVATE
  CDLL_Node<T> prev, next; //
  CDLL_Node() 		{ this( null, null, null ); }
  CDLL_Node(T data) { this( data, null, null);  }
  CDLL_Node(T data, CDLL_Node<T> prev, CDLL_Node<T> next)
  {	this.data=data; this.prev=prev; this.next=next;
  }
  public String toString() // TOSTRING MUST BE PUBLIC
  {	return ""+data;
  }
} //END NODE CLASS

