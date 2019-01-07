package leetcode.hard.DP.arrays;

public class MedianOfSortedArrays {


    /*
    nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
     */
    public double findMedianSortedArrays(int[] numsA, int[] numsB) {
        // Assume edge case is safe
        int n = numsA.length + numsB.length;

        // Handle even/odd cases
        if (n % 2 == 0) {
            return (
                    findKth(numsA, 0, numsB, 0, n / 2) +
                            findKth(numsA, 0, numsB, 0, n / 2 + 1)
            ) / 2.0;
        }
        return (double)findKth(numsA, 0, numsB, 0, n / 2 + 1);
    }

    // Find kth number in two sorted array. k is size
    private int findKth(int[] numsA, int startA, int[] numsB, int startB, int k) {
        // check edge case for startA/startB index
        if (startA >= numsA.length) return numsB[startB + k - 1]; // A exhausted, take kth in B
        if (startB >= numsB.length) return numsA[startA + k - 1]; // B exhausted, take kth in A

        // handle final condition k == 1. The two elements will be sorted and the smaller one is kth.
        if (k == 1) return Math.min(numsA[startA], numsB[startB]);

        // compare and partition at each [x+(k/2-1)] position
        int halfKthOfA = startA + k / 2 - 1 < numsA.length ? numsA[startA + k / 2 - 1] : Integer.MAX_VALUE;
        int halfKthOfB = startB + k / 2 - 1 < numsB.length ? numsB[startB + k / 2 - 1] : Integer.MAX_VALUE;
        if (halfKthOfA < halfKthOfB) {
            return findKth(numsA, startA + k / 2, numsB, startB, k - k / 2);
        } else {
            return findKth(numsA, startA, numsB, startB + k / 2, k - k / 2);
        }
    }
}
