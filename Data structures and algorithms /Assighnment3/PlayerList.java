// CMPINF 0401 Fall 2022
// Shell of the PlayerList class.
// This class represents a collection of players -- a very simple database.  The
// collection can be represented in various ways.  However, for this assignment
// you are required to use an array of GamePlayer.

// Note the imports below.  java.util.* is necessary for a Scanner and java.io.* is
// necessary for various File classes.
import java.util.*;
import java.io.*;
import java.io.FileWriter;
import java.io.BufferedWriter;
public class PlayerList
{
	private GamePlayer [] players;  // array of GamePlayer
	private int size;				// logical size
	private String file;			// name of file associated with this PlayerList
	private int nSize;
	
	// Initialize the list from a file.  Note that the file name is a parameter.  You
	// must open the file, read the data, making a new GamePlayer object for each line
	// and putting them into the array.  Your initial size for the array MUST be 3 and
	// if you fill it should resize by doubling the array size.  You will need to write
	// a resize() method to do the resizing.
	
	
	// Note that this method throws IOException. Because of this, any method that CALLS
	// this method must also either catch IOException or throw IOException.  Note that 
	// the main() in PlayerListTest.java throws IOException.  Keep this in mind for your
	// main program (Assig3.java).  Note that your saveList() method will also need
	// throws IOException in its header, since it is also accessing a file.
	public PlayerList(String fName) throws IOException
	{
		players = new GamePlayer[3];
		size = 0;
		File FName = new File(fName);
		Scanner fScan = new Scanner(FName);
		int ARL = players.length;//Int ARL = Array Length 
		while(fScan.hasNextLine()){
			String name = fScan.next();
			String passw = fScan.next();
			int roun = fScan.nextInt();
			int succ = fScan.nextInt();
			int mindist = fScan.nextInt();
			int attempts = fScan.nextInt();
			players[size] = new GamePlayer(name);
            players[size].setPass(passw);	
            players[size].setRound(roun);
			players[size].setSucc(succ);
			players[size].setMinDist(mindist);
			players[size].setAttem(attempts);
            			
			size ++;
            if(size == ARL){
				nSize = ARL * 2;
			GamePlayer[] nArray = new GamePlayer[nSize];
			            for(int i=0; i<size; i++){
							nArray[i] = players[i];//Next, go to GamePlayer and sort these into valuable info.
						}
				players = nArray;
				
			}			
		}		
	}
	
	
	public boolean containsName(String Name){//I dont know if this works/ WIll REtrunt true of NAMES DONT MATCH
          for(int i = 0; i<size; i++){
			  if(players[i].getName().equals(Name)){
				  return false;
			  }
	}
	return true;
	}
	public int capacity(){
		int Cap = players.length;
		return Cap;
	}
	public int size(){
		return size;
	}
	public String toString(){
		StringBuilder SB = new StringBuilder();
		System.out.print("Total Players: " + size);
		 for(int i = 0; i<size; i++){
			 SB.append('\n');
			  SB.append('\n');
			  SB.append("Name: " + players[i].getName());
			   SB.append('\n');
			   SB.append("Rounds: " + players[i].getRound());
			    SB.append('\n');
				SB.append("Successes: " + players[i].getSuccess());
				 SB.append('\n');
				SB.append("Attempts: " + players[i].getAttempt());
				 SB.append('\n');
				 SB.append("Ratio: " + players[i].getRatio());
		
	}
	String qwera = SB.toString();
	return qwera;
	}
	public boolean addPlayer(GamePlayer GPlayer){
		boolean CH = containsName(GPlayer.getName());
		if(CH==false){
			return false;	
		}
		if(CH==true){
			 size++;
		int ro=0; 
		int fi = 0;
		int y=0;
		int wsa=0;
		players[size] = new GamePlayer(GPlayer.getName());
            players[size].setPass(GPlayer.getPass());	
            players[size].setRound(ro);
			players[size].setSucc(fi);
			players[size].setMinDist(y);
			players[size].setAttem(wsa);
			return true;
		
		}
		return true;
	}
	
	
	
	public GamePlayer addplayer(String eNa, String ePas){
		boolean CH = containsName(eNa);
		
		 size++;
		int ro=0; 
		int fi = 0;
		int y=0;
		int wsa=0;
		players[size] = new GamePlayer(eNa);
            players[size].setPass(ePas);	
            players[size].setRound(ro);
			players[size].setSucc(fi);
			players[size].setMinDist(y);
			players[size].setAttem(wsa);
		return players[size];
	}
	public GamePlayer authenticate(GamePlayer GaPlayer){
		String Na = GaPlayer.getName();
		String Pa = GaPlayer.getPass();
		for(int i = 0; i<size; i++){
			  if((players[i].getName().equals(Na)) && (players[i].getPass().equals(Pa))){
				  return GaPlayer;
			  }
			  else{
			  return null;}
	}
	
	return null;
	}
	public void saveList() throws IOException{//Current GamePlayer
		String FileLocation = "C:\\Users\\Ryan\\Downloads\\javaCode\\Assighnment3\\players.txt";
		File del = new File(FileLocation);
		FileWriter FW = new FileWriter(del);
		for(int i = 0; i<size; i++){
	
		    FW.write('\n');
			FW.write(players[i].getName());
			FW.write(",");
			FW.write(players[i].getPass());
			FW.write(",");
			FW.write(players[i].getRound());
			FW.write(",");
			FW.write(players[i].getSuccess());
			FW.write(",");
			FW.write(players[i].getMinDist());
			FW.write(",");
			FW.write(players[i].getAttempt());
		    FW.flush();
			FW.close();
		}
			 
}  
	
	}
	
	
	// See program PlayerListTest.java to see the other methods that you will need for
	// your PlayerList class.  There are a lot of comments in that program explaining
	// the required effects of the methods.  Read that program very carefully before
	// completing the PlayerList class.  You will also need to complete the modified
	// GamePlayer class before the PlayerList class will work, since your array is an
	// array of GamePlayer objects.
	
	// You may also want to add some methods that are not tested in PlayerListTest.java.
	// Think about what you need to do to a PlayerList in your Assig3 program and write 
	// the methods to achieve those tasks.  However, make sure you are always thinking
	// about encapsulation and data abstraction.
