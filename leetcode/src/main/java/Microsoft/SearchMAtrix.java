package Microsoft;

public class SearchMAtrix {

    /*
    Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0)
            return false;
        if(matrix[0].length == 0)
            return false;
        int rowNumber = 0;
        int colNumber = matrix[0].length-1;
        while(rowNumber < matrix.length && colNumber >= 0)
        {
            if (target == matrix[rowNumber][colNumber])
                return true;
            else if(target < matrix[rowNumber][colNumber])
                --colNumber;
            else if(target > matrix[rowNumber][colNumber])
                ++rowNumber;

        }
        return false;
    }

    public static void main(String[] args)
    {
        SearchMAtrix s = new  SearchMAtrix();
        int[][] nums = {
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
    };
        s.searchMatrix(nums, 13);
    }

    /*
    Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
Example:

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix.length == 0)
            return false;
        if(matrix[0].length == 0)
            return false;
        int rowNumber = 0;
        int colNumber = matrix[0].length-1;
        while(rowNumber < matrix.length && colNumber >= 0)
        {
            if (target == matrix[rowNumber][colNumber])
                return true;
            else if(target < matrix[rowNumber][colNumber])
                --colNumber;
            else if(target > matrix[rowNumber][colNumber])
                ++rowNumber;

        }
        return false;
    }
    /*
    Time complexity : \mathcal{O}(n+m)O(n+m)

The key to the time complexity analysis is noticing that, on every iteration (during which we do not return true) either row or col is is decremented/incremented exactly once. Because row can only be decremented mm times and col can only be incremented nn times before causing the while loop to terminate, the loop cannot run for more than n+mn+m iterations. Because all other work is constant, the overall time complexity is linear in the sum of the dimensions of the matrix.

Space complexity : \mathcal{O}(1)O(1)

Because this approach only manipulates a few pointers, its memory footprint is constant.
     */
}
