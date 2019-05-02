package leetcode.easy.arrays;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class SortCharactersByFrequency {

	/*
	Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
	 */
	public String frequencySort(String s) {

		if(s == null || s.length() == 0)
			return s;
		StringBuilder result = new StringBuilder();
		Map<Character,Integer> map = new HashMap<>();
		PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(  (e1 , e2 ) ->  e2.getValue() -  e1.getValue() );

		for(char c : s.toCharArray())
		{
			if(map.containsKey(c))
				map.put(c ,    map.getOrDefault(c, 0) + 1) ;
			else
				map.put(c, 1);
		}


		pq.addAll(map.entrySet());
		while(!pq.isEmpty())
		{
			Map.Entry<Character, Integer> temp = pq.poll();
			int i = 0;
			while(i < temp.getValue() )
			{
				result.append(temp.getKey());
				i++;
			}
		}
		return result.toString();
	}
	
	  public String frequencySortCrap(String s) {
		  
		    char[] str = s.toCharArray(); 
			Map<Character, Integer> m = new HashMap<Character, Integer>();
			for (char tmp : str) {

				if (m.containsKey(tmp)) {
					m.put(tmp, m.get(tmp) + 1);
				} else {
					m.put(tmp, 1);
				}
			}

			Set<Entry<Character, Integer>> set = m.entrySet();
			List<Entry<Character, Integer>> list = new ArrayList<Entry<Character, Integer>>(set);

			Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
				public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
					return (o2.getValue()).compareTo(o1.getValue());
				}
			});

			 StringBuilder sb = new StringBuilder();
			for (Map.Entry<Character, Integer> entry : list) {
            for(int i =0 ; i< entry.getValue();i++)
            {
          	  sb.append(entry.getKey());
            }
			  
			}
			return sb.toString();
	        
	    }

}
