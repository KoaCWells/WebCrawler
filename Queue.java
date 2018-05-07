
public class Queue 
{
	private Node<String> head = new Node<String>(); //creates head node
	private int size = 0; //creates size int for keeping track of the size of the queue
	private int maxSize = -1; //creates maxSize, if the maxSize is equal to -1, then the queue is unlimited
	
	Queue() //default contructor
	{
		head = null;
	}

	@SuppressWarnings("unchecked")
	public void enqueue(Node<String> newNode)
	{
		if(size == maxSize)//if the queue is full, print error
		{
			System.out.println("Queue full.");
		}
		
		else //if queue is not full
		{
			if(head == null) //if the head is null, set the head to the newNode
			{
				head = newNode;
			}
		
			else //if the head isn't null, add the newNode to the end of the queue
			{
				Node<String> current = head;
			
				while(current.getNext() != null)
				{
					current = current.getNext();
				}
			
				current.setNext(newNode);
			}
			size++; //increments size 1 each time a node is added to the queue
		}
	}
	
	@SuppressWarnings("unchecked")
	public void dequeue()//removes nodes from the queue
	{
		if(head == null)//if the queue is empty, print error
		{
			System.out.println("The list is empty, nothing to pop.");
		}
		
		else if(head.getNext() == null) //if the queue only has a head, set the head to null
		{
			head = null;
			size--; //decrements the size of the queue by 1
		}
		
		else //if the queue has two or more nodes, remove the current head by setting the head to the next node in the queue
		{
			head = head.getNext();
			size--; //decrements the size of the queue by 1
		}
	}
	
	public Node<String> getHead() //accessor method that returns the head of the queue
	{
		return this.head;
	}
	
	public void setSize(int inMaxSize) //mutator method that sets the max size of the queue
	{
		maxSize = inMaxSize;
	}
	
	public int getSize() //accessor method that returns the current size of the queue
	{
		return size;
	}
}
