package leetcode.easy.numbers;

public class NumberComplement {

	/*
	 * Input: 5 Output: 2 Explanation: The binary representation of 5 is 101 (no
	 * leading zero bits), and its complement is 010. So you need to output 2.
	 */
	public int findComplement(int num) {

		return (1 - num % 2) + 2 * (num <= 1 ? 0 : findComplement(num / 2));

	}
}
