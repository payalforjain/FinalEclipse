package leetcode.medium.arrays;

public class RotateImage {
/*
Given input matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
Example 2:

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
 */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int maxRow = matrix.length;
        int maxColumn = matrix[0].length;

        if (maxRow != maxColumn) return;

        int temp = 0;


        for (int i = 0; i < maxRow / 2; i ++) {
            for (int j = i; j < maxRow - 1 - i; j ++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[maxRow - j - 1][i];
                matrix[maxRow - j - 1][i] = matrix[maxRow - i - 1][maxRow - j - 1];
                matrix[maxRow - i - 1][maxRow - j - 1] = matrix[j][maxRow - i - 1];
                matrix[j][maxRow - i - 1] = temp;
            }
        }
    }

}
