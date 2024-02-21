import java.util.*;

public class AnagramSum {

    public static void main(String[] args) {
    	
        // Define an array of string words 
        String[] words = {"listen", "silent", "enlist", "hello", "world", "java", "avaj"};

        // Find the longest consecutive sequence of anagrams
        List<List<String>> anagramGroups = groupAnagrams(words);
        List<String> longestAnagramSequence = findLongestConsecutiveSequence(anagramGroups);

        // If there is a valid sequence, calculate the sum of the indices of the first two words
        if (longestAnagramSequence.size() >= 2) {
        	
        	// Calculate the sum of indices of the first two words in the longest consecutive anagram sequence
            int[] indicesSum = twoSumIndices(words, longestAnagramSequence.get(0), longestAnagramSequence.get(1));
            
            // Print the longest consecutive anagram sequence found
            System.out.println("Longest consecutive anagram sequence: " + longestAnagramSequence);

            // Print the sum of indices of the first two words in the longest consecutive anagram sequence
            System.out.println("Sum of indices of the first two words: " + Arrays.toString(indicesSum));
        } else {
            System.out.println("No valid consecutive anagram sequence found.");
        }
    }

    // This method groups anagrams together from an array of strings
    public static List<List<String>> groupAnagrams(String[] strs) {
    	
        // Create a HashMap to store anagrams, where the key is the sorted version of the word and the value is a list of anagrams
        Map<String, List<String>> anagramMap = new HashMap<>();
        
        // Iterate through each word in the input array
        for (String str : strs) {
        	
            // Convert the word to a character array and sort it
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            // If the sorted string is not already a key in the map, create a new entry with an empty list
            if (!anagramMap.containsKey(sortedStr)) {
                anagramMap.put(sortedStr, new ArrayList<>());
            }

            // Add the original word to the list of anagrams corresponding to its sorted version
            anagramMap.get(sortedStr).add(str);
        }

        // Return a list containing all the values (lists of anagrams) from the map
        return new ArrayList<>(anagramMap.values());
    }

    // This method finds the longest consecutive sequence of strings from a list of lists of strings
    public static List<String> findLongestConsecutiveSequence(List<List<String>> anagramGroups) {
    	
        // Initialize variables to keep track of the maximum length and the longest sequence found
        int maxLength = 0;
        List<String> longestSequence = new ArrayList<>();

        // Iterate through each group of anagrams
        for (List<String> group : anagramGroups) {
        	
            // Get the size of the current group, which represents the length of the consecutive sequence
            int currentLength = group.size();
            
            // If the length of the current group is greater than the maximum length found so far
            if (currentLength > maxLength) {
            	
                // Update the maximum length
                maxLength = currentLength;
                
                // Update the longest sequence with the current group
                longestSequence = group;
            }
        }

        // Return the longest consecutive sequence found
        return longestSequence;
    }

    // This method finds the indices of two words in an array of words
    public static int[] twoSumIndices(String[] words, String word1, String word2) {
    	
        // Create a HashMap to store the indices of words, where the key is the word and the value is its index
        Map<String, Integer> wordIndices = new HashMap<>();
        
        // Iterate through the array of words and store each word's index in the map
        for (int i = 0; i < words.length; i++) {
            wordIndices.put(words[i], i);
        }

        // Retrieve the indices of the given words from the map
        int index1 = wordIndices.get(word1);
        int index2 = wordIndices.get(word2);

        // Return an array containing the indices of the two words
        return new int[]{index1, index2};
    }
}

