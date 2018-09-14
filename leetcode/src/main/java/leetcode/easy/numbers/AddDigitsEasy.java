package leetcode.easy.numbers;

public class AddDigitsEasy {
	
    /*
     * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. 
     * Since 2 has only one digit, return it.
     */
	public int addDigits(int num) {
		return (num - 1) % 9 + 1;

	}

}
