package leetcode.easy.arrays;

public class MoveAllEvenToLeft {
	
	public static void moveAllEvensToLeft(int[] inputArray) {

        int i = 0;
        int j = inputArray.length - 1;
        while (i < j) {
            while (inputArray[i] % 2 == 0) {
                i++;
            }
            while (inputArray[j] % 2 != 0) {
                j--;
            }
            if (i < j)
                swap(inputArray, i, j);
        }
        System.out.println("After moves:");
        for (int input : inputArray) {
            System.out.print(input + " ");
        }
    }

    private static void swap(int[] inputArray, int currentPosition, int i) {
        int temp = inputArray[currentPosition];
        inputArray[currentPosition] = inputArray[i];
        inputArray[i] = temp;
    }

    public static void main(String[] args) {
        moveAllEvensToLeft(new int[]{1, 4, 3, 4,3, 4, 1, 4, 1, 3, 5, 6});
        moveAllEvensToLeft(new int[]{1, 4, 4, 6});
        moveAllEvensToLeft(new int[]{4, 4, 6, 1});
        moveAllEvensToLeft(new int[]{4, 3, 4, 6, 1});
        moveAllEvensToLeft(new int[]{1, 3, 4});
        moveAllEvensToLeft(new int[]{1, 4});
    }

}
