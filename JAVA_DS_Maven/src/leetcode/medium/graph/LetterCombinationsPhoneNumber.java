package leetcode.medium.graph;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsPhoneNumber {
	
	/*
	 * Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
	 */

	
	 public List<String> letterCombinations(String digits) {
         if(digits==null || digits.isEmpty())
         {
             return new ArrayList<String>();
         }
       String[] dic = {" ","", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
       ArrayList<String> ret = new ArrayList<String>();
       StringBuilder temp = new StringBuilder(); 
       dfs(digits, dic, 0, temp, ret);
       return ret;
   }
   public void dfs(String digits, String[] dic, int deep, StringBuilder temp, ArrayList<String> ret){
       if(deep == digits.length()){
           ret.add(temp.toString());
           return;
       }
       else{
           for(int i = 0; i < dic[digits.charAt(deep) - '0'].length(); i++){
               temp.append(dic[digits.charAt(deep) - '0'].charAt(i));
               dfs(digits, dic, deep+1, temp, ret);
               temp.deleteCharAt(temp.length()-1);
           }
       }
   }
}
