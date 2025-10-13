// CMPINF 0401 Lab 9 Driver Program
// Compile and run this program to test your MySquare class.
// Compare the output of your program with the provided file 
// lab9out.txt

public class Lab9
{
	// Note that this method has a MyRectangle parameter.   This should allow
	// it to work with the MyRectangle class or the MySquare class (because
	// MySquare ISA MyRectangle).  In other words, it only works with MySquare
	// because MySquare is a subclass of MyRectangle.  Finally, note that the
	// isInside() method can be used as is from MyRectangle -- you do not have
	// to redefine it for MySquare
	public static void showRec(MyRectangle R, int width, int height)
	{
		for (int i = 0; i < height; i++)
		{
			for (int j = 0; j < width; j++)
			{
				if (R.isInside(i, j))
					System.out.print("+");
				else
					System.out.print("-");
			}
			System.out.println();
		}
	}
	
	public static void main(String [] args)
	{
		MySquare S1, S2, S3;

		// Note the MySquare constructors.  You must write these.
		S1 = new MySquare(10, 20, 25);
		S2 = new MySquare();
		S3 = new MySquare(0, 0, 150);
 
 		// The area() should be inherited -- you should not redefine it.  However
 		// you must redefine the toString() method so that it outputs properly.
		System.out.println("S1: " + S1 + " Area: " + S1.area());
		System.out.println("S2: " + S2 + " Area: " + S2.area());
		System.out.println("S3: " + S3 + " Area: " + S3.area());

		showRec(S1, 80, 50);
		
		System.out.println();
		S1.setSide(15);  		// new method in MySquare class
		S1.setPosition(0, 0);   // inherited method
		
		System.out.println("S1: " + S1 + " Area: " + S1.area());
		showRec(S1, 80, 50);
		
		// The setSize() method is inherited from MyRectangle but as given it is
		// incorrect since the width and height can be assigned to different values.
		// Thus you should redefine the same method (with the same header) in the
		// MySquare class so that it makes the assignment only if the width and height
		// are the same (since the object is a square).  This is called method
		// overriding.
		
		S1.setSize(20, 40);  // see error message output for this method
		System.out.println("S1: " + S1 + " Area: " + S1.area());
		S1.setSize(20, 20);
		System.out.println("S1: " + S1 + " Area: " + S1.area());
		System.out.println();
		
		// Since MySquare isA MyRectangle we can access it using a MyRectangle reference.
		System.out.println("Using a MyRectangle ref to store a MySquare...");
		MyRectangle R = new MySquare(5, 15, 25);
		System.out.println("R: " + R + " Area: " + R.area());
		// New version of setSize still is called since it matches the header in the
		// original MyRectangle class -- this is method overriding.
		R.setSize(10, 40);  // see error message output for this method
		System.out.println("R: " + R);
		System.out.println();
		System.out.println("Now calling setSize with equal sides...");
		R.setSize(30, 30);
		System.out.println("R: " + R);
		// R.setSide(50);  // This will not work since setSide was added in MySquare
	}
}

