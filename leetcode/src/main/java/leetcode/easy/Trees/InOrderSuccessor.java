package leetcode.easy.Trees;
import java.util.*;
public class InOrderSuccessor {

    public TreeNode inorderSuccessorBetter(TreeNode root, TreeNode p) {

        if(root == null || p == null)
        {
            return null;
        }
        TreeNode successor = null;
        while(root !=null )
        {

            if(p.val < root.val)
            {
                successor = root;
                root = root.left;
            }
            else
            {
                root = root.right;
            }
        }

        return successor;
    }

    public TreeNode inorderSuccessor(TreeNode p, TreeNode ele) {

        if(p == null || ele == null)
        {
            return null ;
        }

        boolean nextElement = false;
        Stack<TreeNode> s = new Stack();

        while(!s.isEmpty() || p!= null)
        {

            if(p != null)
            {
                s.push(p);
                p = p.left;
            }

            else
            {
                p = s.pop();
                if(nextElement )
                {
                    return p;
                }
                if( p.val == ele.val)
                {
                    nextElement = true;
                }


                p = p.right;
            }
        }

        return null;
    }
}
