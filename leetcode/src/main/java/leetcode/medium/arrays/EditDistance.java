package leetcode.medium.arrays;

public class EditDistance {


    public int minDistance(String word1, String word2) {

        int m = word1.length() ;
        int n = word2.length();

        int[][] dp = new int[m+1][n+1];

        for(int i = 0 ; i < m + 1 ;i++  )
        {
            dp[i][0] = i;
        }

        for(int j = 0 ; j < n + 1 ;j++  )
        {
            dp[0][j] = j;
        }

        for(int i =1 ; i < m +1  ; i++ )
        {
            for(int j =1 ; j < n +1 ; j++)
            {
                int left = dp[i-1][j];
                int down =  dp[i][j-1];
                int leftDown = dp[i-1][j-1];
                if(word1.charAt(i-1) == word2.charAt(j-1) )
                {
                    dp[i][j] = leftDown;
                }
                else
                {
                    dp[i][j] = 1+ Math.min (leftDown , Math.min(left , down) );
                }
            }
        }
        return dp[m][n];
    }

    /*
    Time complexity : \mathcal{O}(m n)O(mn) as it follows quite straightforward for the inserted loops.
Space complexity : \mathcal{O}(m n)O(mn) since at each step we keep the results of all previous computations. */
}
