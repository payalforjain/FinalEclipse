package leetcode.medium.graph;
import java.util.*;
public class CombinationalSum {
/*
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 */

    public List<List<Integer>> combinationSumBFS(int[] cands, int t) {
        Arrays.sort(cands); // sort candidates to try them in asc order
        List<List<List<Integer>>> dp = new ArrayList<>();
        for (int i = 1; i <= t; i++) { // run through all targets from 1 to t
            List<List<Integer>> newList = new ArrayList(); // combs for curr i
            // run through all candidates <= i
            for (int j = 0; j < cands.length && cands[j] <= i; j++) {
                // special case when curr target is equal to curr candidate
                if (i == cands[j]) newList.add(Arrays.asList(cands[j]));
                    // if current candidate is less than the target use prev results
                else for (List<Integer> l : dp.get(i-cands[j]-1)) {
                    if (cands[j] <= l.get(0)) {
                        List cl = new ArrayList<>();
                        cl.add(cands[j]); cl.addAll(l);
                        newList.add(cl);
                    }
                }
            }
            dp.add(newList);
        }
        return dp.get(t-1);
    }

    public List<List<Integer>> combinationSumDFS(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }
/*
Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
 */
    private void backtrack(List<List<Integer>> result, List<Integer> current, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) result.add(new ArrayList<>(current));
        else{
            for(int i = start; i < nums.length; i++){
                current.add(nums[i]);
                backtrack(result, current, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                current.remove(current.size() - 1);
            }
        }
    }

    public static void main(String[] args)
    {
        CombinationalSum s = new CombinationalSum();
        System.out.println(s.combinationSum2DFS(new int[] {2,3,6,7} , 7));
    }
    //Combination Sum II (can't reuse same element)

    public List<List<Integer>> combinationSum2DFS(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack2(list, new ArrayList<>(), nums, target, 0);
        return list;

    }

    private void backtrack2(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                if(i > start && nums[i] == nums[i-1])
                    continue; // skip duplicates
                tempList.add(nums[i]);
                backtrack2(list, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
