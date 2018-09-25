package leetcode.easy.numbers;

public class FibonacciSeries {
    /*
    The Fibonacci numbers are the numbers in the following integer sequence.
    0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..

    In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the recurrence relation

        Fn = Fn-1 + Fn-2
    with seed values

       F0 = 0 and F1 = 1.
     */
    /*
    Time Complexity: O(n)
Extra Space: O(1)
     */
    int fibDynammic(int n)
    {
        int a = 0, b = 1, c;
        if (n == 0)
            return a;
        for (int i = 2; i <= n; i++)
        {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
    //Exponential
    int fib(int n)
    {
        if (n <= 1)
            return n;
        return fib(n-1) + fib(n-2);
    }
}
