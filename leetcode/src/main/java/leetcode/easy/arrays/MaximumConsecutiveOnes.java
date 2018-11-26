package leetcode.easy.arrays;

public class MaximumConsecutiveOnes {
/*
iven a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
Note:

The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000
 */

    public int findMaxConsecutiveOnes(int[] arr) {

        int count = 0; //intitialize count
        int result = 0; //initialize max

        for (int i = 0; i < arr.length; i++)
        {

            // Reset count when 0 is found
            if (arr[i] == 0)
                count = 0;

                // If 1 is found, increment count
                // and update result if count becomes
                // more.
            else
            {
                count++;//increase count
                result = Math.max(result, count);
            }
        }

        return result;

    }
}
