package leetcode.easy.arrays;

public class MoveZeroToBegin {

	static void pushZerosToBegin(int arr[], int n) {
		int i, j;
		for (j = i = arr.length - 1; i >= 0; i--) {
			// Skip over zero elements
			if (arr[i] == 0)
				continue;

			// i landed on index where there is a non-zero element,
			// hus copy it back to position j, and move j to next spot to fill.
			arr[j] = arr[i];
			j--;
		}

		// Zero fill remaining leading spots in array.
		while (j >= 0) {
			arr[j] = 0;
			j--;
		}
	}

	/* Driver function to check for above functions */
	public static void main(String[] args) {
		int arr[] = { 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9 };
		int n = arr.length;
		pushZerosToBegin(arr, n);
		System.out.println("Array after pushing zeros to the back: ");
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

}
