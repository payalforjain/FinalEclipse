package leetcode.easy.arrays;

public class SubArrayLenMin {
/*
Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example:

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 */
public int minSubArrayLen(int s, int[] nums) {

    int length = Integer.MAX_VALUE;

    int sum = 0;

    int left = 0;

    for(int i = 0 ; i <nums.length;i++)
    {
        sum = sum + nums[i];

        while( sum >= s)
        {
            length = Math.min(length, i+1 - left );
            sum = sum - nums[left];
            left++;
        }
    }
    return length!=Integer.MAX_VALUE?length:0;

}

    /*
    Complexity analysis

Time complexity: O(n)O(n). Single iteration of O(n)O(n).
Each element can be visited atmost twice, once by the right pointer(ii) and (atmost)once by the \text{left}left pointer.
Space complexity: O(1)O(1) extra space. Only constant space required for \text{left}left, \text{sum}sum, \text{ans}ans and ii.
     */

    public static void main(String[] args)
    {
        SubArrayLenMin s =  new SubArrayLenMin();
        int[] nums = {2,3,1,2,4,3};
        s.minSubArrayLen(7, nums);
    }
}
