package leetcode.medium.arrays;

public class PaintHouse {


    /*
    There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.

Note:
All costs are positive integers.

Example:

Input: [[1,5,3],[2,9,4]]
Output: 5
Explanation: Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5;
             Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5.
Follow up:
Could you solve it in O(nk) runtime?
     */
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        if (costs[0] == null || costs[0].length == 0) {
            return 0;
        }
        int prevMin = 0;
        int prevSecond = 0;
        int prevIndex = 0;
        for (int i = 0; i < costs.length; i++) {
            int currMin = Integer.MAX_VALUE;
            int currSecond = Integer.MAX_VALUE;
            int currIndex = -1;
            for (int j = 0; j < costs[0].length; j++) {
                costs[i][j] = costs[i][j] + (j == prevIndex ? prevSecond : prevMin);
                if (costs[i][j] < currMin) {
                    currSecond = currMin;
                    currMin = costs[i][j];
                    currIndex = j;
                }
                else if (costs[i][j] < currSecond) {
                    currSecond = costs[i][j];
                }
            }
            prevMin = currMin;
            prevSecond = currSecond;
            prevIndex = currIndex;
        }
        return prevMin;
    }
    public static void main(String[] args)
    {
        PaintHouse p = new PaintHouse();
        p.minCostII( new int[][] {{1,5,3},{2,9,4}});
    }
}
