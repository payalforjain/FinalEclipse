package leetcode.easy.stringManipulation;

public class CheckSubString {

	// Find if a string is the substring of the other
		public static void findMe(String mainString, String subString) {

			System.out.println("Check it status" + mainString.contains(subString));
			System.out.println(mainString.indexOf(subString) > -1 ? true : false);

		}

}
