package leetcode.easy.stringManipulation;

import java.util.ArrayList;
import java.util.List;

public class PermutationinString {
	//works but exceeds time limit
	List<String> list = new ArrayList<>();
	
public boolean checkInclusion(String s1, String s2) {
     
	  permutation("", s2);
	  for(String s : list)
	  {
		 if( s.contains(s1))
		 {
			 return true;
		 }
	  }
	  return false;
	 
    }

	private void permutation(String prefix, String str) {
		int n = str.length();
		if (n == 0)
		{
			
			list.add(prefix);
		}
		
		else {
			for (int i = 0; i < n; i++)
				permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
		}
	}

}
