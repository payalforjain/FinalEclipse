package leetcode.hard.DP.arrays;

public class FirstMissingPositive {
    public int firstMissingPositiveExtrasSpace(int[] nums) {
        if(nums.length == 0) return 1;
        boolean[] flag = new boolean[nums.length];


        int n = nums.length;
        int i = 0;
        while(i < n )
        {
            if(nums[i]>0 && nums[i] <= nums.length)
            {
                flag[nums[i]-1] = true;


            }

            i++;

        }


        i = 0 ;
        while (i < n && flag[i] )
        {
            i++;
        }
        return i+1;

    }
/*
Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3
Example 2:

Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1

 */
public int firstMissingPositive(int[] nums) {

    int n = nums.length;
    int i = 0;
    while(i < n )
    {
        if(nums[i] == i+1  || nums[i] <= 0 || nums[i] > n || nums[i] == nums[nums[i] -1])
            i++;
        else if (  nums[i] != nums[nums[i] -1] )
            swap(nums , i , nums[i] -1 );

    }

    i = 0;

    while (i < n && nums[i] == i+1 )
        i++;

    return i+1;

}

    private void swap(int[] nums, int i ,  int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }

    public static void main(String[] args) {
        FirstMissingPositive f = new FirstMissingPositive();
        f.firstMissingPositive(new int[] {1,2,0});
        f.firstMissingPositive(new int[] { 3,4,-1,1});

    }
}


