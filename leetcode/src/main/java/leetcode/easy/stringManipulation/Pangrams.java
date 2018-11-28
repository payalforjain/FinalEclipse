package leetcode.easy.stringManipulation;

import java.util.Arrays;

/*
Pangram is a sentence containing every letter in the English alphabet. Given a string, find all characters that are missing from the string, i.e., the characters that can make string a Pangram. We need to print output in alphabetic order.

Examples:

Input : welcome to geeksforgeeks
Output : abdhijnpquvxyz

Input : The quick brown fox jumps
Output : adglvyz
 */
public class Pangrams {
/*
    Pangram is a sentence containing every letter in the English alphabet. Given a string, find all characters that are missing from the string, i.e., the characters that can make string a Pangram. We need to print output in alphabetic order.

    Examples:

    Input : welcome to geeksforgeeks
    Output : abdhijnpquvxyz

    Input : The quick brown fox jumps
    Output : adglvyz

    */

    String missingChars(String str)
    {
        int maxChar = 26;
        boolean[] present = new  boolean[maxChar];



        // Traverse string and mark characters
        // present in string.
        for (int i=0; i<str.length(); i++)
        {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
                present[str.charAt(i)-'a']  = true;
            else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
                present[str.charAt(i)-'A'] = true;
        }

        // Store missing characters in alphabetic
        // order.
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<maxChar ; i++)
            if (present[i] == false)
                sb.append((char)(i+'a'));



        return sb.toString();


    }
    public static boolean checkPangram (String str)
    {
        // Create a hash table to mark the
        // characters present in the string
        // By default all the elements of
        // mark would be false.
        boolean[] mark = new boolean[26];

        // For indexing in mark[]
        int index = 0;

        // Traverse all characters
        for (int i = 0; i < str.length(); i++)
        {
            // If uppercase character, subtract 'A'
            // to find index.
            if ('A' <= str.charAt(i) &&
                    str.charAt(i) <= 'Z')

                index = str.charAt(i) - 'A';

                // If lowercase character, subtract 'a'
                // to find index.
            else if('a' <= str.charAt(i) &&
                    str.charAt(i) <= 'z')

                index = str.charAt(i) - 'a';

            // Mark current character
            mark[index] = true;
        }

        // Return false if any character is unmarked
        for (int i = 0; i <= 25; i++)
            if (mark[i] == false)
                return (false);

        // If all characters were present
        return (true);
    }

    public static void main(String[] args)
    {
        Pangrams p = new Pangrams();
        System.out.println(p.missingChars("welcome to geeksforgeeks"));

        String str = "The quick brown fox jumps over the lazy dog";

        if (checkPangram(str) == true)
            System.out.print(str + " is a pangram.");
        else
            System.out.print(str+ " is not a pangram.");
    }
}
