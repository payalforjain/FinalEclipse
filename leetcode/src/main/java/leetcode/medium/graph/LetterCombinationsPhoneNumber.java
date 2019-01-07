package leetcode.medium.graph;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsPhoneNumber {

	/*
	 * Given a digit string, return all possible letter combinations that the
	 * number could represent.
	 * 
	 * A mapping of digit to letters (just like on the telephone buttons) is
	 * given below.
	 * 
	 * 
	 * 
	 * Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf",
	 * "cd", "ce", "cf"].
	 */

	public List<String> letterCombinations(String inputDigit) {
		if (inputDigit == null || inputDigit.isEmpty()) {
			return new ArrayList<String>();
		}
		String[] dictionary = { " ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		ArrayList<String> result = new ArrayList<String>();
		StringBuilder tempString = new StringBuilder();
		dfs(inputDigit, dictionary, 0, tempString, result);
		return result;
	}

	public void dfs(String inputDigits, String[] dictionary, int deep, StringBuilder tempString, ArrayList<String> result) {
		if (deep == inputDigits.length()) {
			result.add(tempString.toString());
			return;
		} else {
			for (int i = 0; i < dictionary[inputDigits.charAt(deep) - '0'].length(); i++) {
				tempString.append(dictionary[inputDigits.charAt(deep) - '0'].charAt(i));
				dfs(inputDigits, dictionary, deep + 1, tempString, result);
				tempString.deleteCharAt(tempString.length() - 1);
			}
		}
	}

	public static void main(String[] args)
	{
		LetterCombinationsPhoneNumber l =new LetterCombinationsPhoneNumber();
		l.letterCombinations("23");
	}
}
