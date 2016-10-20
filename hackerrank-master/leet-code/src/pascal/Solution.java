import java.util.*;
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        curr.add(1);
        ret.add(curr);
        if (numRows == 1) {
        	return ret;
        }
        for (int i = 1; i < numRows; i++) {
        	List<Integer> next = new ArrayList<Integer>();
        	next.add(1);
        	for (int j = 1; j < curr.size(); j++) {
        		next.add(curr.get(j - 1) + curr.get(j));
        	}
        	next.add(1);
        	ret.add(next);
        	curr = next;
        }
        return ret;
    }
    public static void main(String[] args) {
    	Solution s = new Solution();
    	for (List<Integer> a : s.generate(10)) {
    		System.out.println(a);
    	}
    }
}