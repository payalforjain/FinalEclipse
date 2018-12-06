package leetcode.medium.arrays;
import java.util.*;
public class DailyTemperatures {

    /*
    Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
     */

    public int[] dailyTemperatures(int[] T) {

        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack();

        for(int i = 0; i <T.length; i++)
        {

            while(!stack.isEmpty() && T[i] > T[stack.peek()])
            {
                int index = stack.pop();
                result[index] = i - index;


            }

            stack.push(i);
        }


        return result;

    }

    /*
    Complexity Analysis

Time Complexity: O(N)O(N), where NN is the length of T and WW is the number of allowed values for T[i]. Each index gets pushed and popped at most once from the stack.

Space Complexity: O(W)O(W). The size of the stack is bounded as it represents strictly increasing temperatures.
     */
}
