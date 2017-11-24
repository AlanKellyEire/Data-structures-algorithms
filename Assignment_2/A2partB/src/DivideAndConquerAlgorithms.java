
/**
 * The class contains the Divide and Conquer-based Algorithms we are using. 
 */
public class DivideAndConquerAlgorithms {

	//----------------------------------------------
	// Class constructor
	//----------------------------------------------	
	/**
	 * Constructor of the class. Do not edit it.
	 */
	public DivideAndConquerAlgorithms(){}

	//-------------------------------------------------------------------
	// 0. iterativeDisplayElements --> Displays all elements of a MyList 
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, this iterative algorithm displays its elements by screen (if any).
	 * @param m: The MyList we want to display its elements.	  
	 */	
	public void iterativeDisplayElements(MyList<Integer> m){
		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 

		//Rule 1. MyList is empty
		if (m.length() == 0) 
			scenario = 1;
		//Rule 2. MyList is non-empty
		else
			scenario = 2;

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	

		//Rule 1. MyList is empty
		case 1: 
			//1. We print the empty message
			System.out.println("Empty MyList");

			break;

			//Rule 2. MyList is non-empty
		case 2: 
			//1. We print the initial message
			int size = m.length();
			System.out.println("MyList Contains the following " + size + " items: ");

			//2. We traverse the items
			for (int i = 0; i < size; i++)
				System.out.println("Item " + i + ": " + m.getElement(i));

			break;

		}

	}

	//-------------------------------------------------------------------
	// 1. recursiveDisplayElements --> Displays all elements of a MyList  
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, this recursive algorithm displays its elements by screen (if any).
	 * @param m: The MyList we want to display its elements.	  
	 */	
	public void recursiveDisplayElements(MyList<Integer> m){

		if(m == null) {
			//do not	hing
		}
		else {
			if (m.length() <= 0) {
				//do nothing
				p("");
			}
			else {
				int e0 = m.getElement(0);
				
				//2. We remove the first element from MyList we just checked
				m.removeElement(0);

				//3. We recursively solve the smaller problem
				recursiveDisplayElements(m);
				pNl(" " + e0);
				//4. We compute the final result, based on the value that we were hosting.
				
				m.addElement(0, e0);
			}
		}

	}
	//-------------------------------------------------------------------
	// 2. smallerMyList --> Filters all elements in MyList smaller than e
	//-------------------------------------------------------------------	
	/**
	 * The function filters all elements of MyList being smaller than 'e'  
	 * @param m: The MyList we want to check.
	 * @param e: The number 'e' we want to compare each element of MyList to.
	 * @return: The new MyList containing just the elements being smaller than 'e'  
	 */	
	public MyList<Integer> smallerMyList(MyList<Integer> m, int e){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res = null;
	

		if (m.length() <= 0) {
			return res;
		}
		else{


			int elem0 = m.getElement(0);
			m.removeElement(0);
			res = smallerMyList(m, e);
			m.toString();
			if(res != null) {
				if(elem0 < e) {
					res.addElement(0, elem0);

				}
			}
			else {
				if(elem0 < e) {
					res = new MyDynamicList<Integer>();
					res.addElement(0, elem0);

				}
			}
			m.addElement(0, elem0);
			return res;
		}

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------


		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		

	}

	//-------------------------------------------------------------------
	// 3. biggerMyList --> Filters all elements in MyList bigger than e
	//-------------------------------------------------------------------	
	/**
	 * The function filters all elements of MyList being bigger than 'e'  
	 * @param m: The MyList we want to check.
	 * @param e: The number 'e' we want to compare each element of MyList to.
	 * @return: The new MyList containing just the elements being bigger or equal than 'e'  
	 */	
	public MyList<Integer> biggerEqualMyList(MyList<Integer> m, int e){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res = null;
		

		if (m.length() <= 0) {
			return res;
		}
		else{


			int elem0 = m.getElement(0);
			m.removeElement(0);
			res = biggerEqualMyList(m, e);
			//m.toString();
			if(res != null) {
				if(elem0 >= e) {
					res.addElement(0, elem0);

				}
			}
			else {
				if(elem0 >= e) {
					res = new MyDynamicList<Integer>();
					res.addElement(0, elem0);

				}
			}
			m.addElement(0, elem0);
			return res;
		}
	}

	//-------------------------------------------------------------------
	// 3. concatenate --> It concatenates 2 MyList   
	//-------------------------------------------------------------------	
	/**
	 * The function concatenates the content of 2 MyList.   
	 * @param m1: The first MyList.
	 * @param m2: The second MyList.
	 * @return: The new MyList resulting of concatenate the other 2 MyList
	 */	
	public MyList<Integer> concatenate(MyList<Integer> m1, MyList<Integer> m2){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res = null;
		//testing if m1 = 0 and m2 >0 if true then res = m2. if false. test if m2 <= 0 and m1 > 0 and if true res = m1 else res = null
		res = m1.length() <= 0 && m2.length() >= 0 ? m2 : m1.length() >= 0 && m2.length() <= 0  ? m1 : null;
		
		if(res == null) {
			res = new MyDynamicList<Integer>();
			int size = m2.length() - 1;
			int auxE = 0;
			
			while (size >= 0){
				//2.1. We access to the element in m2
				auxE = m2.getElement(size);
				
				//2.2. We append the element to res
				res.addElement(0, auxE); 
				
				//2.3. We decrease the index of size
				size--;
			}
			
			size = m1.length() - 1;
			while (size >= 0){
				//2.1. We access to the element in m1
				auxE = m1.getElement(size);
				
				//2.2. We append the element to res
				res.addElement(0, auxE); 
				
				//2.3. We decrease the index of size
				size--;
			}
			
		}

		return res;
	}

	//prints string and ends with new line
	public void p(String s) {
		System.out.println("" + s);
	}


	//prints string
	public void pNl(String s) {
		System.out.print("" + s);
	}

}
