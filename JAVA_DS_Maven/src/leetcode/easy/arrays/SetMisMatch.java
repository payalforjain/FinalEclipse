package leetcode.easy.arrays;

import java.util.HashSet;
import java.util.Set;

public class SetMisMatch {
	
	  public int[] findErrorNums(int[] nums) {
	     
		  int[] output = new int[2];
		  Set<Integer> s = new HashSet<Integer>();
		  for(int i=0; i<nums.length ;i++)
		  {
			  if(s.contains(nums[i]))
			  {
				  output[0] = nums[i-1];
				  output[1] = nums[i];
			  }
			  s.add(nums[i]);
		  }
		  return output;
	    }

}
