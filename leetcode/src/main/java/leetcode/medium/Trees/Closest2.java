package leetcode.medium.Trees;
import leetcode.Model.TreeNode;

import java.util.*;
public class Closest2 {


    /*
    Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

Note:

Given target value is a floating point.
You may assume k is always valid, that is: k ≤ total nodes.
You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
Example:

Input: root = [4,2,5,1,3], target = 3.714286, and k = 2

    4
   / \
  2   5
 / \
1   3


Output: [4,3]
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {

        List<Integer> result = new ArrayList<>();

        if(root == null)
            return result;

        Stack<Integer>  predessor = new Stack<>();
        Stack<Integer>  successor = new Stack<>();

        getPredessor(root , predessor , target);
        getSuccessor(root , successor , target);

        for(int i =0 ; i <k ;i++)
        {
            if(predessor.isEmpty())
                result.add(successor.pop());
            else if (successor.isEmpty())
                result.add(predessor.pop());
            else if (Math.abs((double)predessor.peek() - target)  <  Math.abs((double)successor.peek() -target)   )
            {
                //0.1 < 0.2
                result.add(predessor.pop());
            }
            else
                result.add(successor.pop());

        }

        return  result;


    }

    private void getPredessor(TreeNode root , Stack<Integer> predessor , double target)
    {
        if(root == null)
            return;

        getPredessor(root.left , predessor , target);

        if(root.val <= target)
            predessor.push(root.val);

        getPredessor(root.right, predessor , target);
    }

    private void getSuccessor(TreeNode root , Stack<Integer> successor, double target)
    {
        if(root == null)
            return;

        getSuccessor(root.right , successor, target);

        if(root.val > target)
            successor.push(root.val);

        getSuccessor(root.left, successor , target);
    }
}
