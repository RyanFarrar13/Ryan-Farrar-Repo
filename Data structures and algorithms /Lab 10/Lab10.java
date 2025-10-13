// CS 0401 Fall 2022
// Driver Program for Lab10.   This program should run with the supplied
// SimpleDeque interface and the MyDeque class that you complete.

public class Lab10
{
	public static void main(String [] args)
	{
		SimpleDeque things = new MyDeque(8);

		doStack(things);
		
		if (!things.isEmpty())
		{
			System.out.println("Uh oh -- not empty 1!");
			things = new MyDeque(8);
		}
			
		doQueue1(things);
		
		if (!things.isEmpty())
		{
			System.out.println("Uh oh -- not empty 2!");
			things = new MyDeque(8);
		}
		
		doQueue2(things);

		if (!things.isEmpty())
		{
			System.out.println("Uh oh -- not empty 3!");
		}

	}

	public static void doQueue1(SimpleDeque S)
	{
		System.out.println("Queue adds at rear and removes at front");
		for (int i = 0; i < 5; i++)
			S.addRear(new Integer(i));
		Object item = S.removeFront();
		while (item != null)
		{
			System.out.print(item + " ");
			item = S.removeFront();
		}
		System.out.println();
		System.out.println();
	}

	public static void doQueue2(SimpleDeque S)
	{
		System.out.println("Queue adds at front and removes at rear");
		for (int i = 0; i < 10; i++)
			S.addFront(new Double(2*i));
		Object item = S.removeRear();
		while (item != null)
		{
			System.out.print(item + " ");
			item = S.removeRear();
		}
		System.out.println();
		System.out.println();
	}

	public static void doStack(SimpleDeque S)
	{
		System.out.println("Stack adds and removes at rear");
		String [] names = {"Herb", "Bertha", "Ingrid", "Ingmar", "Marge"};
		for (int i = 0; i < names.length; i++)
			S.addRear(names[i]);
		Object item = S.removeRear();
		while (item != null)
		{
			System.out.print(item + " ");
			item = S.removeRear();
		}
		System.out.println();
		System.out.println();
	}
}
