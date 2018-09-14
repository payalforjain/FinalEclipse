package leetcode.easy.stringManipulation;

public class ValidPalindrome {
	/*
	 * Given a non-empty string s, you may delete at most one character. Judge
	 * whether you can make it a palindrome.
	 * 
	 * Example 1: Input: "aba" Output: True Example 2: Input: "abca" Output:
	 * True Explanation: You could delete the character 'c'.
	 */
	public boolean isPalindromeRange(String s, int i, int j) {
		for (int k = i; k <= i + (j - i) / 2; k++) {
			if (s.charAt(k) != s.charAt(j - k + i))
				return false;
		}
		return true;
	}

	public boolean validPalindrome(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				int j = s.length() - 1 - i;
				return (isPalindromeRange(s, i + 1, j) || isPalindromeRange(s, i, j - 1));
			}
		}
		return true;
	}

	/*
	 * Given a string, determine if it is a palindrome, considering only
	 * alphanumeric characters and ignoring cases.
	 * 
	 * For example, "A man, a plan, a canal: Panama" is a palindrome.
	 * "race a car" is not a palindrome.
	 */
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
}
