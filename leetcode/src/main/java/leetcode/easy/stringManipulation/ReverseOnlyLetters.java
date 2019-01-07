package leetcode.easy.stringManipulation;
import java.util.*;
public class ReverseOnlyLetters {
/*
Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.



Example 1:

Input: "ab-cd"
Output: "dc-ba"
Example 2:

Input: "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
Example 3:

Input: "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"
 */
    public String reverseOnlyLetters(String s) {
        StringBuilder sb = new StringBuilder();
        int j = s.length()-1;
        for(int i =0 ;i < s.length() ; i++)
        {
            if(Character.isLetter(s.charAt(i)))
            {
                while(!Character.isLetter(s.charAt(j)))
                {
                    j--;
                }

                sb.append(s.charAt(j));
                j--;
            }
            else
            {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }


    public String reverseOnlyLettersStack(String S) {
        Stack<Character> letters = new Stack();
        for (char c: S.toCharArray())
            if (Character.isLetter(c))
                letters.push(c);

        StringBuilder ans = new StringBuilder();
        for (char c: S.toCharArray()) {
            if (Character.isLetter(c))
                ans.append(letters.pop());
            else
                ans.append(c);
        }

        return ans.toString();
    }
}
