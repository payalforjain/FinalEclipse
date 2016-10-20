package domain.algorithm.strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Pangrams {

	
	public static void main(String[] args) {

		Set<Character> s = new HashSet();
		Scanner a = new Scanner(System.in);
		String act = a.nextLine().toLowerCase().trim();
		char[] ch = act.toCharArray();
        for (char c : ch) {
           s.add(c);

		}
		s.remove(' ');
		String result = s.size() == 26 ? "pangram" : "not pangram";
		System.out.println(result);
	}
	    
}
