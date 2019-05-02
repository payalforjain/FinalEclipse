package leetcode.hard.DP.arrays.string;
import java.util.*;
public class WordLadder {
    class Node
    {

        String currentWord;
        Node previousNode;
        Node(String currentWord , Node previousNode)
        {
            this.currentWord = currentWord ;
            this.previousNode = previousNode;
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        Set<String> unvisited = new HashSet<>();
        unvisited.addAll(wordList);
        Set<String> visited = new HashSet<>();
        queue.add(new Node(beginWord , null ));
        visited.add(beginWord);
        // this is little tricky. we normally add visit after queue is poped
        while(!queue.isEmpty())
        {
            int size  = queue.size();

            for(int i =0 ; i < size ; i++)
            {
                Node currentNode = queue.remove();
                String currentWord = currentNode.currentWord;
                if(currentWord.equals(endWord))
                {
                    List<String> ladder = new ArrayList<>();
                    while (currentNode != null) {
                        ladder.add(currentNode.currentWord);
                        currentNode = currentNode.previousNode;
                    }
                    Collections.reverse(ladder);
                    result.add(ladder);
                    continue;
                }

                else
                {
                    char[] arr = currentWord.toCharArray();
                    for(int j=0; j<arr.length; j++){
                        for(char c='a'; c<='z'; c++){
                            char temp = arr[j];
                            if(arr[j]!=c){
                                arr[j]=c;
                            }

                            String newWord = new String(arr);
                            if(unvisited.contains(newWord)){
                                queue.add(new Node(newWord, currentNode));
                                // this is little tricky. we normally add visit after queue is poped
                                visited.add(newWord);
                            }

                            arr[j]=temp;
                        }
                    }
                }
            }
            unvisited.removeAll(visited);
        }

        return result;
    }


    /*
    Time complexity:
Say number of words = V and length of each word = l.
 while loop and the first for loop takes O(V) as a whole. Backtracking takes O(V).
 Finding neighbors takes O(l). The overall time complexity is O(V(V + l)).
     */
}
