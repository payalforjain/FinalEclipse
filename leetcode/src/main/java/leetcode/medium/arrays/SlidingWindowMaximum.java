package leetcode.medium.arrays;
import java.util.*;
public class SlidingWindowMaximum {
/*
Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7]
Explanation:

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 */



    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        Deque<Integer> deque = new LinkedList<Integer>();
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.getLast()]) {
                deque.removeLast();
            }

            deque.addLast(i);

            // Remove if the size of the deque is greater than k
            if (i - deque.getFirst() + 1 > k) {
                deque.removeFirst();
            }

            // Add into the result
            if (i + 1 >= k) {
                result[i + 1 - k] = nums[deque.getFirst()];
            }
        }

        return result;
    }
    public static void main(String[] args)
    {
        SlidingWindowMaximum s = new SlidingWindowMaximum();
        int[] nums =  {1,3,-1,-3,5,3,6,7};
        s.maxSlidingWindow(nums,3);
    }


}
