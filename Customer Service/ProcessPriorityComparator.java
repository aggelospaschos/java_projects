import java.util.*;

// Define a public class named ProcessPriorityComparator that implements the Comparator interface for comparing Process objects
public class ProcessPriorityComparator implements Comparator<Process> {
    
    // Override the compare method from the Comparator interface to compare two Process objects based on their priorities
    @Override
    public int compare(Process p1, Process p2) {
    	
        // Use Integer.compare to compare the priorities of two Process objects (p1 and p2)
        // This method returns the result of the comparison: negative if p1's priority is less than p2's, positive if it's greater, and zero if they're equal
        return Integer.compare(p1.getPriority(), p2.getPriority());
    }
}
