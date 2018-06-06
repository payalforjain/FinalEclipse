package leetcode.medium.string;

import java.util.Arrays;

public class IsoMorphicString {
	/*
	 * 1) If lengths of str1 and str2 are not same, return false. 2) Do
	 * following for every character in str1 and str2 a) If this character is
	 * seen first time in str1, then current of str2 must have not appeared
	 * before. (i) If current character of str2 is seen, return false. Mark
	 * current character of str2 as visited. (ii) Store mapping of current
	 * characters. b) Else check if previous occurrence of str1[i] mapped to
	 * same character.
	 */

	public boolean isIsomorphic(String str1, String str2) {
		int size = 256;
		int m = str1.length();
		int n = str2.length();

		// Length of both strings must be same for one to one
		// corresponance
		if (m != n)
			return false;

		// To mark visited characters in str2
		Boolean[] marked = new Boolean[size];
		Arrays.fill(marked, Boolean.FALSE);

		// To store mapping of every character from str1 to
		// that of str2. Initialize all entries of map as -1.
		int[] map = new int[size];
		Arrays.fill(map, -1);

		// Process all characters one by on
		for (int i = 0; i < n; i++) {
			// If current character of str1 is seen first
			// time in it.
			if (map[str1.charAt(i)] == -1) {
				// If current character of str2 is already
				// seen, one to one mapping not possible
				if (marked[str2.charAt(i)] == true)
					return false;

				// Mark current character of str2 as visited
				marked[str2.charAt(i)] = true;

				// Store mapping of current characters
				map[str1.charAt(i)] = str2.charAt(i);
			}

			// If this is not first appearance of current
			// character in str1, then check if previous
			// appearance mapped to same character of str2
			else if (map[str1.charAt(i)] != str2.charAt(i))
				return false;
		}

		return true;

	}
}
