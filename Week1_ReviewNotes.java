package reviewWk1;

/**RECURSION:  the basic idea is that you want to make something from itself.  it is to solve a problems by solving
 * a smaller version of itself.  
 * 
 * overview:  a full size problem n (whole problem size(n) contains a subproblem (n - 1)
 *  	whole problem = subproblem + work
 *  	the subproblem is the same type of problem as the main problem but is easier to solve.  It is "smaller" according to a size metric
 *  	the subproblem continue until they are small enough to be trivial (base case)
 *  
 *  	each time the problem is analyzed, some part of the solution is computed with the solution for the subproblem, 
 *  	to form the solution for the whole
 *  
 * the keys to recursion:  How do we make it actually work? 
 * 		for all valid inputs, a recursive method must make the problem smaller during each call, and make PROGRESS towards some base case (termination).
 * 		the goal of recursion is to guarantee termination of the algo at the base case
 * 		Whole-problem --> subproblem --> subproblem --> ... --> base case
 * 		Also need to make sure to not change our problem. The type of problem should not change, nor the subproblem be the same as the original problem
 * 			
 * Recursive methods:  Recursive structure is an important concept in computer science.  By def, a method is recursive if it calls itself with the method.
 * 		there is a special type of recursive structure, which calls itself only one and in the last statement.  We refer to this as the tail-recursion.
 * 		tail-recursion is very similar to a do-while loop.  tail recursive calls are easier to optimize.
 * 	
 * 		why do we need recursion?  simplifies code and reusable, more efficient
 * 
 * the fantastic four approach:  
 * 		1. formulate the size-n problem
 * 		2. find the stopping condition and the corresponding return value. 2 is (the base case)
 * 		3. formulate the size-m problem and find m. in many cases, m = n - 1 (this is for factorials); 3 is (the subproblem)
 * 		4.  Construct the solution of size-n problem from the size-m problem
 * 
 * 		lets think about implementing factorial in terms of these steps. check the intro to programming languages book on this by Chen for CSE240.
 * 		
 * */ 

//putting the factorial problem together
public class Recursion {
	static int factorial (int n) { //size of the problem, changes to static to test below in the main() function
		if (n == 0)			// stopping condition for base case
			return 1;		// return value base case
		else
			return n * factorial (n - 1); //return value subproblem
		
	    // math definition:
		// 1!  = 1
		// N! = N * (N-1)!
	}
	
//here is a worked problem for computing nth fibonacci number using the the fantastic four
	/** 1. size-n problem:  
	 * 		long fib (int n)
	 *  2. find the stopping condition and the corresponding return value
	 *  	if (n == 0) return 0;
	 *  	if (n == 1) return 1;
	 *  3. form subproblem.  in many cases, m = n - 1
	 *  	fib(n - 1)
	 *  	fib(n - 2)
	 *  4. construct solution of size-n from size-m problem
	 *  	fib(n - 1) + fib(n - 2)
	 *  
	 *  as a general rule, recursion is very useful whenever you are faced with a problem you do not know how to solve
	 * */
	
//recursice approach.  this apparently will hang computers because of the recursion
public static long fib (int n) {
	if(n==0) return 0;
	if(n==1) return 1;
	
	return fib(n-1) + fib(n-2);
}

//iterative approach to fibonacci
public static long fibIterative (int n) {
		
	int fib = 0;
	int a = 1;
	int temp;
	
	for (int i = 0; i < n; i++) {
		temp = fib;
		fib += a;
		a = temp;
	}
	return fib;		
}

//is an example of printing a list with recursion using the fantastic four
	/** 1. size-n problem: to print out the entire list (start at the head of the list to display the entire thing)
	 * 		void display (LinearNode node) 	
	 * 	
	 * 	2. find the stopping condition and the corresponding return value:  could either be an empty list or a list with one element
	 *  	if (node == null) and return;
	 *  	 
	 *  3. form subproblem.  in many cases, m = n - 1: get the next node in the list  
	 *  	displayList (node.getNext())
	 *  
	 *  4. construct solution of size-n from size-m problem
	 * 		system.our.printlin(node);  //printing out the node head
	 * 		displayList(node.getNext()) //displaying each next node in the list
	 * 
	 * more of this code in full will be done in separate class files
	 * */

/*
//here is the iterative approach
public static void displayList(LinearNode node) {
	LinearNode iter = node; //additional line of code not needed in recursive method
	while (iter != null) {  //while statement instead of if
		System.out.println(iter);
		iter = iter.getNext();
	}
}

//here is the recursive approach. slightly simpler

public static void displayList(LinearNode node) {
	if (node != null) {
		System.out.println(node);
		displayList(node.getNext());
	}
}
*/
//quick data structure recursive example from the slides.  the recursion here is made possible with the use of references. thing1-3, alongfortheride
/*public class Thing
	public Thing thing2;
	private int alongfortheride;
	
		public Thing(Thing thing2, int i) {
			thing2 = t2;
			alongfortheride = i;
	}
}
*/
	
//main to make sure above methods for factorial and fibonacci work	
  public static void main(String[] args) {
  	int n = 6;
	
	  //System.out.println(factorial(n));
  	//System.out.println(fib(n));
	  System.out.println(fibIterative(n));
  }
}
