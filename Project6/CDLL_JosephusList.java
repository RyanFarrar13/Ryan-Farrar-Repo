import java.io.*;
import java.util.*;

public class CDLL_JosephusList<T>
{
	private CDLL_Node<T> head;  // pointer to the front (first) element of the list
	private int count=0;
	// private Scanner kbd = new Scanner(System.in); // FOR DEBUGGING. See executeRitual() method 
	public CDLL_JosephusList()
	{
		head = null; // compiler does this anyway. just for emphasis
	}

	// LOAD LINKED LIST FORM INCOMING FILE
	
	public CDLL_JosephusList( String infileName ) throws Exception
	{
		BufferedReader infile = new BufferedReader( new FileReader( infileName ) );	
		while ( infile.ready() )
		{	@SuppressWarnings("unchecked") 
			T data = (T) infile.readLine(); // CAST CUASES WARNING (WHICH WE CONVENIENTLY SUPPRESS)
			insertAtTail( data ); 
		}
		infile.close();
	}
	

	
	// ########################## Y O U   W R I T E / F I L L   I N   T H E S E   M E T H O D S ########################
	
	// TACK ON NEW NODE AT END OF LIST
	public void insertAtFront(T data){
		if(head==null){
			head = new CDLL_Node<T>(data,null,null);
			head.setNext(head);
			head.setPrev(head);
		}
		else{
			head = new CDLL_Node<T>(data,head.getPrev(),head);
			head.getPrev().setNext(head);
		}
		count++;
	}
	public void insertAtTail(T data)
	{
	
        
        if (head == null) {  // empty list
            insertAtFront(data);
        } else {
           head.setPrev(new CDLL_Node<T>(data, head.getPrev(), head));
		   head.getPrev().getPrev().setNext(head.getPrev());
        }
count++;
	}

	
	public int size()
	{	
		int count = 0;
		CDLL_Node<T> curr = head;
		do{
			count++;
			curr=curr.getNext();
		}
		while(curr!=head&&curr!=null);
		return count;
	}
	
	// RETURN REF TO THE FIRST NODE CONTAINING  KEY. ELSE RETURN NULL
	public CDLL_Node<T> search( T key )
	{	
		CDLL_Node<T> curr = head;
		do{
		if(curr.getData().equals(key)){
			return curr;
		}
		curr=curr.getNext();
	}
		while(curr!=head&&curr!=null);
		
		return null;
	}
	
	// RETURNS CONATENATION OF CLOCKWISE TRAVERSAL

	public String toString()
	{
		StringBuilder SB = new StringBuilder();
		CDLL_Node<T> curr = head;
		do{
			SB.append(curr.getData());
			if(curr.getNext()!=head){
				SB.append("<=>");
			}
			curr=curr.getNext();
		}
		while(curr!=head&&curr!=null);
		return SB.toString();	
	}
	
	void removeNode( CDLL_Node<T> deadNode )
	{

		deadNode.getNext().setPrev(deadNode.getPrev());
		deadNode.getPrev().setNext(deadNode.getNext());
	}
	
	public void executeRitual( T first2Bdeleted, int skipCount )
	{
		if (size() <= 1 ) return;
		CDLL_Node<T> curr = search( first2Bdeleted );
		if ( curr==null ) return;
		
		// OK THERE ARE AT LEAST 2 NODES AND CURR IS SITING ON first2Bdeleted
		do
		{
			CDLL_Node<T> deadNode = curr;
			T deadName = deadNode.getData();
			
		    System.out.println( "stopping on " + deadName + " to delete " + deadName);
			
			// BEFORE DOING ACTUAL DELETE DO THESE TWO THINGS 
			if(skipCount > 0){
				curr = curr.getNext();
			}
			else{
				curr=curr.getPrev();
			}
			// 1: you gotta move that curr off of the deadNode. 
			//    if skipCount poitive do curr=curr.next  esle do  curr=curr.prev
			// 2: check to see if HEAD is pointing to the deadnode. 
			//    If so make head=curr 
			if(head == deadNode){
				head = curr;
			}
			removeNode(deadNode);
			// NOW DELETE THE DEADNODE
			System.out.println("deleted.  list now: " + toString()); 
			
			
			// if the list size has reached 1 return YOU ARE DONE.  RETURN RIGHT HERE
				if(size() ==1){
					return;
				}
			System.out.println("resuming at " + curr.getData() + ", skipping " + curr.getData() + " + " + (Math.abs(skipCount)-1) + " nodes CLOCKWISE/COUNTERWISE after");
			
			// write loop that advances curr pointer skipCount times (be sure of CLOCKWISE or COUNTER)
				int counter = Math.abs(skipCount);
				if(skipCount > 1){
					do{
						curr = curr.getNext();
						counter--;
					}while(counter!=0);
				}
				else{
					do{
						curr=curr.getPrev();
						counter--;
					}while(counter!=0);
				}
			// OPTIONAL HERE FOR DEBUGGING TO MAKE IT STOP AT BOTTOM OF LOOP
			// Scanner kbd = new Scanner( System.in ); String junk = kbd.nextLine();   
			
		}
		while (size() > 1 );  // ACTUALLY COULD BE WHILE (TRUE) SINCE WE RETURN AS SOON AS SIZE READES 1

	}
	
} // END CDLL_LIST CLASS




// COPY THE NODE CLASS INTO HERE THEN DELETE YOUR NODE.JAVA file 
// REMOVE ALL PUBLIC AND REMOVE SETTERS GETTERS
// LEAVE PUBLIC ONLY ON TOSTRING
class CDLL_Node<T>
{
  private T data;
  private CDLL_Node<T> prev, next; // EACH CDLL_Node PTS TO ITS PREV  & NEXT

  public CDLL_Node()
  {
    this( null, null, null );  // 3 FIELDS TO INIT
  }

  public CDLL_Node(T data)
  {
    this( data, null, null);
  }

  public CDLL_Node(T data, CDLL_Node<T> prev, CDLL_Node<T> next)
  {
    setData( data );
	setPrev( prev );
    setNext( next );
  }

  public T getData()
  {
    return data;
  }

  public CDLL_Node<T> getPrev()
  {
    return prev;
  }
  public CDLL_Node<T> getNext()
  {
    return next;
  }

  public void setData(T data)
  {
     this.data = data;
  }

  public void setNext(CDLL_Node<T> next)
  {
    this.next = next;
  }
  
  public void setPrev(CDLL_Node<T> prev)
  {
    this.prev = prev;
  }
 
  public String toString()
  {
	  return ""+getData();
  } 
	 
} //EOF