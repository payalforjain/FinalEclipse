package leetcode.medium.arrays;

import java.util.*;

public class KClosest {

    /*
    Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

Example 1:
Input: [1,2,3,4,5], k=4, x=3
Output: [1,2,3,4]
Example 2:
Input: [1,2,3,4,5], k=4, x=-1
Output: [1,2,3,4]
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int start = 0, end = arr.length-k;
        while(start<end){
            int mid = start + (end-start)/2;
            if(Math.abs(arr[mid]-x)>Math.abs(arr[mid+k]-x)){
                start = mid+1;
            } else {
                end = mid;
            }
        }
        for(int i=start; i<start+k; i++){
            res.add(arr[i]);
        }
        return res;
    }
}

