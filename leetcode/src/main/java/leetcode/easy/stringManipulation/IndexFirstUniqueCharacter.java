package leetcode.easy.stringManipulation;

import java.util.LinkedHashMap;
import java.util.Map;

public class IndexFirstUniqueCharacter {
	
	public int firstUniqChar(String s) {
        if(s==null || s.length() == 0)
        {
            return -1;
        }
        Map<Character,Integer> m  = new LinkedHashMap<Character, Integer>();
        for (int i = 0 ; i <s.length() ; i++)
        {
            char c = s.charAt(i);
            if( m.containsKey(c ) )
            {
                int val = m.get(c);
                m.put(c , val +1 );
            }
            else
            {
                m.put(c ,1);
            }
            
        }
        
        
     
        char temp ='\0' ;
        for(Map.Entry<Character,Integer> miter : m.entrySet())
        {
            int val = miter.getValue();
            if(val ==1 )
            {
                temp = miter.getKey();
                break;
         
            
           
        }
      return temp == '\0'? -1 : s.indexOf(temp);
    }

}
