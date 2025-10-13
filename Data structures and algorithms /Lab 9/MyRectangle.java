import java.util.Scanner;
// CMPINF 0401 Lab4
// Fill in the indicated code sections to complete this class.  Then test it
// by compiling and executing Lab4.java.

public class MyRectangle
{
    // Declare instance variables here
        protected int width;
        protected int height;
        protected int startX, startY;
          
         
    
    public MyRectangle()
    {
        // Default constructor -- initialize all instance variables
        // to 0
        width = 0;
        height = 0;
        startX = 0;
        startY = 0;
    }

    public MyRectangle(int x, int y, int w, int h)
    {
        // Initialize instance variables based on parameters shown.
        // Be careful to get the order correct!
        startX = x;
        startY = y;
        width = w;
            height = h;
    }

    public int area()
    {
        // Return the area of this Rectangle
        int area = width * height;
        return area;        
    }

    // I have written this method for you.  Note how a StringBuilder is
    // utilized, since (as we discussed in lecture) it can be modified
    // without having to create a new object each time (unlike a String).
    // Note that this method does NOT print any output to the display.
    // Rather it returns a String with content that COULD be sent to the
    // display if desired.  Make sure you are aware of that distinction.
    public String toString()
    {
        StringBuilder S = new StringBuilder();
        S.append("Width: " + width);
        S.append(" Height: " + height);
        S.append(" X: " + startX);
        S.append(" Y: " + startY);
        return S.toString();
    }

    public boolean isInside(int x, int y)
    {
        // This is the trickiest of the methods to write.  This should
        // return true if point (x,y) is anywhere within the borders of the
        // current MyRectangle (including the borders themselves).  Use a
        // pencil and paper to figure out how this can be determined with
        // just a few simple relational operations.
        boolean isInside = (x>=0 && y<=0);
        return isInside;
        
    }

    public void setSize(int w, int h)
    {
        width = w;
        height = h;
        
        
    }

    public void setPosition(int x, int y)
    {
        // Update startX and startY as shown
        startX = x;
        startY = y;
        
    }

    
    
    
    
    
    
    
    
    
    
    public static void testInside(MyRectangle R, int x, int y)
    {
        System.out.print("Point (" + x + "," + y + ")");
        if (R.isInside(x, y))
            System.out.println(" is INSIDE " + R);
        else
            System.out.println(" is OUTSIDE " + R);
    }

    public static void main(String [] args)
    {
        MyRectangle R1, R2, R3;

        R1 = new MyRectangle(100, 50, 80, 20);
        R2 = new MyRectangle();
        R3 = new MyRectangle(60, 60, 100, 100);
 
        // In Java, when Objects are printed (as shown below), the toString()
        // method is implicitly called.  Thus the statements below will call
        // toString() for each of the three MyRectangle objects
        System.out.println("R1: " + R1 + " Area: " + R1.area());
        System.out.println("R2: " + R2 + " Area: " + R2.area());
        System.out.println("R3: " + R3 + " Area: " + R3.area());

        int x1 = 120, y1 = 70;
        int x2 = 130, y2 = 110;

        // Verify with a pencil and paper which of these should be true and
        // which should be false.
        testInside(R1, x1, y1);
        testInside(R3, x1, y1);
        testInside(R1, x2, y2);
        testInside(R3, x2, y2);

        System.out.println("Mutating some objects...note that the testInside results");
        System.out.println("have changed due to the mutations.");
        R1.setSize(120, 240);
        R3.setPosition(400, 350);
        testInside(R1, x2, y2);
        testInside(R3, x2, y2);
    }

}







//e