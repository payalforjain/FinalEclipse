package leetcode.easy.stringManipulation;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatedCharacter {
	
	public static char findFirstRepeatedChar(String inputString) {

		Set<Character> repeatedCharSet = new HashSet<Character>();
		char out = '\0';
		;
		char[] ch = inputString.toCharArray();

		for (char c : ch) {
			if (repeatedCharSet.contains(c)) {
				out = c;
				break;
			}

			repeatedCharSet.add(c);

		}

		return out;
	}

}
