import java.util.*;

class Graph {

    // Instance variable to store the adjacency list of the graph
    Map<String, List<String>> adjacencyList;

    // Constructor to initialize the graph
    Graph() {
        adjacencyList = new HashMap<>(); // Initialize the adjacency list as a HashMap
    }

    // Method to add a user to the social network
    public void addUser(User user) {
    	
        // Add a new entry to the adjacency list with the user's name as the key and an empty list as the value
        adjacencyList.put(user.getName(), new ArrayList<>());
    }

    // Method to add a friendship between two users
    public void addFriendship(String user1, String user2) {
    	
        // Add user2 to the list of friends of user1, and vice versa
        adjacencyList.get(user1).add(user2);
        adjacencyList.get(user2).add(user1);
    }

    // Method to check if there is a friendship between two users
    public boolean areFriends(String user1, String user2) {
    	
        // Check if user2 is present in the list of friends of user1
        return adjacencyList.get(user1).contains(user2);
    }

    // Method to print the adjacency list representation of the graph
    public void print() {
    	
        // Iterate through the adjacency list entries
        for (Map.Entry<String, List<String>> entry : adjacencyList.entrySet()) {
            String user = entry.getKey(); // Get the user's name
            List<String> friends = entry.getValue(); // Get the list of friends
            System.out.print(user + " -> "); // Print the user's name followed by an arrow
            
            // Iterate through the user's friends and print their names
            for (String friend : friends) {
                System.out.print(friend + " ");
            }
            System.out.println(); // Move to the next line for the next user
        }
    }
}
