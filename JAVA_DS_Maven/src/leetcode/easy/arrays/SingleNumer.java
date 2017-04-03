package leetcode.easy.arrays;

import java.util.HashSet;
import java.util.Set;

public class SingleNumer {
	//Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
	//Given an array of integers, every element appears twice except for one. Find that single one.
	public int singleNumber(int[] nums) {
		 
        Set<Integer> s = new HashSet<Integer>();
        for(int i = 0 ; i<nums.length; i++)
        {
            if(s.contains(nums[i]))
            {
                s.remove(nums[i]);
            }
            else
            {
               s.add(nums[i]);
            }   
        }
        
        
        return s.toArray(new Integer[s.size()])[0];
        
    }

}
