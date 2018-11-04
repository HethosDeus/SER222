import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class PriorityQueueImmutableEx {
// This is a test class that shows the difference between an immutable priority queue and a mutable priority queue.  
// The point is to show immutable PQs are the better approach
	
	public static void main(String[] args) {
	    PriorityQueue<Integer> ok = new PriorityQueue<>(Arrays.asList(1, 2, 3));
	    PriorityQueue<Integer> ok1 = new PriorityQueue<>(Arrays.asList(2, 4, 1, 3));
	    Integer i = null;
	    System.out.print("ok:   ");
	    while ((i = ok.poll()) != null) 
	    	System.out.print(i); //1,2,3
	    
	    System.out.println();
	    System.out.print("ok1:  ");
	    
	    while ((i = ok1.poll()) != null) 
	    	System.out.print(i); //1,2,3,4
	    System.out.println();
	    

	    PriorityQueue<AtomicInteger> Ok = new PriorityQueue<>(Comparator.comparing(AtomicInteger::intValue));
	    AtomicInteger one = new AtomicInteger (1);
	    Ok.add(one);
	    Ok.add(new AtomicInteger(2));
	    Ok.add(new AtomicInteger(3));
	    //print PQ
	    AtomicInteger ai = null;
	    System.out.print("Ok:   ");
	    while ((ai = Ok.poll()) != null) 
	    	System.out.print(ai); //9,2,3
	    System.out.println();
	    
	  //wrong way to PQ -- mutating value after initialization 
	    PriorityQueue<AtomicInteger> notOk = new PriorityQueue<>(Comparator.comparing(AtomicInteger::intValue));
	    AtomicInteger two = new AtomicInteger (1);
	    notOk.add(two);
	    notOk.add(new AtomicInteger(2));
	    notOk.add(new AtomicInteger(3));
	    
	    two.set(9);
	    System.out.print("notOk:");
	    while ((ai = notOk.poll()) != null) 
	    	System.out.print(ai); //9,2,3
	    System.out.println();
	    
	   // heapTest(0);
	   // heapTest(1);
	   // heapTest(2);
	    heapTest(8);
	    
	    heapUseZeroElem(8);
    
	}
	
    //heap testing of parent/child placement in the heap positions
    public static void heapTest (int k) {
    	k = k/2;
    	int l = 2 * k;
    	int r = (2 * k) + 1;
    	
    	System.out.println("k: " + k);
    	System.out.println("l: " + l);
    	System.out.println("r: " + r);
    }
    
    public static void heapUseZeroElem (int k) {
    	k = (k - 1)/2;
    	int l = ((2 * k) - 1) + 1;
    	int r = ((2 * k) - 1) + 2;
    	
    	System.out.println("k: " + k);
    	System.out.println("l: " + l);
    	System.out.println("r: " + r);
    }
}
