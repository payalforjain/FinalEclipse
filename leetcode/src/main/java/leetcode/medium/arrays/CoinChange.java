package leetcode.medium.arrays;

import java.util.Arrays;

public class CoinChange {
/*
Input: coins = [1, 2, 5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Note:
 */

        public int coinChange(int[] coins, int n) {
            if (n < 1) return 0;
            int[] dp = new int[n+1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int coin : coins) {
                for (int i = coin; i <= n; i++) {
                    if (dp[i - coin] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                    }
                }
            }
            return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
        }

        /*
        Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10]
Output: 1
         */

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args)
    {
        CoinChange coinChange = new CoinChange();
        int[] coins = {1, 2, 5};
        coinChange.change(5, coins);
    }
}
