package leetcode.medium.Trees;
import leetcode.Model.TreeNode;
import java.util.*;
public class CountNodes {
/*
Given a complete binary tree, count the number of nodes.

Note:

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Example:

Input:
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6
 */

/*
Given a complete binary tree, count the number of nodes.

Analysis
Steps to solve this problem:
1) get the height of left-most part
2) get the height of right-most part
3) when they are equal, the # of nodes = 2^h -1
4) when they are not equal, recursively get # of nodes from left&right sub-trees

 */
    public int countNodes(TreeNode root) {

        if(root == null)
        {
            return 0;
        }

        int leftNode = getLeft(root) +1 ;
        int rightNode = getRight(root) +1;


        if(leftNode == rightNode)
        {
            return (2<<(leftNode-1))-1;
        }

        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private int getLeft(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }

        int height = 0;
        while(root.left != null )
        {
            height++;
            root = root.left;
        }

        return height;
    }

    private int getRight(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }

        int height = 0;
        while(root.right != null )
        {
            height++;
            root = root.right;
        }

        return height;
    }

    public int countNodesIterTimeExceeded(TreeNode root) {

        if(root == null)
            return 0;

        int result = 0;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        //define a pointer to track nodes
        TreeNode p = root;

        while(!stack.empty() || p != null)
        {

            // if it is not null, push to stack
            //and go down the tree to left
            if(p != null){
                stack.push(p);
                p = p.left;

                // if no left child
                // pop stack, process the node
                // then let p point to the right
            }else{
                TreeNode t = stack.pop();
                result++;;
                p = t.right;
            }
        }

        return result;
    }

    public int countNodesLevelOrderTimeExceeded(TreeNode root) {

        int count = 0;
        Queue<TreeNode> s1 = new LinkedList<TreeNode>();
        Queue<TreeNode> s2 = new LinkedList<TreeNode>();
        Queue<TreeNode> temp = new LinkedList<TreeNode>();

        if (root == null) {
            return count;
        }

        s1.add(root);


        while (!s1.isEmpty()) {
            TreeNode n = s1.poll();

            count++;
            if (n.left != null)
                s2.add(n.left);
            if (n.right != null)
                s2.add(n.right);

            if (s1.isEmpty()) {


                temp = s1;
                s1 = s2;
                s2 = temp;

            }

        }

        return count;
    }
}
