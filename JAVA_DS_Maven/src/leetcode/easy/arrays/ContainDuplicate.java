package leetcode.easy.arrays;

import java.util.HashMap;
import java.util.Map;

public class ContainDuplicate {
	
	/*
	 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] 
	 * and the absolute difference between i and j is at most k.
	 */
	  public boolean containsNearbyDuplicate(int[] nums, int k) {
	        
		  Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		  
		  
		  for(int i =0; i< nums.length; i++)
		  {
			  if(m.containsKey(nums[i]))
			  {
				  int val  = m.get(nums[i]);
				  if( i - val <= k)
				  {
					  return true;
				  }
			  }
			  
            m.put(nums[i], i);
		  }
	        
	     
		  
		  return false;
	    }
}
