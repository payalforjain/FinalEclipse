package Microsoft;

import leetcode.medium.graph.GenerateParentheses;
import leetcode.medium.graph.LetterCombinationsPhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class playground {



    public List<String> letterCombinations(String inputDigit) {
        ArrayList<String> result = new ArrayList<String>();

        if (inputDigit == null || inputDigit.isEmpty()) {
            return result;
        }
        String[] dictionary = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder output = new StringBuilder();
        int deep =0;
        dfs(inputDigit, dictionary, output, result, deep);

        return result;
    }
//23
    private void dfs(String inputDigit, String[] dictionary, StringBuilder output, List<String> result, int deep)
    {
        if(inputDigit.length() == deep)
        {
            result.add(output.toString());
        }
        else
        {

            for(int i =0  ; i <  dictionary[inputDigit.charAt(deep) - '0'].length() ; i++)
            {
                output.append(dictionary[inputDigit.charAt(deep) - '0'].charAt(i));
                dfs(inputDigit, dictionary, output, result, deep+1);
                output.deleteCharAt(output.length()-1);

            }
        }
    }

    public static void main(String[] args)
    {
        playground l =new playground();
        System.out.println(l.letterCombinations("23"));


    }
}
