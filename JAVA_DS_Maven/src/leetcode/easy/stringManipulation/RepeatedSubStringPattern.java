package leetcode.easy.stringManipulation;

import java.util.HashSet;
import java.util.Set;

public class RepeatedSubStringPattern {

	public boolean output = false;
	String in;
	Set<String> set = new HashSet<String>();

	public boolean repeatedSubstringPattern(String s) {
		int start = 0;
		int end = 1;
		in = s;
		substrings(start, end);
		return output;
	}

	void substrings(int start, int end) {
		if (start == in.length() && end == in.length()) {
			return;
		} else {
			if (end == in.length() + 1) {
				substrings(start + 1, start + 1);
			} else {
				String val = in.substring(start, end);
				if (set.contains(val)) {
					output = true;

				} else {
					if (val.length() > 1) {
						set.add(val);
					}
				}
				substrings(start, end + 1);
			}
		}
	}
}