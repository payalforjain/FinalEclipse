package leetcode.hard.DP.arrays;

import java.util.Stack;

public class LargestHistogram {

    public int largestRectangleArea(int[] heights) {
        Stack < Integer > stack = new Stack < > ();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
            {
                int height =  heights[stack.pop()];
                int width = i - stack.peek() - 1;
                int area = height * width ;
                maxarea = Math.max(maxarea, area );
            }

            stack.push(i);
        }
        while (stack.peek() != -1)
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() -1));
        return maxarea;
    }


    /*
      /*
    Complexity Analysis

Time complexity : O(n)O(n). nn numbers are pushed and popped.

Space complexity : O(n)O(n). Stack is used.
*/
    public static void main(String[] args)
    {
        LargestHistogram l = new LargestHistogram();
        l.largestRectangleArea(new int[] {2,1,5,6,2,3});
    }
}
