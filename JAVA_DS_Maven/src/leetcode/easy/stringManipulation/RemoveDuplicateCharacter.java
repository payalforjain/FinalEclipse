package leetcode.easy.stringManipulation;

public class RemoveDuplicateCharacter {
	
	private String removeDuplicateCharactersFromWord(String word) {
		String result = new String("");
		for (int i = 0; i < word.length(); i++) {
			if (!result.contains("" + word.charAt(i))) {
				result += "" + word.charAt(i);
			}
		}

		return result;
	}


}
