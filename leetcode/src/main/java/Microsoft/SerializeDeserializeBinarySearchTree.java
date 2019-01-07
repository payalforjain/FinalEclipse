package Microsoft;

import leetcode.Model.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinarySearchTree {

    /*
    file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree.
 There is no restriction on how your serialization/deserialization algorithm should work.
  You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.
     */

    public String serialize(TreeNode root) {
        // base case
        if(root == null) return "";
        StringBuilder encoded = new StringBuilder();
        encode(root, encoded);
        return encoded.substring(1).toString();
    }

    private void encode(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append(",#");
            return;
        }
        sb.append(",").append(root.val);
        encode(root.left, sb);
        encode(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // base case
        if(data.length() == 0) return null;
        Queue<String> q = new LinkedList(Arrays.asList(data.split(",")));
        return decode(q);
    }

    private TreeNode decode(Queue<String> q) {
        if(q.isEmpty()) return null;
        String cur = q.poll();
        if(cur.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(cur));
        root.left = decode(q);
        root.right = decode(q);
        return root;
    }

}
