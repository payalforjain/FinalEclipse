package leetcode.medium.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;
public class Permutation {

    /*
    Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
Time complexity : \mathcal{O}(\sum_{k = 1}^{N}{P(N, k)})O(∑
k=1
N
​
 P(N,k)) where P(N, k) = \frac{N!}{(N - k)!} = N (N - 1) ... (N - k + 1)P(N,k)=
(N−k)!
N!
​
 =N(N−1)...(N−k+1) is so-called k-permutations_of_n, or partial permutation.
     */

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>  result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        dfs(nums , current , result);
        return result;
    }

    private void dfs(int[] nums, List<Integer> current ,List<List<Integer>>  result )
    {

        if ( current.size() == nums.length)
            result.add( new ArrayList(current));
        else
        {
            for(int i = 0 ; i < nums.length ;i++)
            {
                if(!current.contains(nums[i]))
                {
                    current.add(nums[i]);
                    dfs(nums, current , result);
                    current.remove(current.size() - 1);
                }


            }
        }
    }

    /*
    Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
     */

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];

        List<Integer> item = new ArrayList<Integer>();
        helper(res, item, nums, used);

        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> item, int[] nums, boolean[] used){
        if (item.size() == nums.length){
            res.add(new ArrayList<Integer>(item));
            return;
        }

        for (int i = 0; i < nums.length; i++){
            if(used[i]){
                continue;
            }

            if (i > 0 && nums[i] == nums[i-1] && used[i-1] == false){
                continue;
            }

            item.add(nums[i]);
            used[i] = true;
            helper(res, item, nums, used);
            item.remove(item.size()-1);
            used[i] = false;
        }
    }
}
