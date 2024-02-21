public class BinarySearchExample {

	// Binary search method to find the index of the target in the array
	public static int binarySearch(int[] nums, int target) {
		
	    // Initialize left pointer to the beginning of the array
	    int left = 0;
	    
	    // Initialize right pointer to the end of the array
	    int right = nums.length - 1;

	    // Continue searching until the left pointer is less than or equal to the right pointer
	    while (left <= right) {
	    	
	        // Calculate the middle index without causing integer overflow
	        int mid = left + (right - left) / 2;

	        // If the element at the middle index is equal to the target, we found it
	        if (nums[mid] == target) {
	        	
	            return mid; // Target found, return the index
	        } else if (nums[mid] < target) {
	        	
	            // If the element at the middle index is less than the target,
	            // adjust the left pointer to search the right half of the array
	            left = mid + 1;
	        } else {
	        	
	            // If the element at the middle index is greater than the target,
	            // adjust the right pointer to search the left half of the array
	            right = mid - 1;
	        }
	    }

	    // If the target is not found after the entire search, return -1
	    return -1; 
	}

	public static void main(String[] args) {
		
	    // Define a sorted array for testing
	    int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	    
	    // Define the target element to search for
	    int target = 6;

	    // Call the binarySearch method to search for the target in the sorted array
	    int result = binarySearch(sortedArray, target);

	    // Check if the result is not equal to -1, indicating that the target was found
	    if (result != -1) {
	    	
	        // Print a message indicating that the target was found along with its index
	        System.out.println("Target " + target + " found at index " + result);
	    } else {
	    	
	        // Print a message indicating that the target was not found in the array
	        System.out.println("Target " + target + " not found in the array");
	    }
	}

}
