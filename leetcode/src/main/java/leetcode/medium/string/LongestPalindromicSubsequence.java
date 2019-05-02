package leetcode.medium.string;

public class LongestPalindromicSubsequence {


    /*
    Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
Example 1:
Input:
"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".
Example 2:
Input:
"cbbd"
Output:
2
One possible longest palindromic subsequence is "bb".

Thought process:
Sub-problem: f( i, j ) = the LPS's length in the substring s( i, j )
Function:
If s[ i ] == s[ j ], f( i, j ) = f( i + 1, j - 1 ) + 2.
Else, f( i, j ) = max( f( i + 1, j ), f( i, j - 1 ) ).
Initialization: if i == j, the string has only one character. Its LPS's length is 1.
Result: f( 0, length of s ).
     */
    public int longestPalindromeSubseq(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int[][] f = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            f[i][i] = 1;
        }

        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j + i < s.length(); j++) {
                int k = j + i;

                if (s.charAt(j) == s.charAt(k)) {
                    f[j][k] = f[j + 1][k - 1] + 2;
                } else {
                    f[j][k] = Math.max(f[j + 1][k - 1], Math.max(f[j + 1][k], f[j][k - 1]));
                }
            }
        }

        return f[0][s.length() - 1];
    }

    public static void main (String[] args)
    {
        LongestPalindromicSubsequence l = new LongestPalindromicSubsequence();
        l.longestPalindromeSubseq("bbbab");
    }
}
