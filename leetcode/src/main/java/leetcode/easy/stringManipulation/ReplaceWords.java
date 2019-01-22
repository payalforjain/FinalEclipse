package leetcode.easy.stringManipulation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReplaceWords {
	
	/*
	 * In English, we have a concept called root,
	 * which can be followed by some other words to form another longer word -
	 *
	 * let's call this word successor. For example, the root an, followed by other, which can form another word another.

Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.

You need to output the sentence after the replacement.

Example 1:
Input: dict = ["cat", "bat", "rat"]
sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
	 */
	   public String replaceWords(List<String> dict, String sentence) {
	        if (dict == null || dict.size() == 0) return sentence;
	        
	        Set<String> set = new HashSet<>();
	        for (String s : dict) set.add(s);
	        
	        StringBuilder sb = new StringBuilder();
	        String[] words = sentence.split("\\s+");
	        
	        for (String word : words) {
	            String prefix = "";
	            for (int i = 1; i <= word.length(); i++) {
	                prefix = word.substring(0, i);
	                if (set.contains(prefix)) break;
	            }
	            sb.append(" " + prefix);
	        }
	        
	        return sb.deleteCharAt(0).toString();
	    }
}
