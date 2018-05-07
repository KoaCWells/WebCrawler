
public class Stack
{
	private Node<String> head = new Node<String>(); //creates head node
	
	Stack() //default contructor
	{
		head = null;
	}
	
	public void push(Node<String> newNode)//adds nodes to the stack
	{
		if(head == null) //if the head is null, set head equal to newNode
		{
			head = newNode;
		}
		
		else //if the head is not null, add newNode to the top of the Stack
		{
			Node<String> temp = head;
			head = newNode;
			head.setNext(temp);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void pop()//removes nodes from the stack
	{
		if(head == null) //if the stack is empty, print error
		{
			System.out.println("The list is empty, nothing to pop.");
		}
		
		else //if the stack isn't empty, add the newNode to the top of the stack
		{
			head = head.getNext();
		}
	}
	
	public Node<String> getHead() //returns the head/accessor method
	{
		return this.head;
	}
}
