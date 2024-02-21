class BookNode {
	
    String title; // Title of the book
    String author; // Author of the book
    int year; // Year of publication
    BookNode left; // Reference to the left child
    BookNode right; // Reference to the right child

    // Constructor to create a node with the given book information
    public BookNode(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
}