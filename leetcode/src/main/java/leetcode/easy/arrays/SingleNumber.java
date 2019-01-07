package leetcode.easy.arrays;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SingleNumber {
	//Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
	//Given an array of integers, every element appears twice except for one. Find that single one.
    public int singleNumber(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for(int num : nums)
        {
            if(set.contains(num))
            {
                set.remove(num);
            }

            else
            {
                set.add(num);
            }
        }


        Iterator<Integer> it = set.iterator();
        return it.next();
    }

}
