package leetcode.easy.arrays;

import java.util.TreeSet;

public class SecondLargest {

	public static void secondLargest() {

		int[] randomIntegers = { 1, 5, 4, 2, 8, 1, 8, 9, 9 };
		TreeSet<Integer> set = new TreeSet<Integer>();
		for (int i : randomIntegers) {
			set.add(i);
		}
		// Remove the maximum value; print the largest remaining item

		int secondlargest = set.size() - 2;
		System.out.println(set.toArray()[secondlargest]);

	}
}
