package leetcode.easy.arrays;

public class ContigiousArrayProblems {

	/*
	 * Find the contiguous subarray within an array (containing at least one
	 * number) which has the largest product.
	 * 
	 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3]
	 * has the largest product = 6.
	 * 
	 * Input: [-4,-3] Output: 0 Expected: 12
	 */

	public int maxProduct(int[] nums) {
		int[] max = new int[nums.length];
		int[] min = new int[nums.length];

		max[0] = min[0] = nums[0];
		int result = nums[0];

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > 0) {
				max[i] = Math.max(nums[i], max[i - 1] * nums[i]);
				min[i] = Math.min(nums[i], min[i - 1] * nums[i]);
			} else {
				max[i] = Math.max(nums[i], min[i - 1] * nums[i]);
				min[i] = Math.min(nums[i], max[i - 1] * nums[i]);
			}

			result = Math.max(result, max[i]);
		}

		return result;
	}

	/*
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray [4,−1,2,1] has the largest sum = 6.

1. Dynamic Programming Solution

The changing condition for dynamic programming is "We should ignore the sum of the previous n-1 elements if nth element is greater than the sum."
 */


		public int maxSubArray(int[] A) {
			int newsum=A[0];
			int max=A[0];
			for(int i=1;i<A.length;i++){
				newsum=Math.max(newsum+A[i],A[i]);
				max= Math.max(max, newsum);
			}
			return max;
		}
}
