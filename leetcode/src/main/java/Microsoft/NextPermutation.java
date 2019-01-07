package Microsoft;

public class NextPermutation {
    /*
    Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1)
1,2,3 → 1,3,2


2) 3,2,1 → 1,2,3


3)
1,1,5 → 1,5,1
     */
/*
The steps to solve this problem:
1) scan from right to left, find the first element that is less than its previous one.

4 5 6 3 2 1
  |
  p
2) scan from right to left, find the first element that is greater than p.

4 5 6 3 2 1
    |
    q
3) swap p and q

4 5 6 3 2 1
swap
4 6 5 3 2 1
4) reverse elements [p+1, nums.length]

4 6 1 2 3 5
 */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args)
    {
        NextPermutation n = new  NextPermutation();
        int[] nums = {1,2,3};
        n.nextPermutation(nums);
    }
}
