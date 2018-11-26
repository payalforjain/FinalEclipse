package leetcode.easy.numbers;

public class ArrangeCoins {

/*
You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:

n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.
Example 2:

n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

 */
    public int arrangeCoins(int n) {

        if (n <= 1) return n;
        long low = 1, high = n;
        while (low < high) {
            long mid = low + (high - low) / 2;
            if (mid * (mid + 1) / 2 <= n) low = mid + 1;
            else high = mid;
        }
        return (int)low - 1;

    }

    public int arrangeCoins2(int n) {

        int cur = 0, rem = n - 1;
        while (cur <= rem) {
            ++cur;
            rem -= cur;
        }
        return n == 0 ? 0 : cur;

    }
}
