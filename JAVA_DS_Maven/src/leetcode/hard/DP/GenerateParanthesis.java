package leetcode.hard.DP;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
	/*
	 * Given n pairs of parentheses, write a function to generate all
	 * combinations of well-formed parentheses.
	 * 
	 * For example, given n = 3, a solution set is:
	 * 
	 * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
	 */
	public List<String> generateParenthesis(int n) {
		ArrayList<String> result = new ArrayList<String>();
		ArrayList<Integer> diff = new ArrayList<Integer>();

		result.add("");
		diff.add(0);

		for (int i = 0; i < 2 * n; i++) {
			ArrayList<String> temp1 = new ArrayList<String>();
			ArrayList<Integer> temp2 = new ArrayList<Integer>();

			for (int j = 0; j < result.size(); j++) {
				String s = result.get(j);
				int k = diff.get(j);

				if (i < 2 * n - 1) {
					temp1.add(s + "(");
					temp2.add(k + 1);
				}

				if (k > 0 && i < 2 * n - 1 || k == 1 && i == 2 * n - 1) {
					temp1.add(s + ")");
					temp2.add(k - 1);
				}
			}

			result = new ArrayList<String>(temp1);
			diff = new ArrayList<Integer>(temp2);
		}

		return result;
	}
	
	   public List<String> generateParenthesisdFS(int n) {
	        List<String> result = new ArrayList<>();
	        StringBuilder path = new StringBuilder();
	        if (n > 0) generate(n, path, result, 0, 0);
	        return result;
	    }

	    private static void generate(int n, StringBuilder path,
	                                 List<String> result, int l, int r) {
	        if (l == n) {
	            StringBuilder sb = new StringBuilder(path);
	            for (int i = 0; i < n - r; ++i) sb.append(')');
	            result.add(sb.toString());
	            return;
	        }

	        path.append('(');
	        generate(n, path, result, l + 1, r);
	        path.deleteCharAt(path.length() - 1);

	        if (l > r) {
	            path.append(')');
	            generate(n, path, result, l, r + 1);
	            path.deleteCharAt(path.length() - 1);
	        }
	    }
}
