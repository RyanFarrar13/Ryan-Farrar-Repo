import java.io.*;
import java.util.*;

// NOTICE THE "<T extends Comparable<T>>"
// using <T extends Comparable<T>> in here means compiler wont let the code in main send in any T type
// that does not implement Comparable.  Now we do not have to cast the incoming key to a Comparable
// in our insertInOrder() method. Compiler now lets us call .compareTo off the dot on the incoming key
// without throwing an error.

public class LinkedList<T extends Comparable<T>> 
{
	private Node<T> head;  // pointer to the front (first) element of the list

	public LinkedList()
	{
		head = null; // compiler does this anyway. just for emphasis
	}

	// LOAD LINKED LIST FROM INCOMING FILE
	@SuppressWarnings("unchecked")
	public LinkedList( String fileName, boolean orderedFlag )
	{	head = null;
		try
		{
			BufferedReader infile = new BufferedReader( new FileReader( fileName ) );
			while ( infile.ready() )
			{
				if (orderedFlag)
					insertInOrder( (T)infile.readLine() );  // WILL INSERT EACH ELEM INTO IT'S SORTED POSITION
				else
					insertAtTail( (T)infile.readLine() );  // TACK EVERY NEWELEM ONTO END OF LIST. ORIGINAL ORDER PRESERVED
			}
			infile.close();
		}
		catch( Exception e )
		{
			System.out.println( "FATAL ERROR CAUGHT IN C'TOR: " + e );
			System.exit(0);
		}
	}

	//-------------------------------------------------------------

	// inserts new elem at front of list - pushing old elements back one place

	public void insertAtFront(T data)
	{
		head = new Node<T>(data,head);
	}

	// we use toString as our print

	public String toString()
	{
		String toString = "";

		for (Node<T> curr = head; curr != null; curr = curr.next )
		{
			toString += curr.data;		// WE ASSUME OUR T TYPE HAS toString() DEFINED
			if (curr.next != null)
				toString += " ";
		}

		return toString;
	}

	// ########################## Y O U   W R I T E    T H E S E    M E T H O D S ########################


//NY CODE
	public int size() // OF COURSE MORE EFFICIENT to KEEP COUNTER BUT YOU  MUST WRITE LOOP
	{
		int count = 0;
		Node<T> curr = head;
		while(curr.next!=null){
			curr=curr.next;
			count++;
		}
		count++;
		return count;	 
	}

	public boolean empty()
	{
	  return(head==null);
	}

	public boolean contains( T key )
	{
		if(search(key)!=null){
			return true;
		}
		return false;
	}

	public Node<T> search( T key )
	{
		if(head == null){
			return null;
		}
		else{
			//NodE<T> curr and head !=
			for(Node<T> curr = head; curr != null; curr = curr.next){
				if(curr.data.compareTo(key) == 0){
					return curr;
				}
			}
			return null;
		}
	}

	// TACK A NEW NODE (CABOOSE) ONTO THE END OF THE LIST
	public void insertAtTail(T data)
	{
		Node<T> curr = head;
		 if(curr == null){
			  insertAtFront(data);
			 }
		else{
			while(curr.next!=null){
				curr = curr.next;
			}
			curr.next=(new Node<T>(data));
		}
	}

	//If you cut an exponential search space in half, is the complexity still exponential on N?
	// IF YOU DEFINE <T> at the top of this class as <T implements Comparable>
	// YOU DO NOT HAVE TO CAST TO COMPARABLE AND YOU DO NOT NEED TO SUPPRESS 
	public void insertInOrder(T  data)//what is theBigO of this method?
	{
		if(head == null){
			insertAtFront(data);
		}
		else if(head.data.compareTo(data) >= 1){
			insertAtFront(data);
		}
		else{
			Node<T> prev = head;
			for(Node<T> curr = prev.next; curr != null; curr = curr.next){
				if(curr.data.compareTo(data) >= 1){
					prev.next = new Node<T>(data, curr);
					break;
				}
				prev = curr;
			}
			if(prev.next == null){
				insertAtTail(data);
			}
		}
	}

	public boolean remove(T key)
	{
		//My code
		if(head == null){
			return false;
		}
		else if(!contains(key)){
			return false;
		}
		else{
			if(head.data.equals(key)){
				removeAtFront();
			}
			else{
				Node<T> prev = head;
				for(Node<T> curr = prev.next; curr != null; curr = curr.next){
					if(curr.data.compareTo(key) == 0){
						prev.next = curr.next;
						break;
					}
					prev = curr;
				}
				if(prev.next == null && prev.data.compareTo(key) == 0){
					removeAtTail();
				}
			}
			return true;
		}
	}

	public boolean removeAtTail()	// RETURNS TRUE IF THERE WAS NODE TO REMOVE
	{
		if(head == null){
			return false;
		}
		else if(size() == 1){
			return removeAtFront();
		}
		else{
			Node<T> prev = head;
			for(Node<T> curr = prev.next; curr.next != null; curr = curr.next){
				prev = curr;
				continue;
			}
			prev.next = null;
			return true;
		}
	}
		
	public boolean removeAtFront() // RETURNS TRUE IF THERE WAS NODE TO REMOVE
	{
		if(head==null){
			return false;
		}
		head = head.next;
		return true;
	}

	public LinkedList<T> union( LinkedList<T> other )
	{
		LinkedList<T> union = new LinkedList<T>();
		union = copy(this);
		for(Node<T> curr = other.head; curr != null; curr = curr.next){
			if(!union.contains(curr.data)){
				union.insertInOrder(curr.data);
			}
		}
		return union;
	}

	public LinkedList<T> inter( LinkedList<T> other )
	{
		LinkedList<T> inter = new LinkedList<T>();
		inter = copy(this);
		for(Node<T> curr = inter.head; curr != null; curr = curr.next){
			if(!other.contains(curr.data)){
				inter.remove(curr.data);
			}
		}
		return inter;
	}
	public LinkedList<T> diff( LinkedList<T> other )
	{
		LinkedList<T> diff = new LinkedList<T>();
		diff = copy(this);
		for(Node<T> curr = diff.head; curr != null; curr = curr.next){
			if(other.contains(curr.data)){
				diff.remove(curr.data);
			}
		}
		return diff;
	}
	public LinkedList<T> xor( LinkedList<T> other )
	{
		return union(other).diff(inter(other));

	}//what is the Big o runtime of this xor method?
	
	
	public LinkedList<T> copy(LinkedList<T> other){
		LinkedList<T> temp = new LinkedList<T>();
		for(Node<T> curr = other.head; curr != null; curr = curr.next){
			temp.insertAtTail(curr.data);
		}
		return temp;
	}

} //END LINKEDLIST CLASS 

// A D D   N O D E   C L A S S  D O W N   H E R E 
// R E M O V E  A L L  P U B L I C  &  P R I V A T E (except toString)
// R E M O V E  S E T T E R S  &  G E T T E R S 
// M A K E  T O  S T R I N G  P U B L I C




//Start of NOde class
class Node<T extends Comparable<T>> 

{
   T data;
   Node<T> next;

   Node()
  {
    this( null, null );
  }

  Node(T data)
  {
    this( data, null );
  }

   Node(T data, Node<T> next)
  {
    this.data=data;
    this.next=next;
  }
  
  public String toString()
  {
	  return ""+this.data;
  } 
	 
} //EOF