package leetcode.easy.arrays;

import java.util.HashMap;
import java.util.Map;

public class OddNumberTimes {

	public static void oddnumberstime(int[] a) {
		HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();

		for (int i = 0; i < a.length; i++) {
			if (m.containsKey(a[i])) {
				int v = m.get(a[i]);
				m.put(a[i], v + 1);

			}

			else {
				m.put(a[i], 1);
			}
		}

		for (Map.Entry<Integer, Integer> d : m.entrySet()) {
			if (d.getValue() % 2 == 1) {
				System.out.println(d.getKey() + " = " + d.getValue());
			}
		}

	}

}
