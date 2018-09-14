package leetcode.easy.stringManipulation;

public class UniqueCharacterCheck {

	// unique character Check in a string
	public static boolean uniquecharCheck(String word) {
		String result = new String("");
		for (int i = 0; i < word.length(); i++) {
			if (!result.contains("" + word.charAt(i))) {
				result += "" + word.charAt(i);
			} else
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(uniquecharCheck("hemanth"));
		System.out.println(uniquecharCheck("kumar"));
	}
}
