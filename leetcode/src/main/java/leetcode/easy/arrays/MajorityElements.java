package leetcode.easy.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElements {

	/*
	Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

	You may assume that the array is non-empty and the majority element always exist in the array.
	
	*/

    // better colutuon there check leetcode

    public int majorityElement(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }
        int max = 0;
        int maxCount = 0;
        int exp = (nums.length) / 2;

        Map<Integer, Integer> m = new HashMap<Integer, Integer>();


        for (int n : nums) {
            if (m.containsKey(n)) {
                int val = m.get(n) + 1;
                m.put(n, val);
                if (val >= exp & maxCount < val) {
                    max = n;
                    maxCount = val;
                }

            } else {
                m.put(n, 1);
            }
        }


        return max;

    }


    public int majorityElementBest(int[] nums) {
        int result = 0, count = 0;

        for(int i = 0; i<nums.length; i++ ) {
            if(result == nums[i]){
                count++;
            }

            else   if(count == 0){
                result = nums[ i ];
                count = 1;
            }else{
                count--;
            }
        }

        return result;
    }

    /*
    Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

    Note: The algorithm should run in linear time and in O(1) space.

    Example 1:

    Input: [3,2,3]
    Output: [3]
    Example 2:

    Input: [1,1,1,3,3,2,2,2]
    Output: [1,2]
     */
    public List<Integer> majorityElement2BEst(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();

        Integer n1=null, n2=null;
        int c1=0, c2=0;

        for(int i: nums){
            if(n1!=null && i==n1.intValue()){
                c1++;
            }else if(n2!=null && i==n2.intValue()){
                c2++;
            }else if(c1==0){
                c1=1;
                n1=i;
            }else if(c2==0){
                c2=1;
                n2=i;
            }else{
                c1--;
                c2--;
            }
        }

        c1=c2=0;

        for(int i: nums){
            if(i==n1.intValue()){
                c1++;
            }else if(i==n2.intValue()){
                c2++;
            }
        }

        if(c1>nums.length/3)
            result.add(n1);
        if(c2>nums.length/3)
            result.add(n2);

        return result;
    }

	/*
	Time = O(n) and Space = O(1)
	 */

    /*
    Time = O(n) and Space = O(n)
*/
    public List<Integer> majorityElementMap(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        List<Integer> result = new ArrayList<Integer>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 3) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

}
