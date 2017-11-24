/**
 * Classical Change making problem with an unlimited amount of coins of each type. <br> 
 * Version 2: Selection function with more elaborated policy: First biggest-coin.<br> 
 * Depending on the type of coins, it can lead to an optimal solution.<br>
 * The class encapsulates all the functions of the Greedy schema<br>
 */

public class ChangeMaking {

	//---------------------------------------
	//	Constructor
	//---------------------------------------
	/**
	 * Constructor of the class. Do not edit it.
	 */
	public ChangeMaking(){}

	//-------------------------------------------------------------------
	// 0. displayElements --> Displays all elements of a MyList 
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, this function displays its elements by screen (if any).
	 * @param m: The MyList we want to display its elements.	  
	 */	
	public void displayElements(MyList<Integer> m){
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
			System.out.print("MyList has " + size + " items: [");

			//2. We traverse the items
			for (int i = 0; i < size - 1; i++)
				System.out.print(m.getElement(i) + ", ");
			System.out.println(m.getElement(size - 1) + "]");

			break;

		}

	}

	// -------------------------------------------------------------------
	// 1. selectionFunctionDummy --> It selects the next candidate to be
	// considered.
	// -------------------------------------------------------------------
	/**
	 * Given a current solution that is not a final solution, this function
	 * selects the new candidate to be added to it.<br>
	 * The policy followed is very simple: Just pick the first unused item.
	 * 
	 * @param candidates:
	 *            The MyList stating whether a candidate has been selected so
	 *            far or not.
	 * @return: The index of first candidate to be selected.
	 */
	public int selectionFunctionDummy(MyList<Integer> candidates) {

		// -----------------------------
		// Output Variable --> InitialValue
		// -----------------------------
		int res = -1;

		// -----------------------------
		// SET OF OPS
		// ----------------------------
		if (candidates.length() > 0)
			res = 0;

		// -----------------------------
		// Output Variable --> Return FinalValue
		// -----------------------------
		return res;
	}


	//-------------------------------------------------------------------
	// 1. selectionFunction --> It selects the next candidate to be considered.  
	//-------------------------------------------------------------------	
	/**
	 * Given a current solution that is not a final solution, this function selects the new candidate to be added to it.<br> 
	 * The policy followed is more elaborated: Pick the biggest non-discarded type of coin.
	 * @param changeGenerated: The quantity of change we have generated so far. 
	 * @param candidates:
	 *            The MyList stating whether a candidate has been selected so
	 *            far or not.
	 * @return: The index of candidate to be selected.
	 */	
	public int selectionFunctionBiggestCoin(MyList<Integer> candidates){

		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		int res = -1;

		//-----------------------------
		//SET OF OPS
		//-----------------------------
		int maxWeight = Integer.MIN_VALUE;
		int index = candidates.length() - 1;


		while (index >= 0) {
			// OP1.1. Auxiliary variables:
			// We use 'e0' to compute the first item of 'candidate' just once.
			int e0 = candidates.getElement(index);

			// OP1.1. If a not previously considered item improves minWeight, we
			// update 'res' and 'minWeight'
			if (e0 > maxWeight) {
				res = index;
				maxWeight = e0;
			}

			// OP1.2. We decrease 'index' so as to try the previous item of
			// 'candidates'
			index--;
		}

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;		
	}

	//-------------------------------------------------------------------
	// 2. feasibilityTest --> It selects if a candidate can be added to the solution.  
	//-------------------------------------------------------------------	
	/**
	 * Given a current solution and a selected candidate, this function 
	 * states whether the candidate must be added to the solution or discarded.<br> 
	 * @param candidateValue: The value of the candidate coin selected. 
	 * @param amount: The amount of change we want to generate.
	 * @param changeGenerated: The quantity of change we have generated so far. 
	 * @return: Whether the candidate fits or not into the solution.
	 */	

	public boolean feasibilityTest(int candidateValue, int amount, int changeGenerated ){

		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------

		if (candidateValue + changeGenerated <= amount) {
			return true;
		}
		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return false;		
	}

	// -------------------------------------------------------------------
	// 5. solutionTest --> It selects if the current solution is the final
	// solution
	// -------------------------------------------------------------------
	/**
	 * Given a current solution, this function states whether it is a final
	 * solution or it can still be improved.<br>
	 * To determine it, it checks whether there is (at least) one item not
	 * picked before that fits into the knapsack.
	 * 
	 * @param nbCandidates:
	 *            number of candidates that have not been yet selected by the
	 *            selection function
	 * @return: Whether the current solution is the final solution.
	 */
	public boolean solutionTest(MyList<Integer> candidates) {

		// -----------------------------
		// Output Variable --> InitialValue
		// -----------------------------
		if (candidates.length() == 0) {
			return true;
		}
		// -----------------------------
		// Output Variable --> Return FinalValue
		// -----------------------------
		return false;
	}


	//-------------------------------------------------------------------
	// 4. objectiveFunction --> This function computes the value of the final solution.  
	//-------------------------------------------------------------------	
	/**
	 * Given the final solution to the problem, this function 
	 * computes its value according to:<br>
	 * How many coins are used in the solution.<br>
	 * How accurate it is the change.<br> 
	 * @param sol: The MyList containing the solution to the problem.
	 * @param changeGenerated: The change generated by the current solution. 
	 * @param amount: The amount of change we want to generate. 
	 * @return: The value of such solution.
	 */	
	public MyList<Integer> objectiveFunction(MyList<Integer> sol, int changeGenerated, int amount){

		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res = null;
		int am = 0;
		int n = 0;
		int totalNumCoins = 0;

		res = new MyDynamicList<Integer>();
		res.addElement(0, (changeGenerated - amount));
		res.addElement(1, sol.length());
		
		//-----------------------------
		//SET OF OPS
		//-----------------------------
//		for(int i = 0; i < sol.length(); i++) {
//			n = (changeGenerated - am) / sol.getElement(i);
//			am = (am += sol.getElement(i) * n);
//			res.addElement(i, n);
//		}
		
//		for(int i = 0; i < sol.length(); i++) {
//			n = (changeGenerated - am) / sol.getElement(i);
//			am = (am += sol.getElement(i) * n);
//			totalNumCoins += n;
//		}
//		
//		res.addElement(2, totalNumCoins);

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;		
	}

	//-------------------------------------------------------------------
	// 5. solve --> This function solves the problem using a greedy algorithm.  
	//-------------------------------------------------------------------	
	/**
	 * Given an instance of the GP1 problem, this function solves it using 
	 * a greedy algorithm.<br> 
	 * @param typeSelectFunc:
	 *            Type of selection function to choose.
	 * @param coinValues: A MyList containing the value of each type of coin supported. 
	 * @param amount: The amount of change we want to generate.
	 * @return: A MyList containing the amount of coins of each type being selected.
	 */	
	public MyList<Integer> solve(int typeSelectFunc, MyList<Integer> coinValues, int amount){
		MyList<Integer> res = null;

		// -----------------------------
		// SET OF OPS
		// -----------------------------

		// OP1. Auxiliary variables:

		// We use 'candidates' as a MyList with the items that can be considered
		// by the selectionFunction.
		MyList<Integer> candidates = null;
		MyList<Integer> objFunValues = null;

		// We use res for storing the values of the items that will be in the knapsack
		//MyList<Integer> resValues = null;

		// We use 'capacityUsed' to state the amount of weight our bin contains
		// so far.
		int capacityUsed = 0;

		// OP1. We initialise all variables:

		// OP1.1. 'res' is initialised to be a list of the items that will be in
		// the knapsack
		res = new MyDynamicList<Integer>();
		candidates = new MyDynamicList<Integer>();
		objFunValues =new MyDynamicList<Integer>();

		// we copy all the items in the candidates list
		for (int i = 0; i < coinValues.length(); i++) {
			candidates.addElement(i, coinValues.getElement(i));
		}


		// OP2. We construct the final solution:
		while (solutionTest(candidates) == false) {
			// OP2.1 Auxiliary variables:
			// We use 'itemSelected' to state the index of the candidate being
			// selected.
			int candidateSelected = -1;

			// OP2.1. We pick the most promising candidate
			switch (typeSelectFunc) {
			case 1:
				candidateSelected = selectionFunctionDummy(candidates);
				break;
			case 2:
				candidateSelected = selectionFunctionBiggestCoin(candidates);
				break;
			}

			while (feasibilityTest(candidates.getElement(candidateSelected), amount, capacityUsed) == true) {
				res.addElement(res.length(), candidates.getElement(candidateSelected));
				//int n = (amount - capacityUsed) / candidates.getElement(candidateSelected);
				//capacityUsed = capacityUsed + candidates.getElement(candidateSelected) * n;
				capacityUsed = capacityUsed + candidates.getElement(candidateSelected);
				
			}

			candidates.removeElement(candidateSelected);
		}

		// OP3. We print the solution and its associated objective value
		objFunValues = objectiveFunction(res, capacityUsed, amount);
		System.out.println("Solution:");
		
		System.out.print("Coins to be givin in change:");
		displayElements(res);
		p("accuracy = " + objFunValues.getElement(0));
		p("number of coins used = " + objFunValues.getElement(1));
		//p("Total number of coins used = " + objFunValues.getElement(2));
		
		
//		
////		pNl("\t\t\t\t\t\t ");
////		for(int i = 0; i < res.length(); i++) {
////			pNl("*  ");
////		}
////		System.out.print("\nNumber of coins to be givin:");
////		displayElements(objFunValues);
////		p("");
		// -----------------------------
		// Output Variable --> Return FinalValue
		// -----------------------------
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
