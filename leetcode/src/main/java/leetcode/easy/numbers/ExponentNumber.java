package leetcode.easy.numbers;

public class ExponentNumber {

    /*
    Input : x = 2, n = 3
    Output : 8

    Input : x = 7, n = 2
    Output : 49
     */
    public int exponent(int base, int exponent) {
        int val = 1;
        for (int i = 0; i < exponent; i++) {
            val = val * base;
        }

        return val;
    }

    public int exponentRecursion(int base, int exponent) {
        if (exponent == 0)
            return 1;
        else
            return exponentRecursion(base, exponent - 1) * base;
    }

    /*

    Time Complexity: O(n)
    Space Complexity: O(1)
    Algorithmic Paradigm: Divide and conquer.

    Above function can be optimized to O(logn) by calculating power(x, y/2) only once and storing it.
   */
    /* Function to calculate x raised to the power y in O(logn)*/
    int power(int x,  int y)
    {
        int temp;
        if( y == 0)
            return 1;
        temp = power(x, y/2);
        if (y%2 == 0)
            return temp*temp;
        else
            return x*temp*temp;
    }

    //Time Complexity of optimized solution: O(logn)
    static float power2(float x, int y)
    {
        float temp;
        if( y == 0)
            return 1;
        temp = power2(x, y/2);

        if (y%2 == 0)
            return temp*temp;
        else
        {
            if(y > 0)
                return x * temp * temp;
            else
                return (temp * temp) / x;
        }
    }

    /* Program to test function power */
    public static void main(String[] args)
    {
        float x = 2;
        int y = -3;
        System.out.printf("%f", power2(x, y));
    }
}
