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

    /*
    You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Input words contain only lowercase letters.
Follow up:
Try to solve it in O(n log k) time and O(n) extra space.
     */
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
		Time is O(n*log(k)).
		 */
    public List<Integer> topKFrequentBetter(int[] nums, int k) {
        //count the frequency for each element
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num: nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }
        }

        // create a min heap
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return a.count-b.count;
            }
        });

        //maintain a heap of size k.
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            Pair p = new Pair(entry.getKey(), entry.getValue());
            queue.offer(p);
            if(queue.size()>k){
                queue.poll();
            }
        }

        //get all elements from the heap
        List<Integer> result = new ArrayList<Integer>();
        while(queue.size()>0){
            result.add(queue.poll().num);
        }
        //reverse the order
        Collections.reverse(result);

        return result;
    }

    class Pair{
        int num;
        int count;
        public Pair(int num, int count){
            this.num=num;
            this.count=count;
        }
    }
    //Time is O(n).
    public List<Integer> topKFrequentHashMap(int[] nums, int k) {
        //count the frequency for each element
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num: nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }
        }

        //get the max frequency
        int max = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            max = Math.max(max, entry.getValue());
        }

        //initialize an array of ArrayList. index is frequency, value is list of numbers
        ArrayList<Integer>[] arr = (ArrayList<Integer>[]) new ArrayList[max+1];
        for(int i=1; i<=max; i++){
            arr[i]=new ArrayList<Integer>();
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int count = entry.getValue();
            int number = entry.getKey();
            arr[count].add(number);
        }

        List<Integer> result = new ArrayList<Integer>();

        //add most frequent numbers to result
        for(int j=max; j>=1; j--){
            if(arr[j].size()>0){
                for(int a: arr[j]){
                    result.add(a);
                    //if size==k, stop
                    if(result.size()==k){
                        break;
                    }
                }
            }
        }

        return result;
    }
}
