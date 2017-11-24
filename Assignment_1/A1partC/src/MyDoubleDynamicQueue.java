
public class MyDoubleDynamicQueue<T> implements MyQueue<T> {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	private MyDoubleLinkedNode<T> head;
	private MyDoubleLinkedNode<T> tail;

	public MyDoubleLinkedNode<T> getHead() {
		return head;
	}

	public void setHead(MyDoubleLinkedNode<T> head) {
		this.head = head;
	}

	public MyDoubleLinkedNode<T> getTail() {
		return tail;
	}

	public void setTail(MyDoubleLinkedNode<T> tail) {
		this.tail = tail;
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Check if myQueue is empty: myCreateEmpty
	//-------------------------------------------------------------------	
	public MyDoubleDynamicQueue(){
		setHead(null);
		setTail(null);
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Check if myQueue is empty: isEmpty
	//-------------------------------------------------------------------	
	public boolean isEmpty(){
		if(getHead() == null && getTail() == null) {
			return true;
		}
		else {
			return false;
		}
	}

	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Get first element from front of MyQueue: first
	//-------------------------------------------------------------------
	public T first(){
		if(getHead() != null){
			return getHead().getInfo();
		}
		else{
			System.out.println("Can't Get FIRST element, As myQueue is empty");
			return null;
		}
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Add element to back of MyQueue: addByFirst 
	//-------------------------------------------------------------------
	public void addByFirst(T element){
		MyDoubleLinkedNode<T> node = new MyDoubleLinkedNode<T>(null, element, getHead());
		if(getHead() != null){
			getHead().setLeft(node);
		}
		setHead(node);
		if(getTail() == null){
			setTail(node);
		}
	}

	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Remove element from front of MyQueue: removeByFirst 
	//-------------------------------------------------------------------	
	public void removeByFirst(){

		if(getHead() == null){
			System.out.println("Unable to remove First element as myQueue is empty");
		}
		else{
			if(getHead().getRight() != null) {
				getHead().getRight().setLeft(null);
				setHead(getHead().getRight());
			}
			else {
				setHead(null);
				setTail(null);
			}
		}

	}

	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Get first element from front of MyQueue: last
	//-------------------------------------------------------------------
	public T last(){

		if(getTail() != null){
			return getTail().getInfo();
		}
		else{
			System.out.println("Can't Get LAST element, As myQueue is empty");
			return null;
		}
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Add element to back of MyQueue: addByLast 
	//-------------------------------------------------------------------
	public void addByLast(T element){
		MyDoubleLinkedNode<T> node = new MyDoubleLinkedNode<T>(getTail(), element, null);
		if(getTail() != null){
			getTail().setRight(node);
		}
		setTail(node);
		if(getHead() == null){
			setHead(node);
		}
	}

	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Remove element from front of MyQueue: removeByFirst 
	//-------------------------------------------------------------------	
	public void removeByLast(){

		if(getTail() == null){
			System.out.println("Unable to remove LAST element as myQueue is empty");
		}
		else{
			if(getTail().getLeft() != null) {
				getTail().getLeft().setRight(null);
				setTail(getTail().getLeft());
			}
			else {
				setTail(null);
				setHead(null);
			}
		}
	}

	public void printList(){
		MyDoubleLinkedNode<T> node = getHead();
		if(node != null) {
			System.out.print("\nitems left to right = [");
			while (node != null) {
				System.out.print(node.getInfo());
				node = node.getRight();
				if(node != null) {
					System.out.print(", ");
				}
				else {
					System.out.print("]\n");
				}
			}
		}
		else{
			System.out.println("LEFT TO RIGHT, List is empty");
		}
		node = getTail();
		if(node != null) {
			System.out.print("\nitems Right to left = [");
			while (node != null) {
				System.out.print(node.getInfo());
				node = node.getLeft();
				if(node != null) {
					System.out.print(", ");
				}
				else {
					System.out.print("]\n\n");
				}
			}
		}
		else{
			System.out.println("RIGHT TO LEFT, List is empty");
		}

	}

}
