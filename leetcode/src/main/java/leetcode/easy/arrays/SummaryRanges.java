package leetcode.easy.arrays;
import java.util.*;
public class SummaryRanges {

    /*
    Given a sorted integer array without duplicates, return the summary of its ranges.

Example 1:

Input:  [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
Example 2:

Input:  [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
     */
    public List<String> summaryRanges(int[] nums) {

        List<String> result = new ArrayList<>();

        for (int i , j=0; j< nums.length; j++ )
        {
            i  = j;
            while( j + 1 < nums.length  && nums[j+1 ] == nums[j] + 1  )
            {

                j++;
            }

            if (i == j)
                result.add(nums[i] + "");
            else
                result.add(nums[i] + "->" + nums[j]);


        }

        return result;
    }

    /*
    Complexity Analysis

Time complexity : O(n)O(n). Each element is visited constant times: either in comparison with neighbor or put in the result list.

Space complexity : O(1)O(1). All the auxiliary space we need is the two indices, if we don't count the return list.
     */
}
