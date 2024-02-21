import java.util.Scanner;

public class LibrarySystem {

    public static void main(String[] args) {
        // Creating a new instance of Library
        Library library = new Library();

        // Adding books to the library
        library.addBook("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        library.addBook("To Kill a Mockingbird", "Harper Lee", 1960);
        library.addBook("1984", "George Orwell", 1949);
        library.addBook("Pride and Prejudice", "Jane Austen", 1813);
        library.addBook("The Catcher in the Rye", "J.D. Salinger", 1951);

        // Displaying the library
        System.out.println("Library Inventory:");
        library.displayLibrary();

        // Searching for a specific book
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the title of the book to search: ");
        String searchTitle = scanner.nextLine();
        BookNode foundBook = library.searchBook(searchTitle);
        if (foundBook != null) {
            System.out.println("Book found:");
            System.out.println("Title: " + foundBook.title);
            System.out.println("Author: " + foundBook.author);
            System.out.println("Year: " + foundBook.year);
        } else {
            System.out.println("Book not found in the library.");
        }

        // Removing a specific book
        System.out.print("\nEnter the title of the book to remove: ");
        String removeTitle = scanner.nextLine();
        library.removeBook(removeTitle);

        // Displaying the updated library
        System.out.println("\nUpdated Library Inventory:");
        library.displayLibrary();
    }
}