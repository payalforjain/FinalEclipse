package leetcode.easy.numbers;

public class ExponentRecursion {
	public static int exponent(int base, int exponent) {
		int val = 1;
		for (int i = 0; i < exponent; i++) {
			val = val * base;
		}

		return val;
	}
}
