package leetcode.medium.arrays;

public class MedianOfTwoArray {
	/*
	 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
	 * 
	 * Find the median of the two sorted arrays. The overall run time complexity
	 * should be O(log (m+n)).
	 * 
	 * Example 1: nums1 = [1, 3] nums2 = [2]
	 * 
	 * The median is 2.0 Example 2: nums1 = [1, 2] nums2 = [3, 4]
	 * 
	 * The median is (2 + 3)/2 = 2.5
	 * 
	 * 
	 */

	public static double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;

		if ((m + n) % 2 != 0) // odd
			return (double) findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1);
		else { // even
			return (findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1) + findKth(A, B, (m + n) / 2 - 1, 0, m - 1, 0, n - 1))
					* 0.5;
		}
	}

	public static int findKth(int A[], int B[], int k, int aStart, int aEnd, int bStart, int bEnd) {

		int aLen = aEnd - aStart + 1;
		int bLen = bEnd - bStart + 1;

		// Handle special cases
		if (aLen == 0)
			return B[bStart + k];
		if (bLen == 0)
			return A[aStart + k];
		if (k == 0)
			return A[aStart] < B[bStart] ? A[aStart] : B[bStart];

			int aMid = aLen * k / (aLen + bLen); // a's middle count
			int bMid = k - aMid - 1; // b's middle count

			// make aMid and bMid to be array index
			aMid = aMid + aStart;
			bMid = bMid + bStart;

			if (A[aMid] > B[bMid]) {
				k = k - (bMid - bStart + 1);
				aEnd = aMid;
				bStart = bMid + 1;
			} else {
				k = k - (aMid - aStart + 1);
				bEnd = bMid;
				aStart = aMid + 1;
			}

			return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
	}

	 // There are two sorted arrays nums1 and nums2 of same sze.
	public float find(int[] a, int start_a, int end_a, int[] b, int start_b, int end_b) {

		if (end_a - start_a + 1 == 2 && end_b - start_b + 1 == 2) {
			float x = Math.max(a[start_a], b[start_b]);
			float y = Math.min(a[end_a], b[end_b]);
			return (x + y) / 2;
		}

		float median_a = getMedian(a, start_a, end_a);
		float median_b = getMedian(b, start_b, end_b);

		int mid_a = (start_a + end_a) / 2;
		int mid_b = (start_b + end_b) / 2;
		if (median_a > median_b) {
			return find(a, start_a, mid_a, b, mid_b, end_b);
		} else {
			return find(a, mid_a, end_a, b, start_b, mid_b);
		}

	}

	public float getMedian(int[] x, int start, int end) {
		int size = end - start + 1;
		double median;
		if (size % 2 == 0) {
			float m = x[start + (size / 2)];
			float n = x[start + (size - 1) / 2];
			return (m + n) / 2;
		} else {
			return x[start + (size - 1) / 2];
		}
	}
	/*
	 * public static void main(String[] args) { MedianBinary m = new
	 * MedianBinary(); int [] a = {2,6,9,10,11}; int [] b = {1,5,7,12,15}; float
	 * x = m.find(a,0,a.length-1,b,0,b.length-1);
	 * System.out.println("Median of combined sorted array is: " + x); }
	 */

}
