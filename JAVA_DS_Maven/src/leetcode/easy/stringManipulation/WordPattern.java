package leetcode.easy.stringManipulation;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

	public static boolean wordPattern(String pattern, String str) {

		String[] patternValue = str.split(" ");
		Map<Character, String> m = new HashMap<>();
		if (patternValue.length != pattern.length()) {
			return false;
		}

		for (int i = 0; i < pattern.length(); i++) {
			Character k = pattern.charAt(i);
			String value = patternValue[i];

			if (m.containsKey(k)) {
				String valueFromMap = m.get(k);
				if (!valueFromMap.equals(value)) {
					return false;
				}
			} else if (m.containsValue(value)) {
				return false;
			}

			m.put(k, value);

		}
		return true;
	}

	public static void main(String[] args) {
		wordPattern("abba", "dog cat cat dog");
	}
}
