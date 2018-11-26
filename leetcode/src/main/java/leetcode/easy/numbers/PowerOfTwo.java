package leetcode.easy.numbers;

public class PowerOfTwo {

    /*
    Input: 1
Output: true
Explanation: 20 = 1
Example 2:

Input: 16
Output: true
Explanation: 24 = 16
Example 3:

Input: 218
Output: false
     */
    private static boolean checkPowerOfTwo(int number) {
        if (number <= 0) {
            return false;
        }

        return ((number & (number - 1)) == 0);
    }

    public boolean isPowerOfTwo(int n) {

        if (n == 0)
            return false;

        if (n == 1)
            return true;

        if (n > 1)
            return n % 2 == 0 && isPowerOfTwo(n / 2);
        else
            return false;

    }


    // Write a method to convert an integer into a roman numeral string

    /*
     * checking if number is power of 2 using bit shift operator in java e.g. 4
     * in binary format is "0000 0000 0000 0000 0000 0000 0000 0100"; and -4 is
     * "1111 1111 1111 1111 1111 1111 1111 1100"; and 4&-4 will be
     * "0000 0000 0000 0000 0000 0000 0000 0100"
     */
    private static boolean isPowerOfTwoBit(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("number: " + number);
        }
        if ((number & -number) == number) {
            return true;
        }
        return false;
    }

    /*
     * checking if number is power of 2 using brute force starts with 1,
     * multiplying with 2 it will eventually be same as original number
     */
    private static boolean powerOfTwo(int number) {
        int square = 1;
        while (number >= square) {
            if (number == square) {
                return true;
            }
            square = square * 2;
        }
        return false;
    }

    /*
     * find if an integer number is power of 2 or not using bit shift operator
     */


}
