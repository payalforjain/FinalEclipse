package leetcode.easy.stringManipulation;
import java.util.*;
public class ValidPalindrome {
	/*
	 * Given a non-empty string s, you may delete at most one character. Judge
	 * whether you can make it a palindrome.
	 * 
	 * Example 1: Input: "aba" Output: True Example 2: Input: "abca" Output:
	 * True Explanation: You could delete the character 'c'.


	/*
	 * Given a string, determine if it is a palindrome, considering only
	 * alphanumeric characters and ignoring cases.
	 * 
	 * For example, "A man, a plan, a canal: Panama" is a palindrome.
	 * "race a car" is not a palindrome.
	 */
	//Java Solution 3 - Using Two Pointers
	public boolean isPalindrome(String s) {
		if (s == null || s.length() == 0)
			return true;

		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}

		return true;

	}

	public boolean isPalindromeUsingStack(String s) {
		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

		int len = s.length();
		if (len < 2)
			return true;

		Stack<Character> stack = new Stack<Character>();

		int index = 0;
		while (index < len / 2) {
			stack.push(s.charAt(index));
			index++;
		}

		if (len % 2 == 1)
			index++;

		while (index < len) {
			if (stack.empty())
				return false;

			char temp = stack.pop();
			if (s.charAt(index) != temp)
				return false;
			else
				index++;
		}

		return true;
	}
}
