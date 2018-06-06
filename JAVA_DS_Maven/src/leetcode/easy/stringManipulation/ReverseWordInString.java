package leetcode.easy.stringManipulation;

public class ReverseWordInString {

	/*
	 * input: "Let's take LeetCode contest"
	 * output: "contest LeetCode take Let's"
	 */
	public String reverseWords2(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}

		// split to words by space
		String[] arr = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = arr.length - 1; i >= 0; --i) {
			if (!arr[i].equals("")) {
				sb.append(arr[i]).append(" ");
			}
		}
		return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
	}
	


	/*
	 * input: "Let's take LeetCode contest"
	 * output: "s'teL ekat edoCteeL tsetnoc"
	 */
    public String reverseWords(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}

		// split to words by space
		String[] arr = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0 ; i < arr.length ; i++)
		{
			
			if (!arr[i].equals("")) {
				String reveresedString = reverseString(arr[i]);
				sb.append(reveresedString).append(" ");
			}
		}
		return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
	}
    
    public String reverseString(String s) {
        
        StringBuilder str = new StringBuilder();
        for(int  i = s.length() -1 ; i >=0 ; i--)
        {
            str.append(s.charAt(i));
        }
	    return str.toString();
	}
    
}
