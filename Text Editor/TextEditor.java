import java.util.Stack;

public class TextEditor {

    private StringBuilder currentText; // Stores the current text being edited
    private Stack<String> textHistory; // Stack to store the history of text changes

    // Constructor to initialize the text editor
    public TextEditor() {
        currentText = new StringBuilder(); // Initialize the StringBuilder for current text
        textHistory = new Stack<>(); // Initialize the stack to store text history
    }

    // Method to append new text to the current text
    public void appendText(String newText) {
        textHistory.push(currentText.toString());  // Save the current state before appending to history
        currentText.append(newText); // Append new text to the current text
    }

    // Method to undo the last text operation
    public void undo() {
        if (!textHistory.isEmpty()) {
            currentText = new StringBuilder(textHistory.pop());  // Restore the previous state
        }
    }

    // Method to get the current text
    public String getCurrentText() {
        return currentText.toString(); // Return the current text as a string
    }

    // Main method to demonstrate the functionality of the text editor
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();

        // Append text operations
        textEditor.appendText("Hello, ");
        System.out.println("Current Text: " + textEditor.getCurrentText());

        textEditor.appendText("World!");
        System.out.println("Current Text: " + textEditor.getCurrentText());

        // Undo operation
        textEditor.undo();
        System.out.println("After Undo: " + textEditor.getCurrentText());

        // Append more text
        textEditor.appendText(" Java is amazing!");
        System.out.println("Current Text: " + textEditor.getCurrentText());
    }
}

