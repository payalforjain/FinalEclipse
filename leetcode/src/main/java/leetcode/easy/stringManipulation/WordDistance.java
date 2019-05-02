package leetcode.easy.stringManipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WordDistance {


    Map<String, ArrayList<Integer>> map = new HashMap<>();


    public WordDistance(String[] words) {

        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i]))
                map.put(words[i], new ArrayList<>());
            map.get(words[i]).add(i);
        }

    }

    /*
    244. Shortest Word Distance II
Medium

181

78

Favorite

Share
Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list. Your method will be called repeatedly many times with different parameters.

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3
Input: word1 = "makes", word2 = "coding"
Output: 1
     */

    /*
    Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3
Input: word1 = "makes", word2 = "coding"
Output: 1
     */
    public int shortestDistance(String[] words, String word1, String word2) {


        int p1 = -1;
        int p2 = -1;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                p1 = i;
            } else if (words[i].equals(word2)) {
                p2 = i;
            }

            if (p1 != -1 && p2 != -1) {
                int currentDistance = Math.abs(p1 - p2);

                if (currentDistance < minDistance) {
                    minDistance = currentDistance;
                }
            }

        }

        return minDistance;
    }

    /*
    Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list. Your method will be called repeatedly many times with different parameters.

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3
Input: word1 = "makes", word2 = "coding"
Output: 1
     */
    /*
    Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “makes”, word2 = “coding”
Output: 1
Input: word1 = "makes", word2 = "makes"
Output: 3
     */
    public int shortestWordDistance(String[] words, String word1, String word2) {

        int p1 = -1;
        int p2 = -1;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            if (word1.equals(word2)) {
                if (words[i].equals(word1)) {

                    // let p1, p2 point to the two largest indexes
                    if (p2 < p1) p2 = i;
                    else p1 = i;
                }

            } else {
                if (words[i].equals(word1)) {
                    p1 = i;
                } else if (words[i].equals(word2)) {
                    p2 = i;
                }


            }

            if (p1 != -1 && p2 != -1) {
                int currentDistance = Math.abs(p1 - p2);

                if (currentDistance < minDistance) {
                    minDistance = currentDistance;
                }
            }


        }
        return minDistance;
    }

    public int shortest(String word1, String word2) {
        int i = 0;
        int j = 0;
        ArrayList<Integer> l1 = map.get(word1);
        ArrayList<Integer> l2 = map.get(word2);
        int minDistance = Integer.MAX_VALUE;
        while (i < l1.size() && j < l2.size()) {
            int index1 = l1.get(i);
            int index2 = l2.get(j);
            int currentDistance = Math.abs(index1 - index2);

            if (currentDistance < minDistance) {
                minDistance = currentDistance;
            }

            if (index1 < index2) {
                i++;
            } else {
                j++;
            }

        }


        return minDistance;

    }


}