package leetcode.medium.arrays;

public class FirstMissingPositive {
    public int firstMissingPositiveExtraSpace(int[] nums) {
        if(nums.length == 0) return 1;
       boolean[] flag = new boolean[nums.length];
        for(int i=0; i<nums.length; i++){
            if(nums[i]>0 && nums[i]<nums.length+1)
                flag[nums[i]-1] = true;
        }
        for(int i=0; i<nums.length; i++){
            if(!flag[i])
                return i+1;
        }
        return nums.length+1;
        
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
    public int firstMissingPositive(int[] A) {
        int i = 0;
        while(i < A.length){
            //we want every A[i] = i+1, so we can find the first missing one
            //if A[i] is negative or out of scope, or it's in desired position, continue
            if(A[i] == i+1 || A[i] <= 0 || A[i] > A.length) i++;
                //if the number at the desired position of A[i] isn't A[i], swap them
            else if(A[A[i]-1] != A[i]) swap(A, i, A[i]-1);
                //otherwise, A[A[i]-1] == A[i], we have a duplicate, move on
            else i++;
        }

        //now check from the beginning
        i = 0;
        while(i < A.length && A[i] == i+1) i++;
        return i+1;
    }

    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        FirstMissingPositive f = new FirstMissingPositive();
        f.firstMissingPositive(new int[] {1,2,0});
        f.firstMissingPositive(new int[] { 3,4,-1,1});

    }
}


