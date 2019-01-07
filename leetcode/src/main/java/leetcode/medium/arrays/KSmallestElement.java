package leetcode.medium.arrays;

public class KSmallestElement {

    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || k <= 0) return -1;

        int n = matrix.length;
        int min = matrix[0][0];
        int max = matrix[n - 1][n - 1];
        while (min < max) {
            int target = min + (max - min) / 2;
            int count = countSmallerItem(matrix, target);
            if (count < k) { // need larger target
                min = target + 1; // target is counted, skip over
            } else {
                max = target;
            }
        }
        return min;
    }

    // O(n)
    private int countSmallerItem(int[][] matrix, int target) {
        int n = matrix.length;
        int count = 0;
        int i = 0, j = n - 1; // n*n
        while (i < n && j >= 0) {
            if (matrix[i][j] > target) { //item too large, skip
                j--;
            } else { // meet requirement, add (j+1) since j is 0-based, also move on to next row
                count += j + 1;
                i++;
            }
        }
        return count;
    }


    public static void main(String[] args)
    {
        KSmallestElement a =new KSmallestElement();
        int[][] matrix = {
                { 1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}
        };
        a.kthSmallest(matrix, 8);
    }
}
