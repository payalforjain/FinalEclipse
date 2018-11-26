package leetcode.easy.stringManipulation;
import java.util.*;
public class MorseCode {

    /*
    International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.

For convenience, the full table for the 26 letters of the English alphabet is given below:

[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cba" can be written as "-.-..--...", (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a concatenation, the transformation of a word.

Return the number of different transformations among all words we have.

Example:
Input: words = ["gin", "zen", "gig", "msg"]
Output: 2
Explanation:
The transformation of each word is:
"gin" -> "--...-."
"zen" -> "--...-."
"gig" -> "--...--."
"msg" -> "--...--."

There are 2 different transformations, "--...-." and "--...--.".
     */

    public int uniqueMorseRepresentations(String[] words) {
        Set set = new HashSet<>();
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for(String word: words)
        {
            StringBuilder temp = new StringBuilder();
            for(char c : word.toCharArray())
            {
                temp.append(morse[c - 'a']);

            }
            set.add(temp.toString());
        }
        return set.size();
    }

    /*
    Complexity Analysis

Time Complexity: O(S)O(S), where SS is the sum of the lengths of words in words. We iterate through each character of each word in words.

Space Complexity: O(S)O(S).
     */
}
