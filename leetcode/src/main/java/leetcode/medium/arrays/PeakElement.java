package leetcode.medium.arrays;

public class PeakElement {
/*
A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5
Explanation: Your function can return either index number 1 where the peak element is 2,
             or index number 5 where the peak element is 6.

 */
	public int findPeakElement(int[] nums) {
		int n = nums.length;
		return findPeakUtil(nums, 0, n - 1, n);
	}

	private int findPeakUtil(int arr[], int low, int high, int n) {
		// Find index of middle element
		int mid = low + (high - low) / 2; /* (low + high)/2 */

		// Compare middle element with its neighbours (if neighbours
		// exist)
		if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == n - 1 || arr[mid + 1] <= arr[mid]))
			return mid;

			// If middle element is not peak and its left neighbor is
			// greater than it,then left half must have a peak element
		else if (mid > 0 && arr[mid - 1] > arr[mid])
			return findPeakUtil(arr, low, (mid - 1), n);

			// If middle element is not peak and its right neighbor
			// is greater than it, then right half must have a peak
			// element
		else
			return findPeakUtil(arr, (mid + 1), high, n);
	}
}