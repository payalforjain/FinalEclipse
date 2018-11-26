package leetcode.easy.arrays;

import java.util.HashSet;
import java.util.*;

public class SetMisMatch {
/*
Input: nums = [1,2,2,4]
Output: [2,3]
 */
	public int[] findErrorNums(int[] nums) {
		Map < Integer, Integer > map = new HashMap();
		int dup = -1, missing = 1;
		for (int n: nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		for (int i = 1; i <= nums.length; i++) {
			if (map.containsKey(i)) {
				if (map.get(i) == 2)
					dup = i;
			} else
				missing = i;
		}
		return new int[]{dup, missing};
	}

	/*
	Time complexity : O(n)O(n). Traversing over numsnums of size nn takes O(n)O(n) time. Considering each number from 11 to nn also takes O(n)O(n) time.

Space complexity : O(n)O(n). mapmap can contain atmost nn entries for each of the numbers from 11 to nn
	 */

	public int[] findErrorNumsSort(int[] nums) {
		Arrays.sort(nums);
		int dup = -1, missing = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1])
				dup = nums[i];
			else if (nums[i] > nums[i - 1] + 1)
				missing = nums[i - 1] + 1;
		}
		return new int[] {dup, nums[nums.length - 1] != nums.length ? nums.length : missing};
	}

	/*
	Time complexity : O(nlogn)O(nlogn). Sorting takes O(nlogn)O(nlogn) time.

Space complexity : O(logn)O(logn). Sorting takes O(logn)O(logn) space.
	 */
	public int[] findErrorNumsconstant(int[] nums) {
		int dup = -1, missing = 1;
		for (int n: nums) {
			if (nums[Math.abs(n) - 1] < 0)
				dup = Math.abs(n);
			else
				nums[Math.abs(n) - 1] *= -1;
		}
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > 0)
				missing = i + 1;
		}
		return new int[]{dup, missing};
	}

	/*
	Time complexity : O(n)O(n). Two traversals over the numsnums array of size nn are done.

Space complexity : O(1)O(1). Constant extra space is used.
	 */

}
