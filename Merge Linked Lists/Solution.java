import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {

    /**
     * Merges multiple sorted linked lists into a single sorted linked list.
     *
     * @param lists Array of sorted linked lists
     * @return Merged sorted linked list
     */
    public ListNode mergeSortedLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Using Priority Queue (Min Heap) approach
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            current.next = node;
            current = current.next;

            if (node.next != null) {
                queue.offer(node.next);
            }
        }

        return dummy.next;
    }

    /**
     * Helper method to print the linked list.
     *
     * @param head Head of the linked list
     */
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Creating sample sorted linked lists
        ListNode list1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(6)));
        ListNode list3 = new ListNode(2, new ListNode(7));

        // Merging sorted linked lists
        ListNode[] lists = {list1, list2, list3};
        ListNode mergedList = solution.mergeSortedLists(lists);

        // Printing the merged list
        System.out.println("Merged Sorted List:");
        solution.printList(mergedList);
    }
}
