package leetcode.easy.arrays;

public class MergeTwoSortedArrays {
	
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
