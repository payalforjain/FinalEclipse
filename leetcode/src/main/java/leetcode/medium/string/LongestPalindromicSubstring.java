package leetcode.medium.string;

public class LongestPalindromicSubstring {

    /*
    Input: "abc"
    Output: 3
    Explanation: Three palindromic strings: "a", "b", "c".
    Example 2:
    Input: "aaa"
    Output: 6
    Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

    Time Complexity: O(N^2)O(N
2
 ) where NN is the length of S. Each expansion might do O(N)O(N) work.

Space Complexity: O(1)O(1).*/

    int count = 0;
    public int countSubstrings(String s) {

        for (int i = 0; i < s.length(); i++) {
            extendFromIndex(s, i, i);
            extendFromIndex(s, i, i+1);
        }
        return count;
    }
    private void extendFromIndex(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            count++;
            i--;
            j++;
        }
    }


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
   public String longestPalindromeString(String s) {

       if(s == null)
       {
           return  null;
       }

       if(s.length() ==0)
       {
           return "";
       }

       String largest = s.substring(0,1);
       for(int i = 0 ; i < s.length();i++ )
       {
           String temp = findPalindrome(s , i , i);
           if(temp.length() > largest.length())
           {
               largest = temp;
           }

           // for the abba this condition
           temp = findPalindrome(s , i , i+1);
           if(temp.length() > largest.length())
           {
               largest = temp;
           }


       }


       return largest;
   }


    private String findPalindrome(String s , int start , int end)
    {

        while( start >= 0 && end < s.length()   && s.charAt(start) == s.charAt(end) )
        {
            start --;
            end++;
        }

        return s.substring(start+1, end );
    }

    /*
    Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
     */
    public int longestPalindrome(String s) {

        int[] lowerCount = new int[26];
        int[] upperCount = new int[26];
        int odd = 0;

        for(int i = 0 ; i < s.length() ; i++)
        {
            char c = s.charAt(i);

            if(c <'a')
            {
                upperCount[c - 'A']++;
            }
            else
            {
                lowerCount[c- 'a']++;
            }
        }

        for(int i = 0 ; i <26 ; i++)
        {
            if(lowerCount[i] % 2 ==1)
            {
                odd++;
            }

            if(upperCount[i] % 2 ==1)
            {
                odd++;
            }

        }
        if(odd == 0)
            return s.length();
        return s.length() - odd + 1;

    }

}
