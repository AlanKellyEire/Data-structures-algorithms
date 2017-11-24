
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
	public DivideAndConquerAlgorithms() {
	}

	//-------------------------------------------------------------------
	// 0. iterativeDisplayElements --> Displays all elements of a MyList 
	//-------------------------------------------------------------------	

	/**
	 * Given a concrete MyList, this iterative algorithm displays its elements by screen (if any).
	 *
	 * @param m: The MyList we want to display its elements.
	 */
	public void iterativeDisplayElements(MyList<Integer> m) {
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
		switch (scenario) {

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
	// 1. maxInt --> Computes the maximum item of MyList 
	//-------------------------------------------------------------------	

	/**
	 * The function computes the maximum item of m (-1 if m is empty).
	 *
	 * @param m: The MyList we want to compute its maximum item.
	 * @return: The maximum item of MyList
	 */
	public int maxInt(MyList<Integer> m) {
		int max = 0;
		if (m.length() != 0) {
			int cur = m.getElement(0);

			m.removeElement(0);
			int next = maxInt(m);
			if (next > cur) {
				max = next;
			} else {
				max = cur;
			}

			//5. We also add the element back to m, so as to not to modify its original state
			m.addElement(0, cur);

			return max;
		} else {
			return -1;
		}

	}

	//-------------------------------------------------------------------
	// 2. isReverse --> Computes if MyList is sorted in decreasing order 
	//-------------------------------------------------------------------	

	/**
	 * The function computes whether m is sorted in decreasing order or not.
	 *
	 * @param m: The MyList we want to check.
	 * @return: Whether m is sorted in decreasing order or not.
	 */
	public boolean isReverse(MyList<Integer> m) {

		boolean res = true;

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;

		//Rule 1. MyList is empty or contains just one element
		if (m.length() <= 1)
			scenario = 1;
			//Rule 2. MyList has more than one element
		else
			scenario = 2;

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION
		//-----------------------------
		switch (scenario) {

			//Rule 1. MyList is empty or contains just one element
			case 1:
				//1. We assign res to true
				res = true;

				break;

			//Rule 2. MyList has more than one element
			case 2:
				//1. We get the first two elements of MyList
				int e0 = m.getElement(0);
				int e1 = m.getElement(1);

				//2. If the first one is smaller than the second, we keep testing the rest of MyList
				if (e0 >= e1) {
					//2.1. We remove the first element from MyList
					m.removeElement(0);

					//2.2. We recursively solve the smaller problem
					res = isReverse(m);

					//2.3. We also add elem0 back to m1, so as to not to modify its original state
					m.addElement(0, e0);
				}
				//3. If the first one is bigger than the second one, we can conclude MyList is not sorted
				else
					res = false;

				break;
		}

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------
		return res;
	}

	//-------------------------------------------------------------------
	// 3. getNumAppearances --> Computes the amount of times that integer appears in MyList  
	//-------------------------------------------------------------------	

	/**
	 * The function computes the amount of times that the integer n appears in m.
	 *
	 * @param m: The MyList we want to use.
	 * @param n: The number we want to compute its appearances for.
	 * @return: The amount of appearances of n into m
	 */
	public int getNumAppearances(MyList<Integer> m, int n) {

//		//-----------------------------
//		//Output Variable --> InitialValue
//		//-----------------------------
//		int res = 0;
//
//		//-----------------------------
//		//SET OF OPS
//		//-----------------------------
//
//		//-----------------------------
//		// I. SCENARIO IDENTIFICATION
//		//-----------------------------
//		int scenario = 0;
//
//		//Rule 1. MyList is empty
//		if (m.length() == 0)
//			scenario = 1;
//			//Rule 2. MyList has some elements
//		else
//			scenario = 2;
//
//		//-----------------------------
//		// II. SCENARIO IMPLEMENTATION
//		//-----------------------------
//		switch (scenario) {
//
//			//Rule 1. MyList is empty
//			case 1:
//				//1. We assign res to 0
//				res = 0;
//
//				break;
//
//			//Rule 2. MyList has some elements
//			case 2:
//				//1. We get the first element of MyList
//				int e0 = m.getElement(0);
//
//				//2. We remove the first element from MyList we just checked
//				m.removeElement(0);
//
//				//3. We recursively solve the smaller problem
//				res = getNumAppearances(m, n);
//
//				//4. We compute the final result, based on the value that we were hosting.
//				if (e0 == n) {
//					res++;
//				}
//
//
//				//5. We also add the element back to m, so as to not to modify its original state
//				m.addElement(0, e0);
//
//				break;
//		}
//
//		//-----------------------------
//		//Output Variable --> Return FinalValue
//		//-----------------------------
//		return res;
		int result;

		if (m.length() == 0) {
			return 0;
			//Rule 2. MyList has some elements
		}
		else {
			int e0 = m.getElement(0);

				//2. We remove the first element from MyList we just checked
				m.removeElement(0);

				//3. We recursively solve the smaller problem
				result = getNumAppearances(m, n);

				//4. We compute the final result, based on the value that we were hosting.
				if (e0 == n) {
					result++;
				}
		        m.addElement(0, e0);
		}
		return result;

	}

	//-------------------------------------------------------------------
	// 4. power --> Computes the m-est power of n
	//-------------------------------------------------------------------	

	/**
	 * The function computes n to the power of m.
	 *
	 * @param n: The base number.
	 * @param m: The power of n we want to compute
	 * @return: n to the power of m.
	 */

	public int power(int n, int m) {

		if (m <= -1) {
			p("error");
			return -1;
		} else {
			if (m == 0) {
				return 1;
			} else {
				return n * power(n, m - 1);
			}
		}
		//return (int)java.lang.Math.pow(n,m);
	}

	//-------------------------------------------------------------------
	// 5. lucas --> Computes the n-est term of the Lucas series
	//-------------------------------------------------------------------	

	/**
	 * The function computes the n-est term of the Lucas series
	 *
	 * @param n: The n-est term of the series we want to compute
	 * @return: The term being computed
	 */
	public int lucas(int n) {

		if (n <= -1) {
			p("error");
			return -1;
		} else {
			if (n == 0) {
				return 2;
			} else if (n == 1) {
				return 1;
			} else {
				//1. We recursively solve the the smaller problem of computing n-1
				int n1 = lucas(n - 1);

				//2. We recursively solve the the smaller problem of computing n-2
				int n2 = lucas(n - 2);

				//3. We compute the final result
				return (n1 + n2);
			}
		}
	}

	//-------------------------------------------------------------------
	// 6. drawImage --> Prints a pattern of a given length
	//-------------------------------------------------------------------	

	/**
	 * The function prints prints a pattern of a given length.
	 * *
	 * **
	 * ***
	 * ...
	 *
	 * @param n: The length of the desired pattern
	 */
	public void drawImage(int n) {

//		if (n <= 0) {
//			p("error");
//					}
//		else {
//			while(n > 0){
//				for(int i = 1; i <= n; i++){
//					p("*");
//				}
//				n--;
//			}
//		}

		if (n <= 0) {
			// do nothing
		} else {
				drawImage(n-1);
				int i = 0;
				while (i < n) {
					pNl("*");
					i++;
				}
				//move to newline
				p("");


			}


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