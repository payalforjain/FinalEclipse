package leetcode.easy.arrays;

public class ContainerWithMostWater {
/*


Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.





The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.



Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49
 */
    public int maxArea(int[] height) {


        int maxArea = 0;
        int left = 0;
        int right = height.length -1;
        while(left < right )
        {
            maxArea = Math.max(maxArea, Math.min (height[left], height[right] ) * (right-left));

            if(height[left] < height[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }

    /*
    Complexity Analysis

Time complexity : O(n). Single pass.

Space complexity : O(1). Constant space is used.*/
}
