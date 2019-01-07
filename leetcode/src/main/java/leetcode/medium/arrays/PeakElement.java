package leetcode.medium.arrays;

public class PeakElement {
/*
iven an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

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

	public int findPeakElementIter(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1])
				return i;
		}
		return nums.length - 1;
	}
	/*
	Complexity Analysis

Time complexity : O(n)O(n). We traverse the numsnums array of size nn once only.

Space complexity : O(1)O(1). Constant extra space is used.
	 */

	public int findPeakElement(int[] nums) {
		return search(nums, 0, nums.length - 1);
	}
	public int search(int[] nums, int l, int r) {
		if (l == r)
			return l;
		int mid = (l + r) / 2;
		if (nums[mid] > nums[mid + 1])
			return search(nums, l, mid);
		return search(nums, mid + 1, r);
	}


	public int searchIterBi(int[] nums, int l, int r) {
		if (l == r)
			return l;
		int mid = (l + r) / 2;
		if (nums[mid] > nums[mid + 1])
			return search(nums, l, mid);
		return search(nums, mid + 1, r);
	}
	/*
	Complexity Analysis

Time complexity : O\big(log_2(n)\big)O(log
2
​
 (n)). We reduce the search space in half at every step. Thus, the total search space will be consumed in log_2(n)log
2
​
 (n) steps. Here, nn refers to the size of numsnums array.

Space complexity : O(1)O(1). Constant extra space is us
	 */

	/*
	Let's call an array A a mountain if the following properties hold:

A.length >= 3
There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].

Example 1:

Input: [0,1,0]
Output: 1
Example 2:

Input: [0,2,1,0]
Output: 1
Note:

3 <= A.length <= 10000
0 <= A[i] <= 10^6
A is a mountain, as defined above.
	 */


	public int peakIndexInMountainArray(int[] A) {

		int low = 0 ;
		int high = A.length;

		while(low < high)
		{

			int mid = low + (high-low)/2;

			if(A[mid] < A[mid+1])
			{
				low = mid + 1;
			}
			else
				high = mid;
		}

		return low;
	}

	public int peakIndexInMountainArrayConstant(int[] A) {
		int i = 0;
		while (A[i] < A[i+1]) i++;
		return i;
	}
}