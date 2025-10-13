import java.io.Writer;
import java.util.*;
import java.io.FileWriter;
import java.io.*;
//Ryan farrar
public class A2{
	public static void main (String [] args) throws IOException {//MAINNNN
    
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
	 
//----------------
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
System.out.println("Please enter your name (or [Enter] to quit):");
String [] myArray;
myArray = new String[5];
myArray[0] = "0";
String UEname = ScanIn.nextLine();//User Entered Name
if (UEname.equals("Enter")){
	System.exit(0);	
}
else{}//IMPORTANT, The order of Data in A player file is, first line) Name, 2) rounds played, 3) Succes count, 4) failure count,5) Password
String UFname = UEname.concat(".txt");//User FIle NAme
File PlayerName = new File(UFname);
String pName;
if(PlayerName.exists()){//This is the point that determaines whethere or not a player file exists
System.out.println("Welcome back " + UEname);
	Scanner pInfo = new Scanner (PlayerName);//player info
	
	for (int i = 0; i<myArray.length;i++){
		myArray[i]= pInfo.nextLine();
	}
		System.out.println("Please enter the password for your account");//password
		String EPassWord = ScanIn.nextLine();
		boolean AAA = (EPassWord.equals(myArray[4]));
		if ( AAA == false){
		System.out.println("You entered the wrong password,,, Imposter");
        System.exit(0);			
		}
}       
// myArray[0]=name, 1 = rounds played, 2 = rpunds won, 3 = rounds lost, 4 = password
else  { 
	System.out.println("Welcome new player!!");//this creates new file for new player and establish set values for file
	String fileLocation = "C:\\Users\\Ryan\\Downloads\\javaCode\\Assighnment2\\";
	String rFileLocation = fileLocation.concat(UFname);
    File playerName = new File(rFileLocation);
    playerName.createNewFile();
	PrintWriter PW = new PrintWriter(rFileLocation);
	System.out.println("Please enter a password for your account___");
	String PassWord = ScanIn.nextLine();	
	PW.println(UEname);//name
	PW.println("0");//rounds played 
	PW.println("0");//win count
	PW.println("0");//L count
	PW.println(PassWord);
	PW.close();
		Scanner pInfo = new Scanner (PlayerName);//player info
	for (int i = 0; i<myArray.length;i++){
		myArray[i]= pInfo.nextLine();
}
	}
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
	 
GamePlayer GP = new GamePlayer();
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
int III = Integer.parseInt(myArray[1]);
 III++;
myArray[1] = Integer.toString(III);

boolean Tymer = MT.check();
if (Tymer == true && nDistance>=0){
	int II = Integer.parseInt(myArray[2]);
 II++;
myArray[2] = Integer.toString(II);
	System.out.println("Congratualtions!! ");
	System.out.println("You have converted:      " + RW1);
	System.out.println("into:                    " + RW2);
	System.out.println("in " + Distance + " edits ");
	System.out.println("You used the minimal number of changes -- great job!");	
}
if (Tymer != true && nDistance>=0){
	int IIII = Integer.parseInt(myArray[3]);
 IIII++;
myArray[3] = Integer.toString(IIII);
	GP.PlayerProfileUpdate(myArray[0], myArray[1], myArray[2], myArray[3], myArray[4]);
	System.out.println("you ran out of time :( ");
	System.out.println("you did convert in the minimal amount of edits at least :)");
}
if(nDistance<0){
	int IIIII = Integer.parseInt(myArray[3]);
 IIIII++;
myArray[3] = Integer.toString(IIIII);
System.out.println("you did not use the miniml amount of edits :(");
System.out.println("the minimal amount of edits was " + Distance );
}
	PrinT(myArray[0], myArray[1], myArray[2], myArray[3], myArray[4]);
	GP.PlayerProfileUpdate(myArray[0], myArray[1], myArray[2], myArray[3], myArray[4]);
	System.out.println("Would you like to play again? (y/n) (if y is not entered program will close)");
	String PA = ScanIn.nextLine();
	if(PA.equals("y")){		
	}
	else{
		WantPlay++;
	}
}
	}//end of Main
    public static void PrinT(String PlayName, String PlayCount, String WinCount, String LossCount, String PassWord) {
	System.out.println("Here are your current stats: ");
	System.out.println("Name: " + PlayName);
	System.out.println("Rounds: " + PlayCount);
	System.out.println("successes: " + WinCount);
	System.out.println("Failures: " + LossCount);
	double PlayC = Double.parseDouble(PlayCount);
	double PlayW = Double.parseDouble(WinCount);
	double Ratio = (PlayW/PlayC);
	System.out.println("Ratio: (succes) " + Ratio);
}
}//end of class	
		
// myArray[0]=name, 1 = rounds played, 2 = rpunds won, 3 = rounds lost, 4 = password
//GP.PlayerProfileUpdate(myArray[0], myArray[1], myArray[2], myArray[3], myArray[4]);  This is code need to save state