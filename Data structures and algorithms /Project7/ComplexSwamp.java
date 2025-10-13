import java.io.*;
import java.util.*;
// DO NOT IMPORT ANYTHING ELSE
// NO PACKAGE STATMENTS 
// NO OVERRIDE STATMENTS 

public class ComplexSwamp
{
	static int[][] swamp;  // NOW YOU DON'T HAVE PASS THE REF IN/OUT METHODS

 	public static void main(String[] args) throws Exception
	{
		int[] dropInPt = new int[2]; // row and col will be on the 2nd line of input file;
		swamp = loadSwamp( args[0], dropInPt );
		int row=dropInPt[0], col = dropInPt[1];
		String path = ""; // with each step grows to => "[2,3][3,4][3,5][4,6]" etc
		dfs( row, col, path );
	} // END MAIN

 	// JUST FOR YOUR DEBUGGING - DELETE THIS METHOD AND ITS CALL BEFORE HANDIN
	// ----------------------------------------------------------------
	private static void printSwamp(String label, int[][] swamp )
	{
		System.out.println( label );
		System.out.print("   ");
		for(int c = 0; c < swamp.length; c++)
			System.out.print( c + " " ) ;
		System.out.print( "\n   ");
		for(int c = 0; c < swamp.length; c++)
			System.out.print("- ");
		System.out.print( "\n");

		for(int r = 0; r < swamp.length; r++)
		{	System.out.print( r + "| ");
			for(int c = 0; c < swamp[r].length; c++)
				System.out.print( swamp[r][c] + " ");
			System.out.println("|");
		}
		System.out.print( "   ");
		for(int c = 0; c < swamp.length; c++)
			System.out.print("- ");
		System.out.print( "\n");
	}
	// --YOU-- WRITE THIS METHOD 
	// (you may copy from YOURSELF from YOUR lab7 not someone else's)
   	// ----------------------------------------------------------------
	private static int[][] loadSwamp( String infileName, int[] dropInPt  ) throws Exception
	{
		int[][] theSwamp;
		File file= new File(infileName);
		Scanner infile = new Scanner(file);
		int dimension = infile.nextInt();
		theSwamp = new int[dimension][dimension];
		dropInPt[0]=infile.nextInt();
		dropInPt[1]=infile.nextInt();
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
			theSwamp[i][j]=infile.nextInt();	
			}	
		}
		return theSwamp;
	}

	static void dfs( int row, int col, String path ) // dfs = DEPTH FIRST SEARCH
	{
		//StringBuilder SB = new StringBuilder("");
		//SB.append("["+row+","+col + "]");
		path = path + ("["+row+","+col + "]");
		//System.out.println(SB.toString());
		if(onEdge(row, col)){
			System.out.print(path);
			System.out.println("");
			return;
		}
		
		if (swamp[row-1][col] == 1) 	// TRY NORTH
			{
				swamp[row][col]=-1;
				dfs(row-1,col,path);
				swamp[row][col]= 1;
			}
			if (swamp[row-1][col+1]==1)
			{
				swamp[row][col]=-1;
				dfs(row-1,col+1,path);
				swamp[row][col]= 1;
			}
			if (swamp[row][col+1] == 1)
			{
				swamp[row][col]=-1;
				dfs(row,col+1,path);
				swamp[row][col]= 1;
			}
			if (swamp[row+1][col+1] == 1)
			{
				swamp[row][col]=-1;
				dfs(row+1,col+1,path);
				swamp[row][col]= 1;
			}	
			if (swamp[row+1][col] == 1)
			{
				swamp[row][col]=-1;
				dfs(row+1,col,path);
				swamp[row][col]= 1;
			}
			if (swamp[row+1][col-1] == 1)
			{
				swamp[row][col]=-1;
				dfs(row+1,col-1,path);
				swamp[row][col]= 1;
			}
			if (swamp[row][col-1] == 1)
			{
				swamp[row][col]=-1;
				dfs(row,col-1,path);
				swamp[row][col]= 1;
			}
			if (swamp[row-1][col-1] == 1)
			{
				swamp[row][col]=-1;
				dfs(row-1,col-1,path);
				swamp[row][col]= 1;
			}
				
			return;
	}	
	static boolean onEdge(int r, int c ) // RET TRUE IF ON EDGE OF SWAMP
	{
		return r==0 || r==swamp.length-1 || c ==0 || c==swamp.length-1;
	}
}
