package leetcode.medium.Trees;
import leetcode.Model.TreeNode;

import java.util.*;
public class PrintBinaryTree {


    /*
    Print a binary tree in an m*n 2D string array following these rules:

The row number m should be equal to the height of the given binary tree.
The column number n should always be an odd number.
The root node's value (in string format) should be put in the exactly middle of the first row it can be put. The column and the row where the root node belongs will separate the rest space into two parts (left-bottom part and right-bottom part). You should print the left subtree in the left-bottom part and print the right subtree in the right-bottom part. The left-bottom part and the right-bottom part should have the same size. Even if one subtree is none while the other is not, you don't need to print anything for the none subtree but still need to leave the space as large as that for the other subtree. However, if two subtrees are none, then you don't need to leave space for both of them.
Each unused space should contain an empty string "".
Print the subtrees following the same rules.
Example 1:
Input:
     1
    /
   2
Output:
[["", "1", ""],
 ["2", "", ""]]
Example 2:
Input:
     1
    / \
   2   3
    \
     4
Output:
[["", "", "", "1", "", "", ""],
 ["", "2", "", "", "", "3", ""],
 ["", "", "4", "", "", "", ""]]
Example 3:
Input:
      1
     / \
    2   5
   /
  3
 /
4
Output:

[["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]

 ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]



     */
    public List<List<String>> printTree(TreeNode root) {
        int height =  maxDepth(root);
        int width = (int) Math.pow(2, height) - 1;
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            List<String> item = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                item.add("");
            }
            res.add(new ArrayList<String>(item));
        }
        dfs(res, root, 0, width - 1, 0);
        return res;
    }

    private void dfs(List<List<String>> res, TreeNode root, int left, int right, int level) {

        if (root == null)
            return;
        int mid = left + (right - left) / 2;
        res.get(level).set(mid, String.valueOf(root.val));
        dfs(res, root.left, left, mid, level + 1);
        dfs(res, root.right, mid + 1, right, level + 1);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if ((root.left == null) && (root.right == null)) {
            return 1;
        }

        int max_depth = Integer.MIN_VALUE;
        if (root.left != null) {
            max_depth = Math.max(maxDepth(root.left), max_depth);
        }
        if (root.right != null) {
            max_depth = Math.max(maxDepth(root.right), max_depth);
        }

        return max_depth + 1;
    }
}
