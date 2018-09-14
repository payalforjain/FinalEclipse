package leetcode.easy.stringManipulation;

public class NumberOfStringSegments {
	
    public int countSegments(String s) {
      	String[] out = s.split("\\s+");

		int count = 0;

		for (String str : out) {
			if (str.length() != 0)
				count++;
		}
		return count;
        
    }
   

}
