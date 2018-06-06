package leetcode.easy.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyBoardRow {
	/*
	 * Given a List of words, return the words that can be typed using letters
	 * of alphabet on only one row's of American keyboard like the image below.
	 * Input: ["Hello", "Alaska", "Dad", "Peace"] Output: ["Alaska", "Dad"]
	 */

	public String[] findWords(String[] words) {

		String[] keyboardChars = { "QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM" };
		Map<Character, Integer> keyboardCharacter = new HashMap<Character, Integer>();

		for (int i = 0; i < keyboardChars.length; i++) {
			for (char c : keyboardChars[i].toCharArray()) {
				keyboardCharacter.put(c, i);// put <char, rowIndex> pair into
											// the map
			}
		}

		List<String> output = new ArrayList<String>();
		for (String word : words) {
			String wordUpper = word.toUpperCase();
			int indexOfWord = keyboardCharacter.get(wordUpper.charAt(0));
			boolean flag = true;
			if (wordUpper.equals(""))
				continue;
			for (char c : wordUpper.toCharArray()) {

				if (indexOfWord != keyboardCharacter.get(c)) {
					indexOfWord = -1; //
					break;
				}
			}
			if (indexOfWord != -1) {
				output.add(word);
			}

		}

		return output.toArray(new String[0]);
	}

}
