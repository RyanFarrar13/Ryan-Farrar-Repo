import java.io.Writer;
import java.util.*;
import java.io.FileWriter;
import java.io.*;
//Ryan Farrar Assighnment 3, This is the revised work of 
//assighment 2. Some code is shared but even shared code's variable names will differ
// An example would be A2 / A3.


//Code WIll compile but won't run due to input mismatch errors. There is also an issue with the PlayerList
//not knowing which player is currently playing the game. Unfortunately, I do not know how to solve either of this issues, and
//after hours of trying to solve these two issues alone, I've given up.




//Ryan Farrar Time Tracker: D1 .5
//D2 3   D3 3 D4 3 D5 1 D6 2






public class A3{//Start of Class
	public static void main (String [] args) throws IOException {//Start of Main program
	
    PlayerList PL;
	PL = new PlayerList("players.txt");
	GamePlayer GP;

	
	
	Scanner ScanIn = new Scanner(System.in);//ScanIn is name of keyboard scanner\]
	int x = 0;
	String Dname = "";
	while ( x == 0){
	System.out.println("Please enter the name of the dictionary file____");
	   Dname = ScanIn.nextLine();
	if (Dname.equals("dictionary.txt") || Dname.equals("smallDict.txt")){
    x++;	
	}
	else { 
	System.out.println("Please enter a valid file name ");	
	}
	}
	 Dictionary D = new Dictionary(Dname);	
	 

	int z = 0;
	System.out.println("Welcome to the Word Changer program, ");
	System.out.println("");
	System.out.println("Please sign in with your name and password");
	System.out.println("If you are a new player, leave your name field blank");
	System.out.println("and we will set you up with a new account");
	System.out.println("If you would like to end the game, enter 'Quit'");
	System.out.println("");
	System.out.println("	Name:");
	String eName = ScanIn.nextLine();
	if(eName.equals("Quit")){
			System.exit(0);		
	}
	if(eName.equals("")){
		//que code to create new player 
		int q=0;
		System.out.println("Hello new player! ");
		System.out.println("Before playing, i must get some information from you. ");
		while (q < 1) {
		System.out.println("Please enter a name for your account (no spaces):");
		String ENamE = ScanIn.next();
		boolean A = PL.containsName(ENamE);
		if(A==false){
			System.out.println("Sorry, but that name is already taken, please create a different username,");
			
		}
		if(A==true){
	
			q++;
				System.out.println("Please enter the password: ");
	String ePassword = ScanIn.next();
	PL.addplayer(ENamE,ePassword);
	
		}
		}

	}
	if((!eName.equals("")) && (!eName.equals("Quit"))){//This will pick up normal route for code
		System.out.println("Please enter the password: ");
	String ePassword = ScanIn.next();
	GamePlayer temp = new GamePlayer(eName);
	GamePlayer GamP = PL.authenticate(temp);
	z=0;
	if(GamP!=null){
	PL.addplayer(eName, ePassword);//SHOULDNT ADD PLAYER< SHOULD LODE PLAYER
		
	}
	if(GamP==null){
		while(z==0){
		System.out.println("sorry, but eiether the Username and or password that you entered was incorrect.");
		System.out.println("please enter a username. (enter quit to close program.)");
		String EnAm = ScanIn.next();
		if(EnAm.equals("quit")){
			System.exit(0);
		}
		boolean B = PL.containsName(EnAm);
		if(B==false){		
		}
		if(B==true){	
				System.out.println("Please enter the password: ");
		String EPASS = ScanIn.next();
		GamePlayer tempA1 = new GamePlayer(EnAm);
		tempA1.setPass(EPASS);
		GamePlayer TempA1 = PL.authenticate(tempA1);
		if(TempA1!=null){
          z++;
	 PL.addplayer(EnAm, EPASS);//SHOULD LODE PLAYER
	
		}
	}
	}
	}
		System.out.println("Welcome to the Word Changer program, ");
System.out.println("");
System.out.println("Here is how to play: ");
System.out.println("		For each round you will see two randomly selected words.");
System.out.println("		You will have 1 minute to convert the first word to the second.");
System.out.println(" 	using only the following changes:");
System.out.println(" 		  Insert a character at position k (with k starting at 0)");
System.out.println(" 		  Delete a character at position k (with k starting at 0)");
System.out.println("			  Change a character at position k (with k starting at 0)");
System.out.println("		For example, to change the word 'WEASEL' to 'SEASHELL' you could");
System.out.println("		do the following:");
System.out.println("			1) Change 'W' at position 0 to 'S': SEASEL");
System.out.println("			2) Insert 'H' at position 4: SEASHEL");
System.out.println("			3) Insert 'L' at position 7: SEASHELL");
System.out.println("		Your goal is to make this conversion with the fewest changes.");
System.out.println("		Note that there may be more than one way to achieve this goal.");


	int iop = 0;
while(iop == 0){
System.out.println("Would you like to play the game? (y/n)");
String qwerty = ScanIn.nextLine();
if(qwerty.equals("n")){
	System.exit(0);
}
if(qwerty.equals("y")){
	iop++;
}
//Game Start
System.out.println(" Please enter eiether y/n)");
}
int WantPlay = 0;
while( WantPlay == 0){
	 //Dictionary D = new Dictionary(Dname);	
	 MyTimer MT = new MyTimer(60000);
	 MT.start();
	 

//boolean Tymer = MT.check();
System.out.println("Lets Play!!");
int xxx = 5;
int yyy = 9;   
String RW1 =  D.randWord(xxx, yyy);
String RW2 =  D.randWord(xxx, yyy);
int Distance = D.distance(RW1, RW2);
int nDistance = Distance;
StringBuilder S1, S2;
S1 = new StringBuilder(RW1);
S2 = new StringBuilder(RW2);
int Finish = 0;
System.out.println("Your goal is to convert '" + RW1 + "' to '" + RW2 + "' in " + Distance + " edits.");
while( Finish ==0 ){
	System.out.println(" ");
	System.out.println("Index:        0123456789");
	System.out.println("------        ----------");
	System.out.println("Current Word: " + S1);
	System.out.println("Word 2:       " + S2);
	System.out.println("Here are your options: ");
	System.out.println("        C k v -- Change char at location k to value v");
	System.out.println("        I k v -- Insert char at location k with value v");
	System.out.println("        D k   -- Delete char at location k");
	System.out.println("Would you like to Change, Insert, or Delete a charcter. (C/I/D)");
	System.out.println("You can Also enter anything else in order to stop the game.");
	String OC1 = ScanIn.nextLine();//OptChoice1
    if(OC1.equals("C")){
		System.out.println("Where would you like to change a character?");
		int Loc = ScanIn.nextInt();
		String Throw = ScanIn.nextLine();
		System.out.println("What character would you like to change to?");
		String NewC = ScanIn.nextLine();
		int Loc1 = Loc + 1;
		S1.delete(Loc, Loc1);
		S1.replace(Loc, Loc, NewC);
		//Works
		nDistance = nDistance - 1;	
	}
	if(OC1.equals("I")){
		System.out.println("Where would you like to insert a character?");
		int Loc = ScanIn.nextInt();
		String Throw = ScanIn.nextLine();
		System.out.println("What character would you like to insert?");
		String NewC = ScanIn.nextLine();
		S1.replace(Loc, Loc, NewC);
		//Works
		nDistance = nDistance - 1;
	}
	if(OC1.equals("D")){
		System.out.println("Where would you like to delete a character?");
		int Loc = ScanIn.nextInt();
		String Throw = ScanIn.nextLine();
		int Loc1 = Loc + 1;
		S1.delete(Loc, Loc1);
	    //works	
		nDistance = nDistance - 1;
	}
	if(!OC1.equals("C") && !OC1.equals("I") && !OC1.equals("D")){
		System.exit(0);
	}
 
 if(S1.toString().equals(RW2)){
 Finish++;	 //if timer and nDistance>=0
 }

}
Finish--;

boolean Tymer = MT.check();
if (Tymer == true && nDistance>=0){
	

	System.out.println("Congratualtions!! ");
	System.out.println("You have converted:      " + RW1);
	System.out.println("into:                    " + RW2);
	System.out.println("in " + Distance + " edits ");
	System.out.println("You used the minimal number of changes -- great job!");	
}
if (Tymer != true && nDistance>=0){

	System.out.println("you ran out of time :( ");
	System.out.println("you did convert in the minimal amount of edits at least :)");
}
if(nDistance<0){
	
System.out.println("you did not use the miniml amount of edits :(");
System.out.println("the minimal amount of edits was " + Distance );
}
	
	System.out.println("Would you like to play again? (y/n) (if y is not entered program will close)");
	String PA = ScanIn.nextLine();
	if(PA.equals("y")){		
	}
	else{
		WantPlay++;
	}
}

		
	}
	//Figure out how to 'load' current gameplayer and then just add gameplay.
	
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	PL.saveList();
	
	
	} //End of Main Program 
		
	
} 
//End of class (Main Class A3)