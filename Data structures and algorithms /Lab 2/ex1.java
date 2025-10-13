/* CMPINF 0401 Fall 2022 Java Example 1
   This handout demonstrates a very simple Java program just to show
   the main program structure.

   Comments in Java can be indicated in two ways -- using the opening
   and closing delimiters as shown here for multi-line comments, and
   using two slashes as shown below for single-line comments
   
   Important General Note:  There will be many handouts assigned throughout
   the term.  Please read these very carefully (including the comments) and
   run them several times under are variety of circumstances.  These handouts
   are a very important part of the course materials.
*/
public class ex1   // Every program in Java must be embedded within a class,
{                 // even if we are not programming in an object-oriented
	              // way.  For these early handouts, the class will just be
	  //  a way of encapsulating all of the code for each of our programs.

      // Every stand-alone Java program needs a main method (function).  We
	  // will talk more about the keywords used (public static void) later.
	  // For now just remember that the main method declaration should be
	  // formatted as shown below.

	  // Execution always begins in the main.

	  // As with most languages, Java has a number of keywords.  Many editors
	  // show keywords in a special way (ex: bold, in a different color).
	  // Some Java keywords shown here include public, class, static and void.
	  // Keywords cannot be used for any other purpose in a program (ex: you
	  // cannot use a keyword as a variable name).

	  // Some predefined identifiers in this program are String, System, out and
	  // print
	  
	  // Some programmer defined identifiers in this program are ex1, args
	  // and wacky

      public static void main (String [] args)
	  {
	  	   int wacky = 8;
		   System.out.print("Java is awesome by a factor of " + wacky + "\n");
		   System.out.println("You entered " + args[0] + " and " + args[1]);
		   // Java output can be done using I/O streams (later), using
		   // graphics (maybe later) or using simple console methods as shown
		   // here.  A predefined class called "System" contains a predefined
	       // object called "out".  The "out" object can execute many methods,
		   // including the "println" method shown above.  The way this works
		   // will make more sense to you once we have covered object-oriented
		   // programming.  For now, just remember the syntax.
      }
}
