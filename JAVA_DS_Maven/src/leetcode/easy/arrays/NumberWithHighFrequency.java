package leetcode.easy.arrays;

public class NumberWithHighFrequency {

	public static int numberWithHighestFrequency(int[] inputArray) {
		if (inputArray.length < 1) {
			System.out.println("Input array should contain atleast one element");
			return -1;
		}

		int globalNumber = inputArray[0];
		int globalCount = 0;

		int number = inputArray[0];
		int count = 0;

		for (int temp : inputArray) {
			if (number == temp) {
				count++;
			}
			if (number != temp) {
				globalNumber = temp;
				globalCount++;
				if (globalCount > count) {
					count = globalCount;
					number = temp;

					globalCount = 0;

				}
			}
		}
		return number;
	}
}
