package leetcode.easy.arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElements {

	/*
	Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

	You may assume that the array is non-empty and the majority element always exist in the array.
	
	*/
	
	 public int majorityElement(int[] nums) {
		  if(nums.length ==0 || nums == null)
		  {
		      return 0;
		  }
		  
		  if (nums.length==1)
		  {
		      return nums[0];
		  }
		  int max = 0;
		  int maxCount = 0;
		  int exp = (nums.length)/2;
		  
		  Map<Integer,Integer> m = new HashMap<Integer, Integer>();
		  
		  
		  for(int n : nums)
		  {
			  if(m.containsKey(n))
			  {
				  int val = m.get(n) +1;
				  m.put(n, val);
				  if(val >= exp & maxCount< val)
				  {
					  max = n;
					  maxCount = val;
				  }
				  
			  }
			  
			  else
			  {
			      m.put(n, 1);
			  }
		  }
		  
		  
		    return max;
	        
	    }
	  
	  public static void main(String[] args)
	  {
		  MajorityElements m = new MajorityElements ();
		  
		  int[] a = {6,6,6,7,7};
				  m.majorityElement(a);
	  }
}
