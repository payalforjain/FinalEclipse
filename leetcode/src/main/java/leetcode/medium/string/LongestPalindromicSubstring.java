package leetcode.medium.string;

public class LongestPalindromicSubstring {

   // Time O(n^2) Space O(n^2)
/*
Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb
*/
/*
We can scan to both sides for each character. Time O(n^2), Space O(1)
 */
    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return "";
        }

        if (s.length() == 1) {
            return s;
        }

        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            // get longest palindrome with center of i
            String tmp = helper(s, i, i);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }

            // get longest palindrome with center of i, i+1
            tmp = helper(s, i, i + 1);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
        }

        return longest;
    }
}
