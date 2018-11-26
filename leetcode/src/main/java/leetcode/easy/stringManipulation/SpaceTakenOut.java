package leetcode.easy.stringManipulation;

import java.util.Set;
public class SpaceTakenOut {
// Given a string of words with the spaces taken out and a dictionary of all possible words, put the spaces back in.
//
// e.g. "acat" => "a cat
//
// Amazon Question"

    public static String spaceTakenOut(String input , Set<String> words)
    {

        StringBuilder result =  new StringBuilder();

        if( input.length() ==0 || input ==null )
        {
            return "";
        }

        if(words.contains(input) )
        {
            return input;
        }


    else
        {
            StringBuilder temp =  new StringBuilder();

            for(int i =0 ; i< input.length() ; i++)
            {
                temp = temp.append( input.charAt(i));

                if(words.contains(temp.toString()))
                {
                    result = result.append(temp).append(" ");
                    temp = new StringBuilder();
                }
            }
        }

        return result.toString();

    }



}
