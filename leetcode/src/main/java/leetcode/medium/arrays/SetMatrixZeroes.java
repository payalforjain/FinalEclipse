package leetcode.medium.arrays;

public class SetMatrixZeroes {

    /*
    Input:

[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]

Output:

[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
Example 2:
Input:

[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]

Output:

[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
     */

    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;

        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        //check if first row needs to be changed to zero
        for(int j = 0; j < n; j++) {
            if(matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        //check if first col needs to be changed to zero
        for(int i = 0; i < m; i++) {
            if(matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        //mark zeros on first row and column
        for(int i = 1; i < m ;i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //fill in the zeroes
        for(int i = 1; i < m ;i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }

        //update first row
        if(firstRowZero) {
            for(int j = 0; j < n; j++)
                matrix[0][j] = 0;
        }

        //update first col
        if(firstColZero) {
            for(int i = 0; i < m; i++)
                matrix[i][0] = 0;
        }
    }


    public static void main(String[] args)
    {
        int[][] matrix = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };

        SetMatrixZeroes s = new SetMatrixZeroes();
        s.setZeroes(matrix);
    }


}
