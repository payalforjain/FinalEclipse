package leetcode.medium.string;

public class ValidParanthesisString {

    /*
    Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
An empty string is also valid.
Example 1:
Input: "()"
Output: True
Example 2:
Input: "(*)"
Output: True
Example 3:
Input: "(*))"
Output: True
     */
    public boolean checkValidString(String s) {
        int low = 0 ;
        int high = 0;
        for (int i = 0 ; i < s.length() ; i++ )
        {
            char c= s.charAt(i);

            if(c == '(')
            {
                low ++;
                high ++ ;
            }
            else if ( c == ')')
            {
                if(low >0)
                    low --;

                high--;
            }

            else
            {
                if(low >0)
                    low --;

                high++;
            }

            if(high < 0)
                return false;
        }

        return low==0;
    }

}
