package leetcode.medium.arrays;

import java.util.Stack;

public class LargestRectangleHistogram {
/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

largest-rectangle-in-histogram1
Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

largest-rectangle-in-histogram2
The largest rectangle is shown in the shaded area, which has area = 10 unit.
For example, given height = [2,1,5,6,2,3], return 10.
 */
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();

        int max = 0;
        int i = 0;

        while (i < height.length) {
            //push index to stack when the current height is larger than the previous one
            if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                //calculate max value when the current height is less than the previous one
                int p = stack.pop();
                int h = height[p];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(h * w, max);
            }

        }

        while (!stack.isEmpty()) {
            int p = stack.pop();
            int h = height[p];
            int w = stack.isEmpty() ? i : i - stack.peek() - 1;
            max = Math.max(h * w, max);
        }

        return max;
    }

    public static void main(String[] args)
    {
        LargestRectangleHistogram l = new LargestRectangleHistogram();
        int[] num = {2,1,5,6,2,3};
        l.largestRectangleArea(num);
    }
}
