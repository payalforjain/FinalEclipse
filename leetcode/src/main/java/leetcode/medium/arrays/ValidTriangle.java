package leetcode.medium.arrays;

import java.util.Arrays;

public class ValidTriangle {

    /*
    Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.
Example 1:
Input: [2,2,3,4]
Output: 3
Explanation:
Valid combinations are:
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3
Note:
The length of the given array won't exceed 1000.
The integers in the given array are in the range of [0, 1000].

The condition for the triplets (a, b, c)(a,b,c) representing the lengths of the sides of a triangle, to form a valid triangle, is that the sum of any two sides should always be greater than the third side alone. i.e. a + b > ca+b>c, b + c > ab+c>a, a + c > ba+c>b
     */

    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {

            for (int j = i + 1; j < nums.length - 1; j++) {

                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] > nums[k] && nums[j] + nums[k] > nums[i] && nums[i] + nums[k] > nums[i]) {
                        count++;
                    }
                }


            }
        }
        return count;
    }

    /*
    Complexity Analysis

Time complexity : O(n^2)O(n
2
 ). Loop of kk and jj will be executed O(n^2)O(n
2
 ) times in total, because, we do not reinitialize the value of kk for a new value of jj chosen(for the same ii). Thus the complexity will be O(n^2+n^2)=O(n^2)O(n
2
 +n
2
 )=O(n
2
 ).

Space complexity : O(\log n)O(logn). Sorting takes O(\log n)O(logn) space.
     */
    public int triangleNumberGreedy(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                while (k < nums.length && nums[i] + nums[j] > nums[k])
                    k++;

                count = count + k - j - 1;

            }
        }
        return count;
    }

}
