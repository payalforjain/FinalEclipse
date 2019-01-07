package leetcode.medium.arrays;

/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class DecodeWays {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[] res = new int[len + 1];
        res[len] = 1;
        res[len-1] = s.charAt(len - 1) == '0' ? 0 : 1;
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0')
                continue;
            else {
                int sub = Integer.parseInt(s.substring(i, i + 2));

                if(sub <= 26)
                {
                    res[i] =   res[i + 1] + res[i + 2];
                }
                else
                {
                    res[i]  = res[i + 1];
                }

            }
        }

        return res[0];

    }

    public static void main(String[] args)
    {
        DecodeWays d = new DecodeWays();
        d.numDecodings("12");
        d.numDecodings("226");
        d.numDecodings("296");
    }
}
