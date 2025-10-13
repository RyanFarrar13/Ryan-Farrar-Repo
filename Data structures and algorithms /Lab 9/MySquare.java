import java.util.Scanner;

public class MySquare extends MyRectangle{
	
	public MySquare(){
		 width = 0;
        height = 0;
        startX = 0;
        startY = 0;
		
	}
public MySquare(int x, int y, int side){
	startX = x;
	startY = y;
	int WA = side;
	width = WA;
	height = WA;
	
}
// Constructors to allow new objects to be created. x and y are the
// location coordinates and size is the side length
public String toString(){
	  StringBuilder S = new StringBuilder();
        S.append("Side: " + width);
        S.append(" X: " + startX);
        S.append(" Y: " + startY);
        return S.toString();
	
}
// Redefining toString(). See output for effect.
public void setSize(int w, int h){
	int WW = w;
	int HH = h;
	if(WW!=HH){
		System.out.println("Cannot assighn a square different widths and heights.");
	}
	else{
		width = WW;
		height = WW;
	}
}
// Redefining setSize(). This must be done because the inherited version
// allows the width and height to differ but in a square they must be the
// same. In this version, if the width and height are not the same, the
// method should output a message and not change anything.
public void setSide(int side){
	int Side = side;
	width = Side;
	height = Side;
}
// This is a new method that updates that size of the square. Think about
// how this will be implemented using the existing inherited instance vars.

	
	
	
	
	
	
	
	
}