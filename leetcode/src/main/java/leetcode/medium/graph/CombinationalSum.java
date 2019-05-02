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

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>>  result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        dfs(candidates ,target, 0 ,0, current , result);
        return result;
    }

    private void dfs(int[] candidates, int target , int currentSum ,int start , List<Integer> current ,List<List<Integer>>  result )
    {
        if( currentSum > target )
            return ;
        else if ( currentSum == target)
            result.add( new ArrayList(current));
        else
        {
            for(int i = start ; i < candidates.length ;i++)
            {
                current.add(candidates[i]);
                currentSum = currentSum + candidates[i];
                dfs(candidates, target ,currentSum , i ,current , result);
                current.remove(current.size() - 1);
                currentSum = currentSum - candidates[i];
            }
        }
    }

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


/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
 */

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>>  result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        dfs2(candidates ,target, 0 ,0, current , result);
        return result;
    }

    private void dfs2(int[] candidates, int target , int currentSum ,int start , List<Integer> current ,List<List<Integer>>  result )
    {
        if( currentSum > target )
            return ;
        else if ( currentSum == target)
        {
            List<Integer> temp = new ArrayList(current);
            if(!result.contains(temp))
            {
                result.add(temp );
            }
        }


        else
        {
            for(int i = start ; i < candidates.length ;i++)
            {

                current.add(candidates[i]);
                currentSum = currentSum + candidates[i];
                dfs2(candidates, target ,currentSum , i + 1 ,current , result);
                current.remove(current.size() - 1);
                currentSum = currentSum - candidates[i];


            }
        }
    }

   // better memort than before
    public List<List<Integer>> combinationSum2BetterMemory(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;

    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
