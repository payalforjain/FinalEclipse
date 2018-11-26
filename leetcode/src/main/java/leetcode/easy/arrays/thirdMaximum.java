package leetcode.easy.arrays;
import java.util.*;
public class thirdMaximum {

	/*


Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.
Example 2:
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
Example 3:
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.
	 */
	public int thirdMax(int[] nums) {
	    long max = Long.MIN_VALUE, mid = max, min = max;
	        
	    for (int ele : nums) {
	        if (ele > max) {
	            min = mid;
	            mid = max;
	            max = ele;
	        } else if (max > ele && ele > mid) {
	            min = mid;
	            mid = ele;
	        } else if (mid > ele && ele > min) {
	            min = ele;
	        }
	    }
	        
	    return (int)(min != Long.MIN_VALUE ? min : max);
	}
	/*
	time complexity is 0(n)
	 space is o(1)
	 */

	public int thirdMaxSet(int[] nums) {
		TreeSet<Integer> set = new TreeSet<>();
		for(int num : nums) {
			set.add(num);
			if(set.size() > 3) {
				set.remove(set.first());
			}
		}
		return set.size() == 3 ? set.first() : set.last();
	}

		/*
	time complexity is 0(n)
	 space is o(n)
	 */
}
