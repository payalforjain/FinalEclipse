package leetcode.easy.stringManipulation;

public class RotatedString {

	/*
	 * 1) add s1 + s1 = sAdd 2) sAdd.contains(s2)


	// Find if a string is rotation of another string ex. abcd , dabc is
	// rotation of abcd

	Complexity Analysis

	Time Complexity: O(N^2)O(N
2
		), where NN is the length of A.

	Space Complexity: O(N)O(N), the space used building A+A.
		 */
	public boolean rotateString(String A, String B) {
		return A.length() == B.length() && (A + A).contains(B);
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

	public boolean rotateStringBetter(String A, String B) {
		int N = A.length();
		if (N != B.length()) return false;
		if (N == 0) return true;

		//Compute shift table
		int[] shifts = new int[N+1];
		Arrays.fill(shifts, 1);
		int left = -1;
		for (int right = 0; right < N; ++right) {
			while (left >= 0 && (B.charAt(left) != B.charAt(right)))
				left -= shifts[left];
			shifts[right + 1] = right - left++;
		}

		//Find match of B in A+A
		int matchLen = 0;
		for (char c: (A+A).toCharArray()) {
			while (matchLen >= 0 && B.charAt(matchLen) != c)
				matchLen -= shifts[matchLen];
			if (++matchLen == N) return true;
		}

		return false;
	}
	/*
	Complexity Analysis

Time Complexity: O(N), where NN is the length of A.

Space Complexity: O(N) to create the shift table shifts.
	 */

}
