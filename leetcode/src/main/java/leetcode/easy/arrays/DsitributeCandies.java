package leetcode.easy.arrays;
import java.util.*;
public class DsitributeCandies {
/*
Given an integer array with even length, where different numbers in this array represent different kinds of candies. Each number means one candy of the corresponding kind. You need to distribute these candies equally in number to brother and sister. Return the maximum number of kinds of candies the sister could gain.
Example 1:
Input: candies = [1,1,2,2,3,3]
Output: 3
Explanation:
There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too.
The sister has three different kinds of candies.
 */
    public int distributeCandiestime(int[] candies) {
        HashSet < Integer > set = new HashSet < > ();
        for (int candy: candies) {
            set.add(candy);
        }
        return Math.min(set.size(), candies.length / 2);
    }

    /*
    Complexity Analysis**
Time complexity : O(n)O(n). The entire candiescandies array is traversed only once. Here, nn refers to the size of candiescandies array.

Space complexity : O(n)O(n). setset will be of size nn in the worst case.
     */

    public int distributeCandies(int[] candies) {
        Arrays.sort(candies);
        int count = 1;
        for (int i = 1; i < candies.length && count < candies.length / 2; i++)
            if (candies[i] > candies[i - 1])
                count++;
        return count;
    }

    /*
    Complexity Analysis

Time complexity : O(nlogn)O(nlogn). Sorting takes O(nlogn)O(nlogn) time.

Space complexity : O(1)O(1). Constant space is used.
     */
}
