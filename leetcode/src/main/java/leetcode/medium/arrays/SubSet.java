package leetcode.medium.arrays;
import java.util.*;
public class SubSet {

    /*
    Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
     */
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        Arrays.sort(nums);
        List<Integer> current = new ArrayList<>();
        dfs(nums, result, current, 0);
        return result;
    }

    private void dfs(int[] nums,List<List<Integer>> result,  List<Integer> current, int start)
    {
        result.add(new ArrayList<>(current));
        for(int i = start ; i < nums.length ; i++)
        {
            current.add(nums[i]);
            dfs(nums, result, current, i+1);
            current.remove(current.size() -1);
        }
    }


    /*
    Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
     */

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, res, 0, cur);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, int start, List<Integer> cur){
        res.add(new ArrayList<Integer>(cur));

        for(int i=start; i< nums.length; i++){
            if(i != start && nums[i] == nums[i-1]) continue;
            cur.add(nums[i]);
            dfs(nums, res, i+1, cur);
            cur.remove(cur.size()-1);
        }
    }
}
