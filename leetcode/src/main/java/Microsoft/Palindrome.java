package Microsoft;

public class Palindrome {

    boolean isPalindrome(char[] str)
    {
        // Start from leftmost and rightmost corners of str
        int l = 0;
        int h = str.length - 1;

        // Keep comparing characters while they are same
        while (h > l)
        {
            if (str[l++] != str[h--])
            {

                return false;
            }
        }
        return true;
    }
}
