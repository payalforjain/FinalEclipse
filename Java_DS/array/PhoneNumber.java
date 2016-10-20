package array;

import java.util.LinkedList;
import java.util.List;

public class PhoneNumber {
	 public List<String> letterCombinations(String digits) {
	        String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	        List<String> rec = new LinkedList<>();
	        StringBuilder string = new StringBuilder();
	        letterCombinations(digits, 0, letters, string, rec);
	        return rec;
	    }
	    
	    private void letterCombinations(String digits, int number, String[] letters, StringBuilder string, List<String> rec) {
	        if (digits.length() == number) {
	            rec.add(string.toString());
	            return;
	        }
	        String letter = letters[digits.charAt(number) - '1'];
	        for (int i = 0; i < letter.length(); i++) {
	            string.append(letter.charAt(i));
	            letterCombinations(digits, number + 1, letters, string, rec);
	            string.deleteCharAt(string.length() - 1);
	        }
	    }
	    
	    public List<String> letterCombinationsNonRecursive(String digits) {
	        String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	        LinkedList<String> list = new LinkedList<>();
	        list.add("");
	        for (int i = 0; i < digits.length(); i++) {
	            int num = digits.charAt(i) - '1';
	            int size = list.size();
	            for (int k = 0; k < size; k++) {
	                String tmp = list.pop();
	                for (int j = 0; j < letters[num].length(); j++)
	                    list.add(tmp + letters[num].charAt(j));
	            }
	        }
	        List<String> rec = new LinkedList<>();
	        rec.addAll(list);
	        return rec;
	    }
	    
	    
	    public static void main(String[] args)
	    {
	    	PhoneNumber p = new PhoneNumber();
	    	System.out.println(p.letterCombinations("16"));
	    	System.out.println(p.letterCombinationsNonRecursive("16"));
	    }
}
