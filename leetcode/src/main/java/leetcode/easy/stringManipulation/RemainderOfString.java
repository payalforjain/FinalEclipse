package leetcode.easy.stringManipulation;

public class RemainderOfString {
	
	/*
	 *  S1= hemanth, s2 = em
	 */
	public static String remainderOfString(String s1, String s2) {
		String output = "";
		if (s1.indexOf(s2) > -1) {
			int temp = s1.indexOf(s2) + s2.length();
			output = s1.substring(temp, s1.length());
		}

		return output;
	}

}
