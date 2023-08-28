// CMPINF 0401 Fall 2022
// Main program for In-class Exercise.  See comments below

public class CounterTest
{
	public static void main(String [] args)
	{
		// Counter constructor contains 1 argument, for the array size.
		Counter C1 = new Counter(2);  // array has 2 digits
		Counter C2 = new Counter(5);  // array has 5 digits
		
		// Increment should always start with the least significant
		// digit, but could end up affecting all of the digits (if
		// we need a "carry".  So far no carry is needed.
		for (int i = 1; i <= 9; i++)
		{
			C1.increment();
			C2.increment();
		}
		
		// Note that all digits are shown, even leading 0s
		System.out.println(C1.toString());
		System.out.println(C2.toString());
		System.out.println();

		C1.increment();  // carry to next dig and first dig is 0
		C2.increment();	 // carry to next dig and first dig is 0	
		
		System.out.println(C1.toString());
		System.out.println(C2.toString());
		System.out.println();
		
		for (int i = 1; i <= 89; i++) 	// after this a total of 99
		{								// increments will have been
			C1.increment();				// made.  This will "max out"
			C2.increment();				// C1, since it has 2 digits
		}

		System.out.println(C1.toString());
		System.out.println(C2.toString());
		System.out.println();
		
		C1.increment();	 // no more digits -- overflow
		C2.increment();	 // use the next digit
		
		System.out.println(C1.toString());
		System.out.println(C2.toString());
		System.out.println();
		
		// Reset all digits back to 0s
		C1.reset();  C2.reset(); 
		
		System.out.println(C1.toString());
		System.out.println(C2.toString());
	}
}