public class Node<T>{
	
	private T data;
	private Node<T> next;

	public Node() //default constructor
	{
		data = null;
		next = null;
	}


	public Node(T inData, Node<T> inNext) //constructor
	{
		data = inData;
		next = inNext;
	}

	//accesors
	public T getData()
	{
		return data;
	}

	@SuppressWarnings("unchecked")
	public Node<T> getNext()
	{
		return next;
	}

	//mutators
	public void setData(T inData)
	{
		data = inData;
	}

	public void setNext(Node<T> inNext)
	{
		next = inNext;
	}
}