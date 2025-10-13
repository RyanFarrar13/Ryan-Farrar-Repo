
//
import java.io.FileWriter;  
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
 
import java.io.Writer;
import java.io.*;
import java.util.*;
 //Has max capacity of 100 lines/rows 
 //encryption key val  +5
public class Encrypt {
      public static String[] word;
	  public static String[] wordEncrypted;
	  public static String FileLoc;//infileloc
	  public static String outFileLoc;
	  public static int key;
	  public static int format;

    public static void main(String[] args)  throws IOException{
		word = new String[100];
		wordEncrypted = new String[100];
		format = 4;// establishes that the length of info per line in input file is 4
		key =5;
	    FileLoc = "C:\\Users\\Ryan\\Downloads\\project1\\Input.txt";
		outFileLoc = "C:\\Users\\Ryan\\Downloads\\project1\\Output.txt";
		ReadInput(FileLoc);
		Encryp();
		ProduceOutput();
    }
	
	public static void Encryp(){
		int j = 0;
		while(word[j]!=null){
			String Fortnite = word[j];
			char[] chars = Fortnite.toCharArray();
			String newC =  "";
			for(char c : chars){
				c+=key;
			newC=newC+c;
			}
			wordEncrypted[j] = newC;
			j++;
		}
		
	}
	
	public static void ReadInput(String FileLocation) throws FileNotFoundException {
	
		File d = new File(FileLocation);
		Scanner pInfo = new Scanner (d);
		int i = 0;
		while(pInfo.hasNextLine()){
			  String line = pInfo.nextLine();
                String[] strings = line.split(" "); // Split the line into an array of strings
              for(int j = 0; j<format;j++){
				  word[i]=strings[j];
				  i++;
				  System.out.println(strings[j]);
			  }
		}
	}
	
	public static void ProduceOutput() throws IOException {
		File a = new File(outFileLoc);
		a.createNewFile();	
		FileWriter myWriter = new FileWriter(outFileLoc);
		
		int j = 0;
		
		while(wordEncrypted[j]!=null){
			for(int i = 0;i<format;i++){
				myWriter.write(wordEncrypted[j]);
				j++;
				myWriter.write(",");
			}
			myWriter.write("\n");
		}
		
		myWriter.close();
	}

  
}