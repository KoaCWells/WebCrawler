import java.io.IOException;

class main
{
	public static void main(String[] args) throws IOException 
	{
		Crawler daCrawlers = new Crawler(); //creates a new crawler object
		
		daCrawlers.setStart("http://www.cse.uaa.alaska.edu/~mcenek/csce311/"); //sets the start page
		
		System.out.println("Unlimited Queue");
		daCrawlers.goQ(); //runs the crawler with a queue of unlimited size
		
		System.out.println("");
		System.out.println("Limited Queue");
		daCrawlers.setSize(3); //runs the crawler with a queue of size 3
		daCrawlers.goQ();
		
		System.out.println("");
		System.out.println("Stack");
		daCrawlers.goS(); //runs the crawler with a stack
	}
}
