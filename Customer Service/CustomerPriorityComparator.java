import java.util.*;

// Define a public class named CustomerPriorityComparator that implements the Comparator interface for comparing Customer objects
public class CustomerPriorityComparator implements Comparator<Customer> {
    
    // Override the compare method from the Comparator interface to compare two Customer objects based on their priorities
    @Override
    public int compare(Customer c1, Customer c2) {
    	
        // Use Integer.compare to compare the priorities of two Customer objects (c1 and c2)
        // This method returns the result of the comparison: negative if c1's priority is less than c2's, positive if it's greater, and zero if they're equal
        return Integer.compare(c1.getPriority(), c2.getPriority());
    }
}
