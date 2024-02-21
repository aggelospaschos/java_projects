import java.util.*;

public class SocialNetwork {

    public static void main(String[] args) {
        // Create a social network graph
        Graph socialNetwork = new Graph();

        // Add users to the social network
        socialNetwork.addUser(new User("Alice"));
        socialNetwork.addUser(new User("Bob"));
        socialNetwork.addUser(new User("Charlie"));
        socialNetwork.addUser(new User("David"));
        socialNetwork.addUser(new User("Emma"));

        // Add friendships between users
        socialNetwork.addFriendship("Alice", "Bob");
        socialNetwork.addFriendship("Alice", "Charlie");
        socialNetwork.addFriendship("Bob", "David");
        socialNetwork.addFriendship("Charlie", "Emma");
        socialNetwork.addFriendship("David", "Emma");

        // Print the social network graph
        System.out.println("Social Network Graph:");
        socialNetwork.print();

        // Example of checking if there is a friendship between two users
        String user1 = "Alice";
        String user2 = "Charlie";
        System.out.println("\nAre " + user1 + " and " + user2 + " friends?");
        System.out.println(socialNetwork.areFriends(user1, user2));
    }
}