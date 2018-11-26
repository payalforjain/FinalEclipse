package leetcode.medium.string;

public class StringToInteger {

    /*
    Input: "42"
Output: 42
Example 2:

Input: "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign.
             Then take as many numerical digits as possible, which gets 42.
Example 3:

Input: "4193 with words"
Output: 4193
Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
Example 4:

Input: "words and 987"
Output: 0
Explanation: The first non-whitespace character is 'w', which is not a numerical
             digit or a +/- sign. Therefore no valid conversion could be performed.
Example 5:

Input: "-91283472332"
Output: -2147483648
Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
             Thefore INT_MIN (−231) is returned.
     */
    public int myAtoi(String str) {
        str = str.trim();
        if( str  == null ||  str.length() ==0)
        {
            return 0;
        }

        int i=0;
        boolean isPositive = true;
        if(str.charAt(i) == '-')
        {
            isPositive = !isPositive;
            i++;
        }

        else if (str.charAt(i) == '+')
        {
            i++;
        }

        // use double to store result
        double result = 0;

        while(i < str.length() && str.charAt(i) >= '0'   &&  str.charAt(i) <= '9')
        {
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }

        if(!isPositive)
        {
            result = -result;
        }

        // handle max and min
        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return  (int)result;
    }
}
