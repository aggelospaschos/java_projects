import java.util.Deque;
import java.util.LinkedList;

public class MaxSumSubarray {

    // Methodology:
    // Sliding Window technique with Deque
    // We maintain a deque to store indices of elements in the array
    // The front of the deque always contains the index of the maximum element in the current window
    // If an element goes out of the current window, we remove it from the deque
    // At each step, we calculate the sum of the elements within the current window

    // Method to find the maximum sum of a subarray of length k
    public static int maxSumSubarray(int[] nums, int k) {
    	
        // Initialize the maximum sum to the smallest possible integer value
        int maxSum = Integer.MIN_VALUE;
        
        // Create a deque to store indices of elements
        Deque<Integer> deque = new LinkedList<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
        	
            // Remove elements out of the current window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove smaller elements from the back of the deque
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }

            // Add the current index to the deque
            deque.offer(i);

            // Calculate sum when the window size is reached
            if (i >= k - 1) {
            	
                // Calculate the sum of elements within the current window
                int currentSum = calculateSum(nums, i - k + 1, i);
                
                // Update the maximum sum if necessary
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        // Return the maximum sum
        return maxSum;
    }

    // Helper method to calculate sum within a given range
    private static int calculateSum(int[] nums, int start, int end) {
    	
        // Initialize sum
        int sum = 0;
        
        // Iterate through the range and calculate the sum
        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }
        // Return the sum
        return sum;
    }

    // Main method to demonstrate usage
    public static void main(String[] args) {
    	
        // Example Usage
        int[] nums = {1, -2, 3, 5, -3, 2};
        int k = 3;

        // Call maxSumSubarray method and print the result
        int result = maxSumSubarray(nums, k);
        System.out.println("Maximum Sum Subarray: " + result);
    }
}
