package leetcode.medium.Trees;

import leetcode.Model.TreeNode;


import java.util.*;

public class VerticalOrder {
/*
    Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

    If two nodes are in the same row and column, the order should be from left to right.

            Examples 1:

    Input: [3,9,20,null,null,15,7]

            3
            /\
            /  \
            9  20
            /\
            /  \
            15   7

    Output:

            [
            [9],
            [3,15],
            [20],
            [7]
            ]
    Examples 2:

    Input: [3,9,8,4,0,1,7]

            3
            /\
            /  \
            9   8
            /\  /\
            /  \/  \
            4  01   7

    Output:

            [
            [4],
            [9],
            [3,0,1],
            [8],
            [7]
            ]
    Examples 3:

    Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5)

            3
            /\
            /  \
            9   8
            /\  /\
            /  \/  \
            4  01   7
            /\
            /  \
            5   2

    Output:

            [
            [4],
            [9,5],
            [3,0,1],
            [8,2],
            [7]
            ]

    */


    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        //map's key is column, we assume the root column is zero, the left node will minus 1 ,and the right node will plus 1
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        //use a HashMap to store the TreeNode and the according cloumn value
        HashMap<TreeNode, Integer> weight = new HashMap<TreeNode, Integer>();
        queue.offer(root);
        weight.put(root, 0);
        int min = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int w = weight.get(node);
            if (!map.containsKey(w)) {
                map.put(w, new ArrayList<>());
            }
            map.get(w).add(node.val);
            if (node.left!= null) {
                queue.add(node.left);
                weight.put(node.left, w - 1);
            }
            if (node.right != null) {
                queue.add(node.right);
                weight.put(node.right, w + 1);
            }
            //update min ,min means the minimum column value, which is the left most node
            min = Math.min(min, w);
        }
        while (map.containsKey(min)) {
            res.add(map.get(min++));
        }
        return res;
    }
}