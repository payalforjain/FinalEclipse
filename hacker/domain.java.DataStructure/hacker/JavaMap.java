package hacker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class JavaMap {
	/*
	 * Input Format
	 * 
	 * The first line will have an integer denoting the number of entries in the
	 * phone book. Each entry consists of two lines: a name and the
	 * corresponding phone number.
	 * 
	 * After these, there will be some queries. Each query will contain a
	 * person's name. Read the queries until end-of-file.
	 * 
	 * Constraints: A person's name consists of only lower-case English letters
	 * and it may be in the format 'first-name last-name' or in the format
	 * 'first-name'. Each phone number has exactly 8 digits without any leading
	 * zeros.
	 * 
	 * 
	 * 
	 * 
	 * Output Format
	 * 
	 * For each case, print "Not found" if the person has no entry in the phone
	 * book. Otherwise, print the person's name and phone number. See sample
	 * output for the exact format.
	 * 
	 * To make the problem easier, we provided a portion of the code in the
	 * editor. You can either complete that code or write completely on your
	 * own.
	 */

	public static void main(String[] argh) {
		Scanner in = new Scanner(System.in);
		Map<String, Integer> m = new HashMap<String, Integer>();
		List<String> l = new ArrayList<String>();
		int n = in.nextInt();

		in.nextLine();
		for (int i = 0; i < n; i++) {
			String name = in.nextLine();
			int phone = in.nextInt();
			m.put(name, phone);
			in.nextLine();
		}
		while (in.hasNext()) {
			String s = in.nextLine();
			l.add(s);
		}

		for (String s : l) {
			if (m.get(s) == null) {
				System.out.println("Not found");
			} else {
				System.out.println(s + "=" + m.get(s));
			}
		}
	}
}