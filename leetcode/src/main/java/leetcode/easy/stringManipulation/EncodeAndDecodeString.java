package leetcode.easy.stringManipulation;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeString {

    public String encode(List<String> strs) {

        if(strs == null || strs.size() == 0)
            return "";
        StringBuilder result = new StringBuilder();
        for(String str : strs)
        {
            result.append(str.length());
            result.append("/");
            result.append(str);
        }
        return result.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {

        List<String> result = new ArrayList<>();

        if(s==null || s.length() ==0)
            return result;

        int i =0;
        while(i < s.length())
        {
            int slashIndex = s.indexOf("/", i);

            int strLength = Integer.valueOf(s.substring(i , slashIndex));
            result.add(s.substring(slashIndex + 1 ,slashIndex + 1 + strLength ));
            i = slashIndex + 1 + strLength ;
        }
        return result;
    }
}
