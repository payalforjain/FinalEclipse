package leetcode.medium.string;
import java.util.*;
public class RemoveComments {
/*
 check Leetcode

 https://leetcode.com/problems/remove-comments */

public List<String> removeComments(String[] source) {

        List<String> result = new ArrayList<>();
        StringBuilder newLine = new StringBuilder();
        boolean inBlock = false;
        for(String line : source)
        {
            int i = 0;
            int j = line.length();
            char[] chars = line.toCharArray();
        if (!inBlock) newLine = new StringBuilder();
            while(i <j)
            {
                if(!inBlock && i+1 < j && chars[i] == '/' && chars[i+1] == '*' )
                {
                    inBlock = true;
                    i++;
                }

                else if(inBlock && i+1 < j && chars[i] == '*' && chars[i+1] == '/' )
                {
                    inBlock = false;
                     i++;
                }

                else if (!inBlock && i+1 < j && chars[i] == '/' && chars[i+1] == '/' )
                {
                    break;

                }
                else if (!inBlock)
                {
                    newLine.append(chars[i]);

                }
                i++;
            }

            if(!inBlock && newLine.length() >0 )
            {
                result.add(new String(newLine));
            }

        }

        return result;
    }

}
