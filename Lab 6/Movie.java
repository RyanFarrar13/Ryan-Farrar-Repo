// CMPINF 0401 Lab 6 Movie class
import java.text.*;
import java.util.*;
public class Movie
{
	// Note the private instance variables
	private String title;
	private String director;
	private String studio;
	private double gross;

	// Constructor -- take 4 arguments and make a new Movie.  Note
	// the order of the parameters.
	public Movie(String t, String d, String s, double g)
	{
		title = new String(t);
		director = new String(d);
		studio = new String(s);
		gross = g;
	}

	// Return a formatted string version of this Movie.  This can be used
	// to display a Movie to a program user.
	public String toString()
	{

		StringBuffer B = new StringBuffer();
		B.append("Title: " + title + "\n");
		B.append("Director: " + director + "\n");
		B.append("Studio: " + studio + "\n");
		NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
		B.append("Gross: " + formatter.format(gross) + "\n");
		return B.toString();
	}

	// Return an unformatted string version of this Movie, with
	// newlines between items.  This will be used to save a text 
	// version of the Movie to a file.
	public String toStringFile()
	{
		StringBuffer B = new StringBuffer();
		B.append(title + "\n");
		B.append(director + "\n");
		B.append(studio + "\n");
		B.append(gross + "\n");
		return B.toString();
	}

	// Accessor to return title of this Movie
	public String getTitle()
	{
		return title;
	}
}
