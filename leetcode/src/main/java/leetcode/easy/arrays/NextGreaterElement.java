package leetcode.easy.arrays;
import java.util.*;
public class NextGreaterElement {
/*
You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.

Example 1:
Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
Explanation:
    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
    For number 1 in the first array, the next greater number for it in the second array is 3.
    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
Example 2:
Input: nums1 = [2,4], nums2 = [1,2,3,4].
Output: [3,-1]
Explanation:
    For number 2 in the first array, the next greater number for it in the second array is 3.
    For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
 */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        Stack<Integer> stack = new Stack();

        for(int i =0 ; i< nums2.length; i++)
        {

            while(!stack.isEmpty() && stack.peek() < nums2[i])
            {
                map.put(stack.pop(), nums2[i]);
            }

            stack.push(nums2[i]);
        }

        for(int i =0; i <nums1.length; i++)
        {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }

        return nums1;
    }

    /*
    Complexity Analysis

Time complexity : O(m+n)O(m+n).
 The entire numsnums array(of size nn) is scanned only once. The stack's nn elements are popped only once. The findNumsfindNums array is also scanned only once.

Space complexity : O(m+n)O(m+n). stackstack and mapmap of size nn is used. resres array of size mm is used,
where nn refers to the length of the numsnums array and mm refers to the length of the findNumsfindNums array.
     */
}
