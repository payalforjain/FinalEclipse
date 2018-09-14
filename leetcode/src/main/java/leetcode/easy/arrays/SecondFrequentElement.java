package leetcode.easy.arrays;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class SecondFrequentElement {

	// determine the second frequent number in an input array

	public static void secFreqElement() {
		int array[] = { 12, 12, 12, 13, 14, 133, 155, 166, 134, 123, 123, 1234, 12, 12345 };

		SortedMap<Integer, Integer> sMap = new TreeMap<Integer, Integer>();
		sMap.put(array[0], 1);
		int temp;
		for (int i = 1; i < array.length; i++) {

			if (sMap.get(array[i]) != null) {
				temp = sMap.get(array[i]);
				sMap.put(array[i], temp + 1);
			} else {
				sMap.put(array[i], 1);
			}
			temp = 0;
		}
		System.out.println(sMap);

		TreeSet<Integer> treeSet = new TreeSet<Integer>(sMap.values());
		int sechigh = treeSet.size() - 2;
		System.out.println(treeSet.toArray()[sechigh]);

		for (Map.Entry<Integer, Integer> entry : sMap.entrySet()) {
			if (entry.getValue().equals(treeSet.toArray()[sechigh])) {
				System.out.println("1st higest value is" + entry.getKey());
			}
		}

	}

}
