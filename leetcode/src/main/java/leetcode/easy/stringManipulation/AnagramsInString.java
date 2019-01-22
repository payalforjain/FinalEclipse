package leetcode.easy.stringManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class AnagramsInString {
/*
iven two strings s and t, write a function to determine if t is an anagram of s.
For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.
Note:
You may assume the string contains only lowercase alphabets.
Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */

/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> output = new ArrayList<>();

		if (s == null || p == null || s.length() == 0 || p.length() == 0) {
			return output;
		}

		int length = p.length();
		for (int i = 0; i < s.length() - length + 1; i++) {
			String temp = s.substring(i, i + length);
			if (checkAnagram(temp, p)) {
				output.add(i);
			}
		}
		return output;
	}



//Better Solution
	public static boolean checkAnagram(String first, String second) {
		char[] characters = first.toCharArray();
		StringBuilder sbSecond = new StringBuilder(second);
		for (char ch : characters) {
			int index = sbSecond.indexOf("" + ch);
			if (index != -1) {
				sbSecond.deleteCharAt(index);
			} else {
				return false;
			}
		}
		return sbSecond.length() == 0 ? true : false;
	}

	//excellent solution
	public boolean isAnagramSecond(String s, String t) {
		if (s.length() != t.length()) return false;
		int[] table = new int[26];
		for (char c : s.toCharArray()) {
			table[c - 'a']++;
		}
		for (char c : t.toCharArray()) {
			table[c - 'a']--;
			if (table[c - 'a'] < 0) return false;
		}
		return true;
	}
	/*What if the inputs contain unicode characters? How would you adapt your solution to such case?
	Answer: Use a hash table instead of a fixed size counter. Imagine allocating a large size array to fit the entire range of unicode characters, which could go up to more than 1 million. A hash table is a more generic solution and could adapt to any range of characters.
	https://leetcode.com/discuss/49787/3-solutions-sort-hash-array-and-prime
	Use primes to generate hashcode.
 */
	private static final int[] PRIMES = new int[]{3, 5, 7, 11 ,13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
			73, 79, 83, 89, 97, 101, 107};
	public boolean isAnagramunicode(String s, String t) {
		return hash(s) == hash(t);
	}

	private long hash(String s) {
		long hash = 1;
		for (int i = 0; i < s.length(); i++) {
			hash *= PRIMES[s.charAt(i) - 'a'];
		}
		return hash;
	}
/*
Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
 */
/*
Analysis
An anagram is a type of word play, the result of rearranging the letters of a word or phrase to produce a new word or phrase,\
 using all the original letters exactly once; for example, Torchwood can be rearranged into Doctor Who.

If two strings are anagram to each other, their sorted sequence is the same.
 */


	public List<List<String>> groupAnagramsChar(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<>();
		for(String str : strs)
		{
			char[] ch = new char[26];
			for(char c : str.toCharArray() )
			{
				ch[c-'a']++;
			}

			String key = new String(ch);

			if(map.containsKey(key))
				map.get(key).add(str);
			else
			{
				List<String> temp = new ArrayList();
				temp.add(str);
				map.put(key, temp );
			}

		}
		result.addAll(map.values());
		return result;
	}


}
