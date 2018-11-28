package leetcode.easy.numbers;

public class CublicRoot {

    /*
    Initialize start = 0 and end = n
Calculate mid = (start + end)/2
Check if the absolute value of (n – mid*mid*mid) < e. If this condition holds true then mid is our answer so return mid.
If (mid*mid*mid)>n then set end=mid
If (mid*mid*mid)<n set start=mid.
     */
    static double cubicRoot(double n)
    {
        // Set start and end for binary search
        double start = 0, end = n;

        // Set precision
        double e = 0.0000001;

        while (true)
        {
            double mid = (start + end)/2;
            double error = diff(n, mid);

            // If error is less than e then mid is
            // our answer so return mid
            if (error <= e)
                return mid;

            // If mid*mid*mid is greater than n set
            // end = mid
            if ((mid*mid*mid) > n)
                end = mid;

                // If mid*mid*mid is less than n set
                // start = mid
            else
                start = mid;
        }
    }

    static double diff(double n,double mid)
    {
        if (n > (mid*mid*mid))
            return (n-(mid*mid*mid));
        else
            return ((mid*mid*mid) - n);
    }
}
