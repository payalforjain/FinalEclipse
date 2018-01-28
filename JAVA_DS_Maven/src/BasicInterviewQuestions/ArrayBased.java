package BasicInterviewQuestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayBased {

	public static void basicArray() {
		String[] a = { "a", "b", "c" };
		List<String> l = Arrays.asList(a);
		System.out.println(l);

		int[] myArr = { 2, 4, 2, 4, 5, 6, 3 };
		System.out.println("Array size before copy: " + myArr.length);
		int[] newArr = Arrays.copyOf(myArr, 10);
		System.out.println("New array size after copying: " + newArr.length);

		Arrays.sort(newArr);
		for (int i = 0; i < newArr.length; i++)
			System.out.println(newArr[i]);

		int[] n = Arrays.copyOfRange(myArr, 1, 4);

		for (int num : n) {
			System.out.print(num + "  ");
		}

		int[] s = { 5, 6, 6 };
		int[] d = { 5, 6, 6 };
		System.out.println("Are strArr and strArrCopy same? " + Arrays.equals(s, d));

		// Arrays.fill(myArr, "Assigned"); Arrays.fill() helps us to fill an
		// empty array with default values

		/*
		 * tring[] strArr = {"JAVA", "C++", "PERL", "STRUTS", "PLAY"};
		 * Arrays.sort(strArr,new Comparator<String>(){
		 * 
		 * @Override public int compare(String o1, String o2) { return
		 * o1.compareTo(o2); }});
		 * 
		 * for(String str:strArr){ System.out.println(str); }
		 */

	}

	// Given an int[] multiply all numbers except index I/p {1,2,3,4} O/P
	// {24,12,8,6}
	public static void multiplication(String[] args) {
		int[] arr = { 1, 2, 3, 4 };
		int[] result = { 1, 1, 1, 1 };
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				result[i] *= arr[j];

			}
			for (int k = arr.length - 1; k > i; k--) {
				result[i] *= arr[k];
			}
		}
		for (int i : result) {
			System.out.println(i);
		}

	}

	public static void moveZerotoEnd(int[] a) {
		int start = 0;
		int end = 0;

		for (int i = 0; i < a.length; i++) {

			if (a[i] != 0)

			{

				int temp;
				temp = a[end];
				a[end] = a[i];
				a[i] = temp;
				end++;
			}

		}
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	public static void moveZerotoBegin(int[] a) {
		int start = 0;
		int end = 0;

		for (int i = 0; i < a.length; i++) {

			if (a[i] != 1)

			{

				int temp;
				temp = a[end];
				a[end] = a[i];
				a[i] = temp;
				end++;
			}

		}
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	public static void moveAllEvensToLeft(int[] a) {
		int start = 0;
		int end = 0;

		for (int i = 0; i < a.length; i++) {

			if (a[i] % 2 == 0)

			{

				int temp;
				temp = a[end];
				a[end] = a[i];
				a[i] = temp;
				end++;
			}

		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
	}

	public static void arraylist(Integer[] a) {

		List<Integer> list = Arrays.asList(a);
		Collections.sort(list);

		System.out.println(list); // prints [6, 5, 5, 2, 1, 0, 0]
		Collections.reverse(list);
		System.out.println(list);

	}

	private static final int MAX_ROW = 4;

	// Diagonal Format
	private static void diagonalFormatPrint(int[] array) {

		if (array == null || array.length == 0) {
			return;
		}

		// In the question, there are only 4 rows
		StringBuilder[] rows = new StringBuilder[MAX_ROW];
		for (int i = 0; i < rows.length; i++) {
			rows[i] = new StringBuilder();
		}

		// distance from left corner
		int distance = 0;

		for (int i = 0; i < array.length; distance++) {

			rows[0].append(array[i++]).append(" ");

			for (int j = 0; i < array.length && j < distance && j < rows.length - 1; j++, i++) {
				rows[j + 1].append(array[i]).append(" ");
			}
		}

		for (StringBuilder sb : rows) {
			System.out.println(sb.toString());
		}
	}

	public static int middleIndex(int[] a) throws Exception {
		int leftSum = 0;
		int rightSum = 0;
		int leftIndex = 0;
		int rightIndex = a.length - 1;

		while (true) {
			if (leftSum > rightSum) {

				rightSum = rightSum + a[rightIndex--];

			}

			else {
				leftSum = leftSum + a[leftIndex++];

			}

			if (leftIndex > rightIndex) {
				if (leftSum == rightSum) {
					break;
				}

				else
					throw new Exception("Enter proper Array");
			}

		}
		return rightIndex;
	}

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

	public static void main(String[] args) {

		int[] d = { 2, 3, 2, 4, 4, 4, 6, 8, 8 };

		int g[] = { 0, 0, 1, 0, 0, 1, 1, 0, 0, 1 };

		System.out.println("Move Aerp to End");
		moveZerotoEnd(g);

		System.out.println("Move Aerp to Begin");
		moveZerotoBegin(g);
		moveAllEvensToLeft(new int[] { 1, 4, 4, 6 });

		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8 };

		diagonalFormatPrint(array);

		array = new int[45];
		for (int i = 0; i < array.length; i++) {
			array[i] = i + 1;
		}
		diagonalFormatPrint(array);

		int[] num = { 2, 4, 4, 5, 4, 1 };
		try {
			System.out.println("Starting from index 0, adding numbers till index " + middleIndex(num) + " and");
			System.out.println("adding rest of the numbers can be equal");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
