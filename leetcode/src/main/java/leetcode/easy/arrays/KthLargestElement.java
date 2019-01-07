package leetcode.easy.arrays;

import java.util.PriorityQueue;

public class KthLargestElement {

    /*
    Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4


A Simple Solution is to sort the given array using a O(nlogn) sorting algorithm like Merge Sort,
Heap Sort, etc and return the element at index k-1 in the sorted array. Time Complexity of this solution is O(nLogn).


     */

    public int findKthLargest(int[] nums, int k) {
        int[] sortedArray = mergesort(nums);
        return sortedArray[sortedArray.length - k];

    }

    private int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0, j = 0;
        for (int k = 0; k < c.length; k++) {
            if (i >= a.length)
                c[k] = b[j++];
            else if (j >= b.length)
                c[k] = a[i++];
            else if (a[i] <= b[j])
                c[k] = a[i++];
            else
                c[k] = b[j++];
        }
        return c;
    }

    private int[] mergesort(int[] input) {
        int N = input.length;
        if (N <= 1)
            return input;
        int[] a = new int[N / 2];
        int[] b = new int[N - N / 2];
        for (int i = 0; i < a.length; i++)
            a[i] = input[i];
        for (int i = 0; i < b.length; i++)
            b[i] = input[i + N / 2];
        return merge(mergesort(a), mergesort(b));
    }

    /***********************************************************************
     * Check if array is sorted - useful for debugging
     ***********************************************************************/
    private boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++)
            if (a[i] < a[i - 1])
                return false;
        return true;
    }

    /*
     O(nlog(k)). Space complexity is O(k) for storing the top k numbers.
     */
    public int findKthLargestPriorityQueue(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
        for(int i: nums){
            q.offer(i);

            if(q.size()>k){
                q.poll();
            }
        }

        return q.peek();
    }

    // generate N real numbers between 0 and 1, and mergesort them
    public static void main(String[] args) {

        int[] a = { -1, 2, 0 };

        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);
        KthLargestElement kthLargestElement = new KthLargestElement();
        System.out.println(kthLargestElement.findKthLargest(a, 1));
    }
}
