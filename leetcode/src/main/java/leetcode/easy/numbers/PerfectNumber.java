package leetcode.easy.numbers;

public class PerfectNumber {

	//Better Solution than second
	public boolean checkPerfectNumber(int num) {

		if (num <= 0) {
			return false;
		}
		int sum = 0;
		for (int i = 1; i * i <= num; i++) {
			if (num % i == 0) {
				sum += i;
				if (i * i != num) {
					sum += num / i;
				}

			}
		}
		return sum - num == num;

	}

	/*
	 * A perfect number is a positive integer that is equal to the sum of its
	 * proper positive divisors, that is, the sum of its positive divisors
	 * excluding the number itself. Equivalently, a perfect number is a number
	 * that is half the sum of all of its positive divisors. The first perfect
	 * number is 6, because 1, 2 and 3 are its proper positive divisors, and 1 +
	 * 2 + 3 = 6. Equivalently, the number 6 is equal to half the sum of all its
	 * positive divisors: ( 1 + 2 + 3 + 6 ) / 2 = 6.
	 */

	public boolean isPerfectNumber(int number) {

		int temp = 0;
		for (int i = 1; i <= number / 2; i++) {
			if (number % i == 0) {
				temp += i;
			}
		}
		if (temp == number) {
			System.out.println("It is a perfect number");
			return true;
		} else {
			System.out.println("It is not a perfect number");
			return false;
		}
	}

}
