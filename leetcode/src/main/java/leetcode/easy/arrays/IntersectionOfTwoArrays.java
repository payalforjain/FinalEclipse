package leetcode.easy.arrays;

import java.util.*;

public class IntersectionOfTwoArrays {

	/*
	Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Note:

Each element in the result must be unique.
The result can be in any order.
	 */
	//Sort both arrays, use two pointers
	//Time complexity: O(nlogn)
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i = 0;
		int j = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				i++;
			} else if (nums1[i] > nums2[j]) {
				j++;
			} else {
				set.add(nums1[i]);
				i++;
				j++;
			}
		}
		int[] result = new int[set.size()];
		int k = 0;
		for (Integer num : set) {
			result[k++] = num;
		}
		return result;

	}

	//Time complexity: O(nlogn)
	public int[] intersectionBinarySearch(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		Arrays.sort(nums2);
		for (Integer num : nums1) {
			if (binarySearch(nums2, num)) {

				set.add(num);
			}
		}
		int i = 0;
		int[] result = new int[set.size()];
		for (Integer num : set) {
			result[i++] = num;
		}
		return result;
	}

	public boolean binarySearch(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				return true;
			}
			if (nums[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return false;
	}
	public int[] intersectionthirdSol(int[] nums1, int[] nums2) {
		HashSet<Integer> set1 = new HashSet<Integer>();
		for(int i: nums1){
			set1.add(i);
		}

		HashSet<Integer> set2 = new HashSet<Integer>();
		for(int i: nums2){
			if(set1.contains(i)){
				set2.add(i);
			}
		}

		int[] result = new int[set2.size()];
		int i=0;
		for(int n: set2){
			result[i++] = n;
		}

		return result;
	}
	/*
	Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Note:

What if the given array is already sorted? How would you optimize your algorithm?
Solution 1, i.e., sorting,  would be better since it does not need extra memory.
What if nums1's size is small compared to num2's size? Which algorithm is better?
If two arrays are sorted, we could use binary search, i.e., for each element in the shorter array, search in the longer one. So the overall time complexity is O(nlogm), where n is the length of the shorter array, and m is the length of the longer array. Note that this is better than Solution 1 since the time complexity is O(n + m) in the worst case.
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
If the two arrays have relatively the same length, we can use external sort to sort out the two arrays in the disk. Then load chunks of each array into the memory and compare, by using the method 1.
If one array is too short while the other is long, in this case, if memory is limited and nums2 is stored in disk, partition it and send portions of nums2 piece by piece. keep a pointer for nums1 indicating the current position, and it should be working fine~
Another method is, store the larger array into disk, and for each element in the shorter array, use "Exponential Search" and search in the longer array.

	*/
	public int[] intersectSecond(int[] nums1, int[] nums2) {
		List<Integer> set = new ArrayList<>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i = 0;
		int j = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				i++;
			} else if (nums1[i] > nums2[j]) {
				j++;
			} else {
				set.add(nums1[i]);
				i++;
				j++;
			}
		}
		int[] result = new int[set.size()];
		int k = 0;
		for (Integer num : set) {
			result[k++] = num;
		}
		return result;
	}
	/*
	Input: nums1 = [1,2,2,1], nums2 = [2,2]
	Output: [2,2]
	Example 2:

	Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
	Output: [4,9]
	Note:*/
	public int[] intersect(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
			return new int[0];
		}

		Map<Integer, Integer> map = new HashMap<>();

		// step1: Put elements in nums1 into the map
		for (int num : nums1) {
			if (map.containsKey(num)) {
				int freq = map.get(num);
				map.put(num, freq + 1);
			} else {
				map.put(num, 1);
			}
		}

		// step 2: iterate the nums2 and get the result
		List<Integer> result = new ArrayList<>();
		for (int num : nums2) {
			if (map.containsKey(num) && map.get(num) > 0) {
				result.add(num);
				int freq = map.get(num);
				freq--;
				map.put(num, freq);
			}
		}

		return listToArray(result);
	}

	private int[] listToArray(List<Integer> list) {
		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}

		return result;
	}
}