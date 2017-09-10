package leetcode.easy.arrays;

public class MaxProfitFBProblem {
	public int maxProfit(int[] prices) {
	    if(prices==null||prices.length<=1)
	        return 0;
	 
	    int min=prices[0]; // min so far
	    int result=0;
	 
	    for(int i=1; i<prices.length; i++){
	        result = Math.max(result, prices[i]-min);
	        min = Math.min(min, prices[i]);
	    }
	 
	    return result;
	}
	
	/*
	 * Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.
	 */
	/*[7, 1, 5, 3, 6, 4].

	If we plot the numbers of the given array on a graph, we get:

	Profit Graph

	If we analyze the graph, we notice that the points of interest are the consecutive valleys and peaks.

	Mathematically speaking:
	Total Profit= \sum_{i}(height(peak_i)-height(valley_i)) TotalProfit=
	​i
	​∑
	​​ (height(peak
	​i
	​​ )−height(valley
	​i
	 * 
	 */
	

	public int maxProfit2(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}
