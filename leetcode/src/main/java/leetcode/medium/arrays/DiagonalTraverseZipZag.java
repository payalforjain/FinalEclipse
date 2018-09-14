package leetcode.medium.arrays;

public class DiagonalTraverseZipZag {
	/*
	 * Given a matrix of M x N elements (M rows, N columns), return all elements
	 * of the matrix in diagonal order as shown in the below image.
	 * 
	 * Example: Input: [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ] Output:
	 * [1,2,4,7,5,3,6,8,9] Explanation:
	 */
	public int[] findDiagonalOrder(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return new int[0];

		int m = matrix.length - 1, n = matrix[0].length - 1;
		int[] result = new int[(m + 1) * (n + 1)];
		int index = 0;
		for (int i = 0; i <= m + n; i++) {
			int upperBoundx = Math.min(i, m); // x <= m
			int lowerBoundx = Math.max(0, i - n); // lower bound i - x(y) <= n
			int upperBoundy = Math.min(i, n); // y <= n
			int lowerBoundy = Math.max(0, i - m); // i - y(x) <= m
			if (i % 2 == 0) {
				// column increment
				for (int y = lowerBoundy; y <= upperBoundy; y++) {
					result[index] = matrix[i - y][y];
					index++;
				}
			} else {
				// row increment
				for (int x = lowerBoundx; x <= upperBoundx; x++) {
					result[index] = matrix[x][i - x];
					index++;
				}
			}
		}

		return result;
	}

	/*
	 * Input: {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16},
	 * {17, 18, 19, 20},
	 * 
	 * Output: 1 5 2 9 6 3 13 10 7 4 17 14 11 8 18 15 12 19 16 20
	 */

	private void printMatrixDiagonally() {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 }, { 17, 18, 19, 20 } };
		int rowCount = matrix.length;
		int columnCount = matrix[0].length;

		for (int r = 0; r < rowCount; r++) {
			for (int row = r, col = 0; row >= 0 && col < columnCount; row--, col++) {
				System.out.print(matrix[row][col] + " ");
			}
			System.out.println();
		}

		for (int c = 1; c < columnCount; c++) {
			for (int row = rowCount - 1, col = c; row >= 0 && col < columnCount; row--, col++) {
				System.out.print(matrix[row][col] + " ");
			}
			System.out.println();
		}

	}
}
