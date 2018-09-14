package leetcode.easy.stringManipulation;

public class RotatedString {

	/*
	 * 1) add s1 + s1 = sAdd 2) sAdd.contains(s2)
	 */

	// Find if a string is rotation of another string ex. abcd , dabc is
	// rotation of abcd
	public static boolean isRotated(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		String sAdd = s1 + s1;
		if (sAdd.contains(s2)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isRotatedIndex(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		String sAdd = s1 + s1;
		if (sAdd.indexOf(s2) > -1)
			return true;

		return false;
	}

}
