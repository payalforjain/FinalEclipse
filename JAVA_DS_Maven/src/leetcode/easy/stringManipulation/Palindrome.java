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

	public static int totalNoOfpalindrome(String input) {

		String out = "";
		Set<String> s = new HashSet<String>();

		for (int i = 0; i < input.length(); i++) {
			String temp = input.substring(i);

			out = "";
			for (int j = 0; j < temp.length(); j++) {
				out = out + temp.charAt(j);

				if (palindromeUsingStack(out)) {
					s.add(out);
				}

			}

		}

		for (String temp : s) {
			System.out.println(temp);
		}
		return s.size();

	}

	/*
	 * leetcode problem
	 * 
	 * Given a string, determine if it is a palindrome, considering only
	 * alphanumeric characters and ignoring cases.
	 * 
	 * For example, "A man, a plan, a canal: Panama" is a palindrome.
	 */

	public boolean isPalindrome(String s) {

		if (s == null)
			return false;
		if (s.length() == 0)
			return true;
		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

		return isPalindromeUsingRecursion(s);
	}

	public static boolean isPalindromeUsingRecursion(String s) { // if length is
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

}
