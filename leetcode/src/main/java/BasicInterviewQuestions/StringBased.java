package BasicInterviewQuestions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class StringBased {




	public static void StringToDate() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dateString = "11/12/2010";
		Date d = sdf.parse(dateString);
		System.out.println(d);

	}

	public static String replaceAll(String source, final String findToken, final String replaceToken) {

		int index = -1;

		do {
			index = source.indexOf(findToken);
			if (index > -1) {
				source = source.substring(0, index) + replaceToken + source.substring(index + findToken.length());
			}
		} while (index != -1);

		return source;
	}



	public static String findLatest(String string1, String string2) {
		StringTokenizer stringTokenizer1 = new StringTokenizer(string1, ".");
		StringTokenizer stringTokenizer2 = new StringTokenizer(string2, ".");
		while (stringTokenizer1.hasMoreElements() || stringTokenizer2.hasMoreElements()) {
			long strVal1;
			long strVal2;
			try {
				strVal1 = Long.parseLong(stringTokenizer1.nextToken());
			} catch (NoSuchElementException ne) {
				strVal1 = 0l;
			}
			try {
				strVal2 = Long.parseLong(stringTokenizer2.nextToken());
			} catch (NoSuchElementException ne) {
				strVal2 = 0l;
			}
			if (strVal1 > strVal2) {
				return string1;
			} else if (strVal2 > strVal1) {
				return string2;
			}
		}
		return string1;
	}

	public static String findMinimumSubstring(String S, String T) {
		if (S == null || T == null) {
			return null;
		}

		if (S.length() == 0 && T.length() == 0) {
			return "";
		}
		if (S.length() < T.length()) {
			return "";
		}

		char[] c = T.toCharArray();

		Set<Character> s = new HashSet<Character>();
		for (Character temp : c) {
			s.add(temp);
		}
		String output = "";
		String actualOutput = "";

		String temp = "";

		for (int i = 0; i < S.length(); i++) {
			if (output.length() == 0 && T.indexOf(S.charAt(i)) < 0) {
				output = "";
			} else {
				output = output + S.charAt(i);
			}
			// System.out.println(output);

			if (s.contains(S.charAt(i))) {
				temp = temp + S.charAt(i);
			}
			// System.out.println(temp + " " + T);
			if (temp.length() == T.length()) {
				// System.out.println(actualOutput.length() + " " +
				// output.length());
				if (actualOutput.length() == 0) {
					actualOutput = output;
					output = "";
				}

				else if (actualOutput.length() > 0 && actualOutput.length() > output.length()) {
					System.out.println(output);
					actualOutput = output;
					output = "";
				}

				temp = "";
			}
		}

		return actualOutput;
	}

	public static void printDiamond(int n) {

		System.out.println("Diamond of Stars are \n");
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < (n - i); j++)
				System.out.print(" ");
			for (int j = 1; j <= i; j++)
				System.out.print("*");
			for (int k = 1; k < i; k++)
				System.out.print("*");
			System.out.println();
		}

		for (int i = n - 1; i >= 1; i--) {
			for (int j = 0; j < (n - i); j++)
				System.out.print(" ");
			for (int j = 1; j <= i; j++)
				System.out.print("*");
			for (int k = 1; k < i; k++)
				System.out.print("*");
			System.out.println();
		}

		System.out.println();
	}

	public static void printDiamonds(int size) {
		// for odd size
		// we can do similar thing for even size.
		if (size % 2 != 0) {
			int spaceCount = size / 2;
			int starCount = 1;
			while (spaceCount >= 0) {
				for (int i = 0; i < spaceCount; i++) {
					System.out.print(" ");
				}
				for (int j = 0; j < starCount; j++) {
					System.out.print("*");
				}
				starCount = starCount + 2;
				spaceCount--;
				System.out.println();
			}
			starCount = size - 2;
			spaceCount = 1;
			while (starCount > 0) {
				for (int i = 0; i < spaceCount; i++) {
					System.out.print(" ");
				}
				for (int j = 0; j < starCount; j++) {
					System.out.print("*");
				}
				starCount = starCount - 2;
				spaceCount++;
				System.out.println();
			}
		}
	}

}
