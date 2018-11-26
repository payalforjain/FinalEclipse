package leetcode.easy.numbers;

public class SquareRoot {
	/*
	 * Implement int sqrt(int x).
	 * 
	 * Compute and return the square root of x.
	 * 
	 * x is guaranteed to be a non-negative integer.
	 * Othere solution gives time exceeded 
	 */
	//// Running time: 47 ms  Binary Search time complexty o(logx)
	public int mySqrt(int x) {

		if (x <= 1)
			return x;
		int start = 0, end = x;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (x / mid == mid)
				return mid;
			else if (x / mid < mid)
				end = mid - 1;
			else
				start = mid + 1;
		}
		return end;
	}

//Running time: 44 ms New ton Method. see google for newton method calcaulation
	//time complexty o(logx)
		public int mySqrtNewTon(int a) {
			long x = a;
			while (x * x > a)
				x = (x + a / x) / 2;
			return (int)x;
		}
}
