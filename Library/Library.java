class Library {
    BookNode root; // Reference to the root of the library

    // Method to add a new book to the library
    public void addBook(String title, String author, int year) {
        root = addBookHelper(root, title, author, year); // Calling the helper method to add a new book
    }

    // Recursive helper method to add a new book to the library
    private BookNode addBookHelper(BookNode root, String title, String author, int year) {
        if (root == null) { // If the current node is null, create a new book node with the provided information
            return new BookNode(title, author, year);
        }

        // Assume books are sorted alphabetically by title
        int compareResult = title.compareTo(root.title); // Comparing the titles of the current book node and the new book
        if (compareResult < 0) { // If the new book title comes before the current node's title alphabetically, go to the left subtree
            root.left = addBookHelper(root.left, title, author, year);
        } else if (compareResult > 0) { // If the new book title comes after the current node's title alphabetically, go to the right subtree
            root.right = addBookHelper(root.right, title, author, year);
        } else {
            // Book with the same title already exists, do nothing
        }

        return root; // Return the modified root of the subtree
    }

    // Method to display the library inventory
    public void displayLibrary() {
        displayHelper(root); // Calling the helper method to recursively display the library
    }

    // Recursive helper method to display the library inventory
    private void displayHelper(BookNode root) {
        if (root != null) { // If the current node is not null, traverse the left subtree, print the current node's information, and traverse the right subtree
            displayHelper(root.left);
            System.out.println("Title: " + root.title + ", Author: " + root.author + ", Year: " + root.year);
            displayHelper(root.right);
        }
    }

    // Method to search for a specific book in the library
    public BookNode searchBook(String title) {
        return searchHelper(root, title); // Calling the helper method to search for a book
    }

    // Recursive helper method to search for a specific book in the library
    private BookNode searchHelper(BookNode root, String title) {
        if (root == null || root.title.equals(title)) { // If the current node is null or its title matches the search title, return the current node
            return root;
        }

        int compareResult = title.compareTo(root.title); // Comparing the search title with the title of the current node
        if (compareResult < 0) { // If the search title comes before the current node's title alphabetically, search in the left subtree
            return searchHelper(root.left, title);
        } else { // Otherwise, search in the right subtree
            return searchHelper(root.right, title);
        }
    }

    // Method to remove a book with the specified title from the library
    public void removeBook(String title) {
        root = removeHelper(root, title); // Calling the helper method to remove a book
    }

    // Recursive helper method to remove a book with the specified title from the library
    private BookNode removeHelper(BookNode root, String title) {
        if (root == null) { // If the current node is null, return null
            return null;
        }

        int compareResult = title.compareTo(root.title); // Comparing the title of the current node with the specified title
        if (compareResult < 0) { // If the specified title comes before the current node's title alphabetically, go to the left subtree
            root.left = removeHelper(root.left, title);
        } else if (compareResult > 0) { // If the specified title comes after the current node's title alphabetically, go to the right subtree
            root.right = removeHelper(root.right, title);
        } else {
            // Node to be removed found
            if (root.left == null) { // If the node to be removed has no left child, return its right child
                return root.right;
            } else if (root.right == null) { // If the node to be removed has no right child, return its left child
                return root.left;
            }

            // Node to be removed has two children
            root.title = findMin(root.right).title; // Find the minimum value book in the right subtree and replace the current node's title with it
            root.right = removeHelper(root.right, root.title); // Remove the duplicate book node from the right subtree
        }

        return root; // Return the modified root of the subtree
    }

    // Method to find the minimum value book in a subtree
    private BookNode findMin(BookNode root) {
        while (root.left != null) { // Traverse the left subtree until reaching the leftmost leaf node
            root = root.left;
        }
        return root; // Return the leftmost leaf node, which contains the minimum value book
    }
}
