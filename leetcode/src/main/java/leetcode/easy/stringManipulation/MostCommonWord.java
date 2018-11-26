package leetcode.easy.stringManipulation;
import java.util.*;
/*
Input:
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
Explanation:
 */
public class MostCommonWord {


    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph + ".";
        Set<String> bannedWordSet = new HashSet<String>();
        Map<String,Integer> count = new HashMap<>();
        for( String s :  banned)
        {
            bannedWordSet.add(s);
        }

        int commonWordCount = 0;
        String mostCommonWord = "";
        StringBuilder word = new StringBuilder();
        for(char c : paragraph.toCharArray())
        {
            if(Character.isLetter(c))
            {
                word.append(c);
            }
            else if(word.length()>0)
            {
                int countStringVal = 0;
                String wordString = word.toString().toLowerCase();
                if (!bannedWordSet.contains(wordString))
                {

                    if (!count.containsKey(wordString))
                    {
                        countStringVal = 1;
                        count.put(wordString, countStringVal);
                    }
                    else
                    {
                        countStringVal = count.get(wordString) + 1;
                        count.put(wordString, countStringVal);

                    }
                }
                if (countStringVal > commonWordCount)
                {
                    commonWordCount = countStringVal;
                    mostCommonWord = wordString;
                }
                word = new StringBuilder();
            }

        }
        return mostCommonWord;
    }

/*
Time Complexity: O(P + B)O(P+B), where PP is the size of paragraph and BB is the size of banned.

Space Complexity: O(P + B)O(P+B), to store the count and the banned set.
    */
}
