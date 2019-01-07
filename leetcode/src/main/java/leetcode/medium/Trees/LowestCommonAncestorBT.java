package leetcode.medium.Trees;
import leetcode.Model.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.Stack;

import java.util.*;
public class LowestCommonAncestorBT {

    /*


        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;

        if (left != null) return left;

        if (right != null) return right;

        return null;
    }



    public TreeNode lowestCommonAncestorIter(TreeNode root, TreeNode p, TreeNode q) {

        Map<TreeNode, TreeNode> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();

        map.put(root , null);
        queue.add(root);
        while ( !map.containsKey(p) ||  !map.containsKey(q)  )
        {
            TreeNode top = queue.remove();
            if(top.left != null)
            {
                queue.add(top.left);
                map.put(top.left , top);

            }

            if(top.right != null)
            {
                queue.add(top.right);
                map.put(top.right , top);

            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        while(p != null)
        {
            ancestors.add(p);
            p = map.get(p);

        }

        while(!ancestors.contains(q))
        {
            ancestors.add(q);
            q = map.get(q);
        }
        return q;
    }

    public static void main (String[] args)
    {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);
        LowestCommonAncestorBT l = new LowestCommonAncestorBT();
        System.out.println("LCA(4, 5): " + l.lowestCommonAncestor(tree,tree.left.left  ,tree.left.right).val);
        System.out.println("LCA(4, 5): " + l.lowestCommonAncestor(tree,tree.left.left  ,   tree.right.left ).val);

        /*
        System.out.println("LCA(4, 6): " + tree.lowestCommonAncestor(root,4,6));
        System.out.println("LCA(3, 4): " + tree.lowestCommonAncestor(root,3,4));
        System.out.println("LCA(2, 4): " + tree.lowestCommonAncestor(root,2,4));
        */

    }
}
