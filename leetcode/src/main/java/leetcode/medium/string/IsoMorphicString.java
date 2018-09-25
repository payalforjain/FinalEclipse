package leetcode.medium.string;

import java.util.Arrays;
import java.util.HashMap;

public class

IsoMorphicString {
/*	Given two strings s and t, determine if they are isomorphic.

	Two strings are isomorphic if the characters in s can be replaced to get t.

	All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

	Example 1:

	Input: s = "egg", t = "add"
	Output: true
	Example 2:

	Input: s = "foo", t = "bar"
	Output: false
	Example 3:

	Input: s = "paper", t = "title"
	Output: true
	Note:
	You may assume both s and t have the same length.
*/
/* An Efficient Solution can solve this problem in O(n) time. The idea is to create an array to store mappings of processed characters.
1) If lengths of str1 and str2 are not same, return false.
2) Do following for every character in str1 and str2
   a) If this character is seen first time in str1,
      then current of str2 must have not appeared before.
      (i) If current character of str2 is seen, return false.
          Mark current character of str2 as visited.
      (ii) Store mapping of current characters.
   b) Else check if previous occurrence of str1[i] mapped
      to same character.
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

	//Time complexity is O(n*n).

	public boolean isIsomorphicBad(String s, String t) {
		if(s==null||t==null)
			return false;

		if(s.length()!=t.length())
			return false;

		HashMap<Character, Character> map = new HashMap<Character, Character>();


		for(int i=0; i<s.length(); i++){
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);

			if(map.containsKey(c1)){
				if(map.get(c1)!=c2)// if not consistant with previous ones
					return false;
			}else{
				if(map.containsValue(c2)) //if c2 is already being mapped. Time complexity O(n) here
					return false;
				map.put(c1, c2);
			}
		}

		return true;
	}
}
