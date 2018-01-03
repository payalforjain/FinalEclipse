package leetcode.easy.stringManipulation;

public class RemoveVowels {

	// using regular expression
	public static String removeVowels(String data) {
		String temp = data.replaceAll("[AaEeIiOoUu]", "");
		return temp;
	}

	// String builder
	public static String removeVowelsBuilder(final String string) {
		final String vowels = "AaEeIiOoUu";
		final StringBuilder builder = new StringBuilder();
		char[] s = string.toCharArray();
		for (final char c : s)
			if (vowels.indexOf(c) < 0)
				builder.append(c);
		return builder.toString();
	}

}
