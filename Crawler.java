import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler
{
	private String start; //string to hold the starting URL
	private int maxSize = -1; //int to control the maxSize of the queue. If -1, queue is unlimited
	
	
	public void setStart(String inStart) //mutator method that sets the starting URL
	{
		start = inStart;
	}
	
	public void setSize(int inSize) //mutator method that sets the max size of the queue
	{
		maxSize = inSize;
	}
	
	public void goQ() throws IOException
	{
		Queue queue = new Queue(); //initializes the queue
		
		if(maxSize != -1) //sets the max size of the queue
		{
			queue.setSize(maxSize);
		}
		
		Document doc = Jsoup.connect(start).get(); //gets URLs from the start page
    	Elements links2follow = doc.select("a[href]"); //creates an Elements object which contains all of the child links from the start page
		
		if(queue.getHead() == null) //if the queue is empty, set the head of the queue to the start page
		{
			Node<String> startURL = new Node<String>(this.start, null); //creates node with the start page as the data
			queue.enqueue(startURL); //adds the node to the queue
			
			System.out.println(startURL.getData()); //prints the URL of the start page
		}
			
		while(queue.getHead() != null) //while the queue isn't empty
		{
			if(queue.getHead().getData().equals(start)) //if the head of the queue contains the start page
			{	
				queue.dequeue(); //removes the start page node from the queue
			    for(Element link: links2follow)//for each loop that runs for every child link there is in links2follow
			    {
			    	if(link.attr("href").contains("311"))//if the child link is within our domain
			    	{
				    	if(maxSize == queue.getSize()) //breaks from the for each loop if the queue is full
			    		{
			    			break;
			    		}
				    	
			    		Node<String> temp = new Node<String>(); //creates a temp node
			    		temp.setData(link.attr("abs:href")); //sets the new node's data to the child link
			    		queue.enqueue(temp); //adds the new node to the queue
			    		System.out.println(link.attr("abs:href")); //prints out the child link
			    	}
			   	}
			}
			
			else//if the head of the queue is not the start page
			{
				doc = Jsoup.connect((String)queue.getHead().getData()).get(); //gets URLs from the head of the queue
				links2follow = doc.select("a[href]");//creates an Elements object which contains all of the child links from the head
			    
				queue.dequeue(); //removes the head from the queue
				for(Element link: links2follow)//goes through all the links, adds them to the queue, then prints them
				{
				    if(link.attr("href").contains("311"))//if the child link is within our domain
				    {
				    	if(maxSize == queue.getSize())//breaks from the for each loop if the queue is full
			    		{
			    			break;
			    		}
				    	
			    		Node<String> temp = new Node<String>(); //creates a temp node
			    		temp.setData(link.attr("abs:href")); //sets the new node's data to the child link
			    		queue.enqueue(temp); //adds the new node to the queue
			    		System.out.println(link.attr("abs:href")); //prints out the child link
				    }
				}
			}
		}
	}
	
	public void goS() throws IOException
	{
		Stack stack = new Stack(); //creates new stack
		Document doc = Jsoup.connect(start).get(); //gets URLs from the start page
    	Elements links2follow = doc.select("a[href]"); //creates an Elements object which contains all of the child links from the start page
		
		if(stack.getHead() == null) //if the head is null, add the start page to the stack
		{
			Node<String> startURL = new Node<String>(this.start, null);
			stack.push(startURL);
		}
			
		while(stack.getHead() != null)//runs until the stack is empty
		{
			if(stack.getHead().getData().equals(start))//if the head of the stack is the start page
			{	
				System.out.println(stack.getHead().getData()); //print the start page
				stack.pop(); //remove the start page from the queue
				
			    for(Element link: links2follow)//for each link in links2follow, add a new Node to the stack
			    {
			    	if(link.attr("href").contains("311"))
			    	{
			    		Node<String> temp = new Node<String>();
			    		temp.setData(link.attr("abs:href"));
			    		stack.push(temp);
			    	}
			   	}
			}
			
			else //if the head is not the start page
			{
				doc = Jsoup.connect((String)stack.getHead().getData()).get(); //gets the URLs from the parent Node
				links2follow = doc.select("a[href]"); //adds the URLs to the links2follow object
				
		    	System.out.println(stack.getHead().getData()); //print out the top of the stack
				stack.pop(); //remove the top of the stack
				
				for(Element link: links2follow)//goes through all the links, adds them to the queue, then prints them
				{
				    if(link.attr("href").contains("311")) //if the link is within our domain
				    {
				    	Node<String> temp = new Node<String>(); //creates a temp node to hold the link
				    	temp.setData(link.attr("abs:href")); //sets the data of temp to the current url
				    	stack.push(temp); //adds the node to the stack
				    }
				}
			}
		}
	}
}
