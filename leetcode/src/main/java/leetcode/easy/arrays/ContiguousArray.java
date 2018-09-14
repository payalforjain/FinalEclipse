package leetcode.easy.arrays;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

we make use of a HashMap mapmap to store the entries in the form of (index, count)(index,count). We make an entry for a countcount in the mapmap whenever the countcount is e
ncountered first, and later on use the correspoding index to find the length of the largest subarray with equal no. of zeros and ones when the same countcount is encountered again.

Complexity Analysis

Time complexity : O(n)O(n). The entire array is traversed only once.

Space complexity : O(n)O(n). Maximum size of the HashMap mapmap will be \text{n}n, if all the elements are either 1 or 0.
 */


public class ContiguousArray {
	
	public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxlen;
    }
	
	/*
	Input:  arr[] = {10, 12, 11};
    Output: Length of the longest contiguous subarray is 3

    Input:  arr[] = {14, 12, 11, 20};
    Output: Length of the longest contiguous subarray is 2

    Input:  arr[] = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
    Output: Length of the longest contiguous subarray is 5
*/
	
	   int min(int x, int y) 
	    {
	        return (x < y) ? x : y;
	    }
	 
	    int max(int x, int y) 
	    {
	        return (x > y) ? x : y;
	    }
	 
	    // Returns length of the longest contiguous subarray
	    int findLength(int arr[], int n) 
	    {
	        int max_len = 1;  // Initialize result
	        for (int i = 0; i < n - 1; i++) 
	        {
	            // Initialize min and max for all subarrays starting with i
	            int mn = arr[i], mx = arr[i];
	 
	            // Consider all subarrays starting with i and ending with j
	            for (int j = i + 1; j < n; j++) 
	            {
	                // Update min and max in this subarray if needed
	                mn = min(mn, arr[j]);
	                mx = max(mx, arr[j]);
	 
	                // If current subarray has all contiguous elements
	                if ((mx - mn) == j - i)
	                    max_len = max(max_len, mx - mn + 1);
	            }
	        }
	        return max_len;  // Return result
	    }
	    
	    public static void main(String[] args) 
	    {
	    	ContiguousArray large = new ContiguousArray();
	        int arr[] = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
	        int n = arr.length;
	        System.out.println("Length of the longest contiguous subarray is "
	                + large.findLength(arr, n));
	    }
}
