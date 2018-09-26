package leetcode.easy.stringManipulation;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Palindrome {
	
	public static boolean palindromeUsingStack(String input) {
		Stack<Character> in = new Stack<Character>();

		String output = "";

		for (int i = 0; i < input.length(); i++) {
			in.push(input.charAt(i));
		}

		while (!in.isEmpty()) {
			output = output + in.pop();
		}

		if (input.equals(output)) {
			return true;
		}

		return false;
	}


	/*
	 * leetcode problem
	 * 
	 * Given a string, determine if it is a palindrome, considering only
	 * alphanumeric characters and ignoring cases.
	 * 
	 * For example, "A man, a plan, a canal: Panama" is a palindrome.
	 */
	public boolean isPalindromeCrap(String s) {

		if (s == null)
			return false;
		if (s.length() == 0)
			return true;
		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

		return isPalindromeUsingRecursion(s);
	}

	public boolean isPalindromeUsingRecursion(String s) { // if length is
																	// 0 or 1
																	// then
																	// String is
																	// palindrome
		if (s.length() == 0 || s.length() == 1)
			return true;
		if (s.charAt(0) == s.charAt(s.length() - 1))
			/*
			 * check for first and last char of String: if they are same then do
			 * the same thing for a substring with first and last char removed.
			 * and carry on this until you string completes or condition fails
			 * Function calling itself: Recursion
			 */
			return isPalindromeUsingRecursion(s.substring(1, s.length() - 1));

		/*
		 * If program control reaches to this statement it means the String is
		 * not palindrome hence return false.
		 */
		return false;
	}

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
