package leetcode.medium.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.*;

/*
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
 */
public class DisappearedNumbersArray {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		ArrayList<Integer> ret = new ArrayList<Integer>();

		for (int i = 0; i < nums.length; i++){
			int value = Math.abs(nums[i])-1;
			if (nums[value] > 0){
				nums[value] = -nums[value];
			}
		}

		for (int i = 0; i < nums.length; i++){
			if (nums[i] > 0){
				ret.add(i+1);
			}
		}

		return ret;
	}

	public List<Integer> findDisappearedNumbersAcceptable(int[] nums) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Set<Integer> set = new HashSet<Integer>();

		for(int num : nums)
		{
			set.add(num);
		}

		for(int i = 1 ; i <= nums.length ; i++)
		{
			if(!set.contains(i))
			{
				result.add(i);
			}
		}

		return result;

	}


	public static void main(String[] args)
	{
		DisappearedNumbersArray d = new DisappearedNumbersArray();
		int[] num = {4,3,2,7,8,2,3,1};
		d.findDisappearedNumbers(num);
	}
}
