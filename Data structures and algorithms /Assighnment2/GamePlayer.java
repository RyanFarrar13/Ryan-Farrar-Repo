import java.io.Writer;
import java.util.*;
import java.io.FileWriter;
import java.io.*;
public class GamePlayer{
public static void main(String [] args) throws IOException{
//    Dictionary D = new Dictionary(Dname);
}
public void PlayerProfileUpdate(String PlayName, String PlayCount, String WinCount, String LossCount, String PassWord) throws IOException{

//Creates new file and puts necesary Player Info
String fileLocation = "C:\\Users\\Ryan\\Downloads\\javaCode\\Assighnment2\\";
String rFileLocation = fileLocation.concat(PlayName);
String rrFileLocation = rFileLocation.concat(".txt");
File del = new File(rrFileLocation);
del.delete();

File playerName = new File(rrFileLocation);
    playerName.createNewFile();
PrintWriter PW = new PrintWriter(rrFileLocation);
	//Ceative way to actually "change what is written in the file"
	
	PW.println(PlayName);//name
	PW.println(PlayCount);//rounds played 
	PW.println(WinCount);//win count
	PW.println(LossCount);//L count
	PW.println(PassWord);
	PW.close();		
}

}

