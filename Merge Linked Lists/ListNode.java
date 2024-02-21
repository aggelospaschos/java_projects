public class ListNode {
    int val; // Value stored in the node
    ListNode next; // Reference to the next node in the linked list

    // Default constructor
    ListNode() {}

    // Constructor with a value parameter
    ListNode(int val) {
        this.val = val;
    }

    // Constructor with both value and next node parameters
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
