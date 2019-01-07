package leetcode.medium.arrays;
import java.util.*;
public class ContinuousSubarray {

    /*
    Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous subarray of size at least 2 that sums up to the multiple of k, that is, sums up to n*k where n is also an integer.

Example 1:
Input: [23, 2, 4, 6, 7],  k=6
Output: True
Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
Example 2:
Input: [23, 2, 6, 4, 7],  k=6
Output: True
Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
Note:
The length of the array won't exceed 10,000.
You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
     */

    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0)
                sum = sum % k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1)
                    return true;
            } else
                map.put(sum, i);
        }
        return false;
    }

    /*
    Time complexity : O(n)O(n). Only one traversal of the array numsnums is done.

Space complexity : O(min(n,k))O(min(n,k)). The HashMap can contain upto min(n,k)min(n,k) different pairings.
     */


/*
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

we make use of a HashMap mapmap to store the entries in the form of (index, count)(index,count). We make an entry for a countcount in the mapmap whenever the countcount is e
ncountered first, and later on use the correspoding index to find the length of the largest subarray with equal no. of zeros and ones when the same countcount is encountered again.

Complexity Analysis

Time complexity : O(n)O(n). The entire array is traversed only once.

Space complexity : O(n)O(n). Maximum size of the HashMap mapmap will be \text{n}n, if all the elements are either 1 or 0.
 */



        public int findMaxLength(int[] nums) {
            int n=nums.length;
            if(n<2){
                return 0;
            }
            int maxLength=0;

            HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
            int sum=0;
            map.put(0, -1);
            for(int i=0;i<n;i++){
                if(nums[i]==1){
                    sum+=1;
                }
                else{
                    sum+=-1;
                }
                //sum-sum=0
                if(map.get(sum)!=null){
                    int length=i-map.get(sum);
                    if(length>maxLength){
                        maxLength=length;
                    }
                }
                else {
                    map.put(sum,i);
                }
            }
            return maxLength;
        }

        /*
        Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

Note:
The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.

Example 1:

Input: nums = [1, -1, 5, -2, 3], k = 3
Output: 4
Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
Example 2:

Input: nums = [-2, -1, 2, 1], k = 1
Output: 2
Explanation: The subarray [-1, 2] sums to 1 and is the longest.


         */

    public int maxSubArrayLen(int[] nums, int k) {

        int max = 0 ;
        if(nums == null || nums.length == 0)
            return max;
        int sum = 0 ;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, -1);

        //We need to put this entry into the map before, because if the maximal range starts from 0, we need to calculate sum(j) - sum(i - 1).
        for(int i = 0 ; i < nums.length ; i++ )
        {
            sum = sum + nums[i];
            if(!map.containsKey(sum))
                map.put(sum,i);

            if(map.containsKey(sum-k))
                max = Math.max(max, i - map.get(sum-k));
        }

        return max;
    }
}
