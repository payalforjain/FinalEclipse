package leetcode.easy.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class SortCharactersByFrequency {
	
	  public String frequencySort(String s) {
		  
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
