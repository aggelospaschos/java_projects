public class Process {
    
    // Declare private instance variables to store process name and priority
    private String name;
    private int priority;

    // Constructor to initialize a Process object with a given name and priority
    public Process(String name, int priority) {
    	
        // Assign the provided name to the 'name' instance variable
        this.name = name;
        
        // Assign the provided priority to the 'priority' instance variable
        this.priority = priority;
    }

    // Getter method to retrieve the name of the process
    public String getName() {
    	
        // Return the value stored in the 'name' instance variable
        return name;
    }

    // Getter method to retrieve the priority of the process
    public int getPriority() {
    	
        // Return the value stored in the 'priority' instance variable
        return priority;
    }
}

