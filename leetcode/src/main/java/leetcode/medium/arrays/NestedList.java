package leetcode.medium.arrays;

import java.util.ArrayList;
import java.util.List;


public class NestedList {



    /*
    Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.

Example 1:

Input: [[1,1],2,[1,1]]
Output: 8
Explanation: Four 1's at depth 1, one 2 at depth 2.
Example 2:

Input: [1,[4,[6]]]
Output: 17
Explanation: One 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17.
     */
    public int depthSumInverseBFS(List<NestedInteger> nestedList) {

        int currentSum = 0, totalSum = 0;
        while (!nestedList.isEmpty()) {
            List<NestedInteger> nextLevel = new ArrayList<>();
            for (NestedInteger ni : nestedList) {
                if (ni.isInteger())
                    currentSum += ni.getInteger();
                else
                    nextLevel.addAll(ni.getList());
            }
            totalSum += currentSum;
            nestedList = nextLevel;
        }
        return totalSum;
    }


    int totalsum = 0;
    int currentSum = 0;

    public int depthSumInverse(List<NestedInteger> nestedList) {


        dfs(nestedList);
        return totalsum;
    }

    public void dfs(List<NestedInteger> nestedList) {
        if (nestedList.isEmpty())
            return ;

        List<NestedInteger> nextLevel = new ArrayList<>();
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger())
                currentSum += ni.getInteger();
            else {
                nextLevel.addAll(ni.getList());

            }

        }
        totalsum += currentSum;
        dfs(nextLevel);


    }



    /*
    Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:

Input: [[1,1],2,[1,1]]
Output: 10
Explanation: Four 1's at depth 2, one 2 at depth 1.
Example 2:

Input: [1,[4,[6]]]
Output: 27
Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27.
     */
    public int depthSum(List<NestedInteger> nestedList)
    {
        if(nestedList == null || nestedList.size() ==0 )
        {
            return 0;
        }

        return depthSum(nestedList , 1 );
    }
    private int depthSum(List<NestedInteger> nestedList, int depth) {
        int sum = 0 ;


        for(NestedInteger nested : nestedList)
        {
            if(nested.isInteger())
                sum = sum +  (nested.getInteger() * depth ) ;
            else
            {
                sum = sum + depthSum(nested.getList() , depth +1);
            }
        }
        return sum;

    }
    /*
    The algorithm takes O(N)O(N) time, where NN is the total number of nested elements in the input list. For example, the list [ [[[[1]]]], 2 ] contains 44 nested lists and 22 nested integers (11 and 22), so N=6N=6.

In terms of space, at most O(D)O(D) recursive calls are placed on the stack, where DD is the maximum level of nesting in the input. For example, D=2D=2 for the input [[1,1],2,[1,1]], and D=3D=3 for the input [1,[4,[6]]] */

    public interface NestedInteger {


        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
