package array;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class solution {
    private static long[] getElements(String elements, int size) { // findMinDiff

		String[] elementsArray = elements.trim().split(" ");

		if (elementsArray.length != size)
			throw new IllegalArgumentException("size does bot match the list");

		long[] numbers = new long[size];
		int index = 0;

		
		for (String ele : elementsArray) {
			numbers[index++] = Long.parseLong(ele);
		}
		return numbers;
	}


	private static long findMinDiff(long[] array, int start, int end) {

		if (start == end) 
			return Long.MAX_VALUE;
		else if (end - start == 1) 
			return (array[end] - array[start]);

		int mid = (start + end) / 2; 

		long leftDiff = Math.abs(findMinDiff(array, start, mid)); 
		long rightDiff = Math.abs(findMinDiff(array, mid + 1, end)); 

		long diffMid = Math.abs(array[mid + 1] - array[mid]); 

		return Math.min(diffMid, Math.min(leftDiff, rightDiff)); 
	}


	private static void printClosestNumbers(long[] array, int arraySize) {

		long minDiff = findMinDiff(array, 0, arraySize - 1); 

		for (int i = 0; i < arraySize - 1; i++) { 
			if (Math.abs(array[i + 1] - array[i]) == minDiff) {
				System.out.print(array[i] + " " + array[i + 1] + " ");
			}
		}

	}

	public static void main(String[] args) {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		try {
			int listSize = Integer.parseInt(input.readLine());
			long[] list = getElements(input.readLine(), listSize);

			
			Arrays.sort(list);

			
			printClosestNumbers(list, listSize);

			input.close();
		} catch (NumberFormatException e) {
			System.err.println("NumberFormatException");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println(" IOException");
			e.printStackTrace();
		}
	}
   
}