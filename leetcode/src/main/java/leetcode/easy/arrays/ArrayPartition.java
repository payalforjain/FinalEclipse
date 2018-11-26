package leetcode.easy.arrays;
import java.util.*;
public class ArrayPartition {
/*


Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

Example 1:
Input: [1,4,3,2]

Output: 4
Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
 */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    /*
    Complexity Analysis

Time complexity : O\big(nlog(n)\big)O(nlog(n)). Sorting takes O\big(nlog(n)\big)O(nlog(n)) time. We iterate over the array only once.

Space complexity : O(1)O(1). Constant extra space is used.
     */

    public int arrayPairSumExtraSpaces(int[] nums) {
        int[] arr = new int[20001];
        int lim = 10000;
        for (int num: nums)
            arr[num + lim]++;
        int d = 0, sum = 0;
        for (int i = -10000; i <= 10000; i++) {
            sum += (arr[i + lim] + 1 - d) / 2 * i;
            d = (2 + arr[i + lim] - d) % 2;
        }
        return sum;
    }

    /*
    Complexity Analysis

Time complexity : O(n)O(n). The whole hashmap arrarr of size nn is traversed only once.

Space complexity : O(n)O(n). A hashmap arrarr of size nn is used.
     */
}
