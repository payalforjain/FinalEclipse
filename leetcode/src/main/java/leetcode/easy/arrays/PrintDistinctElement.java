package leetcode.easy.arrays;

public class PrintDistinctElement {
	
	// how to avoid duplicate elements from asn array and disply only distinct
	// elements. Please use only arrays to process it.
	// if u want with better performance use Set
	public static void printDistinctElements(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			boolean isDistinct = false;
			for (int j = 0; j < i; j++) {
				if (arr[i] == arr[j]) {
					isDistinct = true;
					break;
				}
			}
			if (!isDistinct) {
				System.out.print(arr[i] + " ");
			}
		}
	}

}
