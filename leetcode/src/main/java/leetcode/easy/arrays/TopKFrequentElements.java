package leetcode.easy.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.*;

public class TopKFrequentElements {
	 public List<Integer> topKFrequent(int[] nums, int k) {
			Map<Integer, Integer> m = new HashMap<Integer, Integer>();
			for (int tmp : nums) {

				if (m.containsKey(tmp)) {
					m.put(tmp, m.get(tmp) + 1);
				} else {
					m.put(tmp, 1);
				}
			}

			Set<Entry<Integer, Integer>> set = m.entrySet();
			List<Entry<Integer, Integer>> list = new ArrayList<Entry<Integer, Integer>>(set);

			Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
				public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
					return (o2.getValue()).compareTo(o1.getValue());
				}
			});

			int i = 0;
			List<Integer> out = new ArrayList<Integer>();
			for (Map.Entry<Integer, Integer> entry : list) {

				if (i > k - 1) {

					break;
				}

				out.add(entry.getKey());
				i++;
			}
			return out;
		}
/*

Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */

	public List<Integer> topKFrequentBetterSolution(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int n: nums){
			map.put(n, map.getOrDefault(n,0)+1);
		}

		TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
		for(int num : map.keySet()){
			int freq = map.get(num);
			if(!freqMap.containsKey(freq)){
				freqMap.put(freq, new LinkedList<>());
			}
			freqMap.get(freq).add(num);
		}

		List<Integer> res = new ArrayList<>();
		while(res.size()<k){
			Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
			res.addAll(entry.getValue());
		}
		return res;
	}
}
