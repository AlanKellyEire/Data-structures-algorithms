
public class MyDynamicQueue implements MyQueue {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	private MyNode head;

	public MyNode getHead() {
		return head;
	}

	public void setHead(MyNode head) {
		this.head = head;
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Check if MyQueue is empty: myCreateEmpty
	//-------------------------------------------------------------------		
	public MyDynamicQueue(){
		setHead(null);

	}

	//-------------------------------------------------------------------
	// Basic Operation --> Check if MyQueue is empty: isEmpty
	//-------------------------------------------------------------------	
	public boolean isEmpty(){
		if(getHead() == null) {
			return true;
		}
		else {
			return false;
		}
	}

	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Get first element from front of MyQueue: first
	//-------------------------------------------------------------------
	public int first(){
		if(getHead() != null){
			return head.getInfo();
		}
		else{
			System.out.println("Fails! No first element as myQueue is empty");
			return -1;
		}
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Add element to back of MyQueue: add 
	//-------------------------------------------------------------------
	public void add(int element) {
		MyNode node = null;
		if (getHead() == null) {
			setHead(new MyNode(element, null));
			//System.out.println("added element 3");
		}
		else {
			if(head.getNext() != null) {
				node = head.getNext();
				while (node.getNext() != null) {
					
					if (node.getNext() != null) {
						node = node.getNext();
					}
				}
			}
			else {
				head.setNext(new MyNode(element, null));
			}
			if (node != null) {
				node.setNext(new MyNode(element, null));
			}
		}
	}

	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Remove element from front of MyQueue: remove 
	//-------------------------------------------------------------------	
	public void remove() {
		if (head != null) {
			
			if (head.getNext() != null) {
				setHead(head.getNext());
			} else {
				setHead(null);
			}
		}
		else if(head == null){
			System.out.println("Fails, myQueue is already empty");
		}
	}

}
