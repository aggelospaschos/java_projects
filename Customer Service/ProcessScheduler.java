import java.util.*;

// Define a public class named ProcessScheduler
public class ProcessScheduler {

    // Method to demonstrate PriorityQueue operations
    public static void scheduleProcesses() {
    	
        // Creating a priority queue for processes based on their priority
        Queue<Process> processQueue = new PriorityQueue<>(new ProcessPriorityComparator());

        // Adding processes to the priority queue
        processQueue.offer(new Process("Process A", 3));
        processQueue.offer(new Process("Process B", 1));
        processQueue.offer(new Process("Process C", 2));
        processQueue.offer(new Process("Process D", 4));
        processQueue.offer(new Process("Process E", 5));

        // Scheduling processes based on priority
        System.out.println("\nProcess Scheduler Queue:");
        
        // Loop until the process queue is empty
        while (!processQueue.isEmpty()) {
        	
            // Retrieve and remove the process with the highest priority from the queue
            Process scheduledProcess = processQueue.poll();
            
            // Print a message indicating the process being executed
            System.out.println("Executing process: " + scheduledProcess.getName());
        }
    }
}

