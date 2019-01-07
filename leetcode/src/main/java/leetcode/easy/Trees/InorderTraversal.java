package leetcode.easy.Trees;
import java.util.*;
public class InorderTraversal {

    /*
    Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?
     */

    public ArrayList<Integer> inorderTraversalIter(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer>  result = new ArrayList<>();
        if(root == null)
        {
            return result ;
        }


        Stack<TreeNode> s = new Stack();

        while(!s.isEmpty() || root!= null)
        {

            if(root != null)
            {
                s.push(root);
                root = root.left;
            }

            else
            {
                root = s.pop();
                result.add(root.val);
                root = root.right;
            }
        }

        return result;


    }

    List<Integer> result = new ArrayList<Integer>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root !=null){
            helper(root);
        }

        return result;
    }

    public void helper(TreeNode p){
        if(p.left!=null)
            helper(p.left);

        result.add(p.val);

        if(p.right!=null)
            helper(p.right);
    }

}
