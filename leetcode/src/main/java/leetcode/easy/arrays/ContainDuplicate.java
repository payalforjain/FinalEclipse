package leetcode.easy.arrays;


import java.util.*;

public class ContainDuplicate {

	/*
	Example 1:

Input: [1,2,3,1]
Output: true
Example 2:

Input: [1,2,3,4]
Output: false
Example 3:

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true
	 */
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>(nums.length);
		for (int x : nums) {
			if (set.contains(x)) return true;
			set.add(x);
		}
		return false;
	}

	/*
Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
*/
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				int pre = map.get(nums[i]);
				if (i - pre <= k)
					return true;
			}

			map.put(nums[i], i);
		}

		return false;
	}


}
