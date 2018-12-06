package leetcode.medium.arrays;

public class FirstAndLastPositionSorted {
/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 */

    public int[] searchRangeLinear(int[] nums, int target) {
        int[] result = {-1,-1 };

        for(int i = 0 ; i< nums.length; i++) {
           if(nums[i] == target) {
              result[0] = i;
              break;
           }
        }


        if(result[0] == -1) {
          return result;
        }


        for(int i = nums.length-1 ; i>=0; i--) {
            if(nums[i] == target) {
                result[1] = i;
                break;
            }
        }


        return result;
    }

    /*
    omplexity Analysis

Time complexity : O(n)O(n)

This brute-force approach examines each of the n elements of nums exactly twice, so the overall runtime is linear.

Space complexity : O(1)O(1)

The linear scan method allocates a fixed-size array and a few integers, so it has a constant-size memory footprint.


​
 (n))

Because binary search cuts the search space roughly in half on each iteration, there can be at most \lceil \log_{10}(n) \rceil⌈log
10
​
 (n)⌉ iterations. Binary search is invoked twice, so the overall complexity is logarithmic.

Space complexity : O(1)O(1)

All work is done in place, so the overall memory usage is
     */
/*
Your algorithm’s runtime complexity must be in the order of O(log n).
 */
    public int[] searchRange(int[] nums, int target) {
        int low= 0 ; int high = nums.length -1;

        while(low<=high)
        {
            int mid = (low + high)/2;
            if(nums[mid] == target)
            {
                if(nums[low] == target && nums[high] == target)
                {
                    return new int[]{low,high};
                }

                else if (nums[high] != target)
                {
                    high--;
                }
                else if (nums[low] != target)
                {
                    low ++;
                }

            }
            else if(nums[mid] < target )
            {
                low = mid +1;
            }

            else
            {
                high = mid -1 ;
            }
        }

        return new int[]{-1,-1};
    }



}

