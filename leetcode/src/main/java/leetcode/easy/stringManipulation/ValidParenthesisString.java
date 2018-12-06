package leetcode.easy.stringManipulation;

public class ValidParenthesisString {

    public boolean checkValidString(String s) {
        int lo = 0, hi = 0;
        for (char c: s.toCharArray()) {
            lo += c == '(' ? 1 : -1;
            hi += c != ')' ? 1 : -1;
            if (hi < 0) break;
            lo = Math.max(lo, 0);
        }
        return lo == 0;
    }

    /*
    Complexity Analysis

Time Complexity: O(N)O(N), where NN is the length of the string. We iterate through the string once.

Space Complexity: O(1)O(1), the space used by our lo and hi pointers. However, creating a new character array will take O(N)O(N) space.
     */
    public static void main (String[] args )
    {
        ValidParenthesisString v = new ValidParenthesisString();
        v.checkValidString( "(*))");
    }
}
