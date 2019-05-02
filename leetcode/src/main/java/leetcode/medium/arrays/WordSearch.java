package leetcode.medium.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch {

    /*
    board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
     */

    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) {
            return true;
        }

        if (board.length == 0 && word.length() == 0) {
            return true;
        }

        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (existHelper(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean existHelper(char[][] board, String word, int start, int row, int col, boolean[][] visited) {
        if (start == word.length()) {
            return true;
        }

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return false;
        }

        if (visited[row][col]) {
            return false;
        }

        if (board[row][col] != word.charAt(start)) {
            return false;
        }

        visited[row][col] = true;
        boolean result = existHelper(board, word, start + 1, row - 1, col, visited) ||
                existHelper(board, word, start + 1, row + 1, col, visited) ||
                existHelper(board, word, start + 1, row, col - 1, visited) ||
                existHelper(board, word, start + 1, row, col + 1, visited);
        visited[row][col] = false;

        return result;
    }

    /*
    Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example:

Input:
words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

Output: ["eat","oath"]
     */
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }

        List<String> res = new ArrayList<>();
        for (String word : set) {
            if (exist(board, word)) {
                res.add(word);
            }
        }

        return res;
    }

    public List<String> findWordsTrie(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs (board, i, j, root, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if (p.word != null) {   // found one
            res.add(p.word);
            p.word = null;     // de-duplicate
        }

        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j ,p, res);
        if (j > 0) dfs(board, i, j - 1, p, res);
        if (i < board.length - 1) dfs(board, i + 1, j, p, res);
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
        board[i][j] = c;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

}
