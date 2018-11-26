package leetcode.medium.arrays;
import java.util.*;
public class ThreeSum {
/*


Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
    public List<List<Integer>> threeSum(int[] nums) {


        List<List<Integer>> result =   new ArrayList<List<Integer>>();
        if(nums == null && nums.length < 2)
        {
            return result;
        }
        Arrays.sort(nums);
        int j=0,k =0;
        for(int i = 0 ; i < nums.length -2 ; i++)
        {
            //handle duplicate here
            if(i==0 || nums[i] > nums[i-1])
            {


                j =i +1 ;
                k = nums.length -1;

                while(j < k)
                {

                    if(nums[i] + nums[j] + nums[k] == 0)
                    {
                        List<Integer> internalResult = new ArrayList<>();
                        internalResult.add(nums[i]);
                        internalResult.add(nums[j]);
                        internalResult.add(nums[k]);
                        result.add(internalResult);
                        j++;
                        k--;

                        //handle duplicate here
                        while (j < k && nums[j] == nums[j-1])
                        {
                            j++;
                        }
                        //handle duplicate here
                        while (j < k && nums[k] == nums[k+1])
                        {
                            k--;
                        }

                    }

                    else if (nums[i] + nums[j] + nums[k] > 0)
                    {
                        k--;
                    }

                    else
                    {
                        j++;
                    }


                }
            }
        }

        return result;

    }
    //This problem can be solved by using two pointers. Time complexity is O(n^2).
}
