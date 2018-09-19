package leetcode.easy.arrays;

public class MergeTwoSortedArrays {

	/*
	Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
	 */
	
	public void merge(int A[], int m, int B[], int n) {
		int i = m - 1, j = n - 1, k = m + n - 1;
		while (i > -1 && j > -1)
			A[k--] = (A[i] > B[j]) ? A[i--] : B[j--];
		while (j > -1)
			A[k--] = B[j--];
	}
	
	
	// Betterr solution
	
	public static  int[] mergeBetter(int A[], int m, int B[], int n) {
		int i = m - 1, j = n - 1, k = m + n - 1;
		int[] X = new int[m+n];
		while (i > -1 && j > -1)
			X[k--] = (A[i] > B[j]) ? A[i--] : B[j--];
		while (j > -1)
			X[k--] = B[j--];
		// Mandatory Condition
		while (i > -1)
			X[k--] = A[i--];
		
		return X;
	}

	
	
	public static void main(String[] args)
	{
		int[] a = {1,4,5};
		int[] b = {3,4,7,8};
		System.out.println(mergeBetter(a,3,b,4));
		
	}

}
