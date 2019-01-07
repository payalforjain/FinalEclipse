package leetcode.medium.arrays;

import java.util.ArrayList;
import java.util.List;

public class SprialMatrix {
/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
    public List< Integer > spiralOrder(int[][] matrix) {
        List result = new ArrayList();
        if (matrix.length == 0)
            return result;
        int initialRow = 0, rowLength = matrix.length - 1;
        int initialColum = 0, columsLength = matrix[0].length - 1;
        while (initialRow <= rowLength && initialColum <= columsLength) {
            //left to right
            for (int c = initialColum; c <= columsLength; c++)
                result.add(matrix[initialRow][c]);
            //top to bottom
            for (int r = initialRow + 1; r <= rowLength; r++)
                result.add(matrix[r][columsLength]);
            if (initialRow < rowLength && initialColum < columsLength) {
                for (int c = columsLength - 1; c > initialColum; c--)
                    result.add(matrix[rowLength][c]);
                for (int r = rowLength; r > initialRow; r--)
                    result.add(matrix[r][initialColum]);
            }
            initialRow++;
            rowLength--;
            initialColum++;
            columsLength--;
        }
        return result;
    }

    /*
    Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
     */

    public int[][] generateMatrix(int n) {
        int[][] matrix= new int[n][n];
        int initialRow = 0, rowLength =n- 1;
        int initialColum = 0, columsLength = n - 1;
        int number = 1;

        while (initialRow <= rowLength && initialColum <= columsLength) {
            //left to right
            for (int c = initialColum; c <= columsLength; c++)
            {
                matrix[initialRow][c] = number;
                number++;
            }

            //top to bottom
            for (int r = initialRow + 1; r <= rowLength; r++)
            {
                matrix[r][columsLength]= number;
                number++;
            }

            if (initialRow < rowLength && initialColum < columsLength)
            {
                for (int c = columsLength - 1; c > initialColum; c--)
                {
                    matrix[rowLength][c] = number;
                    number++;
                }

                for (int r = rowLength; r > initialRow; r--)
                {
                    matrix[r][initialColum] = number;
                    number++;
                }

            }
            initialRow++;
            rowLength--;
            initialColum++;
            columsLength--;
        }

        return matrix;
    }
}
