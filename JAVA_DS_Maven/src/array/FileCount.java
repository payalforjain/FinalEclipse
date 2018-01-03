package array;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class FileCount {

	public Map<String, Integer> wordcou(String Filename)

	{
		Map<String, Integer> m = new HashMap<String, Integer>();
		File f = new File(Filename);
		String maxstring = "";
		int maxwords = 0;

		try {
			Scanner sc = new Scanner(f);

			while (sc.hasNext()) {
				String tmp = sc.next().replaceAll("[^a-zA-Z]+", "");

				if (!tmp.equals("")) {
					if (m.containsKey(tmp)) {
						m.put(tmp, m.get(tmp) + 1);
					} else {
						m.put(tmp, 1);
					}

					if (maxwords < m.get(tmp)) {
						maxwords = m.get(tmp);
						maxstring = tmp;
					}

				}
			}

			System.out.println("Max String is" + maxstring + "maxwords is " + maxwords);
		}

		catch (FileNotFoundException e) {
			System.out.println(e);
		}

		// converting Map to Array
		Set<Entry<String, Integer>> set = m.entrySet();
		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);

		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});
		for (Map.Entry<String, Integer> entry : list) {
			System.out.println(entry.getKey() + " ==== " + entry.getValue());
		}

		return m;
	}

	public static void main(String arg[]) {
		FileCount s = new FileCount();
		s.wordcou("C:/Users/heman/Desktop/test.txt");
	}

}
