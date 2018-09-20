package leetcode.easy.numbers;

import java.util.Arrays;

public class MissingNumbers {

    /*
    Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

    Example 1:

    Input: [3,0,1]
    Output: 2
    Example 2:

    Input: [9,6,4,2,3,5,7,0,1]
    Output: 8
    Note:
    Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
     */
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int n = nums.length;
        return n * (n + 1) / 2 - sum;
    }


    // Binary Search
    public int missingNumber2(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = nums.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] > m) {

                r = m;
            } else {
                l = m + 1;
            }
        }

        return r;
    }
}
