package leetcode.easy.arrays;

public class IndexEqualtoNumber {
	
	public static int indexEqualToNumberSortedArray(int[] a) {
		if (a.length == 0) {
			return -1;
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] == i) {
				return a[i];
			}
		}

		return -1;
	}


}
