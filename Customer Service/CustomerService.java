import java.util.*;

// Define a public class named CustomerService
public class CustomerService {

    // Method to demonstrate PriorityQueue operations
    public static void serveCustomers() {
    	
        // Creating a priority queue for customers based on their priority
        Queue<Customer> customerQueue = new PriorityQueue<>(new CustomerPriorityComparator());

        // Adding customers to the priority queue
        customerQueue.offer(new Customer("John", 5));
        customerQueue.offer(new Customer("Alice", 3));
        customerQueue.offer(new Customer("Bob", 1));
        customerQueue.offer(new Customer("Emily", 4));
        customerQueue.offer(new Customer("David", 2));

        // Serving customers based on priority
        System.out.println("Customer Service Queue:");
        
        // Loop until the customer queue is empty
        while (!customerQueue.isEmpty()) {
        	
            // Retrieve and remove the customer with the highest priority from the queue
            Customer servedCustomer = customerQueue.poll();

            // Print a message indicating the customer being served
            System.out.println("Serving customer: " + servedCustomer.getName());
        }
    }
}

