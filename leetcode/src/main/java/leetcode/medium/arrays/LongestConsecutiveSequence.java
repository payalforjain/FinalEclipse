package leetcode.medium.arrays;

import java.util.HashSet;
import java.util.*;

public class LongestConsecutiveSequence {
/*
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.	
 */
public int longestConsecutive(int[] nums) {
    if (nums.length == 0) {
        return 0;
    }

    Arrays.sort(nums);

    int longestStreak = 1;
    int currentStreak = 1;

    for (int i = 1; i < nums.length; i++) {
        if (nums[i] != nums[i-1]) {
            if (nums[i] == nums[i-1]+1) {
                currentStreak += 1;
            }
            else {
                longestStreak = Math.max(longestStreak, currentStreak);
                currentStreak = 1;
            }
        }
    }

    return Math.max(longestStreak, currentStreak);
}
/*
Time complexity : O(nlgn)O(nlgn).

The main for loop does constant work nn times, so the algorithm's time complexity is dominated by the invocation of sort, which will run in O(nlgn)O(nlgn) time for any sensible implementation.

Space complexity : O(1)O(1) (or O(n)O(n)).

For the implementations provided here, the space complexity is constant because we sort the input array in place. If we are not allowed to modify the input array, we must spend linear space to store a sorted copy.
 */

    public int longestConsecutiveHash(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum+1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
