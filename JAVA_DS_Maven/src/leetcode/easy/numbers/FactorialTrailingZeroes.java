package leetcode.easy.numbers;

public class FactorialTrailingZeroes {
	/*
	 * iven an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

Seen this question in a real interview before?   Yes  
	 */
	
	 public int trailingZeroes(int n) {
	        int sum = 0;
	        while(n > 0){
	            // 阶乘中有多少5，结果就有多少个0
	            sum += n / 5;
	            n /= 5;
	        }
	        return sum;
	    }

}
