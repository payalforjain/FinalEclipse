package leetcode.easy.arrays;
// Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
public class RemoveDuplicatesArray {

	
	public int removeDuplicates(int[] nums) {
	    int i = 0;
	    for (int n : nums)
	        if (i == 0 || n > nums[i-1])
	            nums[i++] = n;
	    return i;
	}
	
	//Remove Duplicates from Sorted Array II (allow duplicates up to 2):
	public int removeDuplicates2(int[] nums) {
		   int i = 0;
		   for (int n : nums)
		      if (i < 2 || n > nums[i - 2])
		         nums[i++] = n;
		   return i;
		}
}
