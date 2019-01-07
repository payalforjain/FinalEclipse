package leetcode.medium.arrays;

import java.util.Random;
/*
// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();
 */
class Solution {

    int[] orginal;
    Random random;

    public Solution(int[] nums) {
        orginal = nums;
        random =new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return orginal;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] result = orginal.clone();

        for(int i = 0 ; i< result.length; i++)
        {
            int randomIndex = random.nextInt(i+1);
            swap(result, i , randomIndex);
        }
        return result;
    }

    private void swap(int[] nums, int i , int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp ;
    }


    public static void  main(String[] args)
    {
        Solution s = new  Solution(new int[] {1,2,3});
        System.out.println(s.shuffle());
        System.out.println(s.shuffle());
        System.out.println(s.shuffle());
        System.out.println(s.shuffle());System.out.println(s.shuffle());
        System.out.println(s.shuffle());


    }
}