package leetcode.easy.Trees;

import leetcode.Model.TreeNode;

public class SearchNode {

    public TreeNode searchBST(TreeNode root, int val) {

        if (root== null)
            return null;
        else if (root.val == val) {

            return root;
        } else if (root.val > val) {

            return searchBST(root.left, val);
        }

        else if (root.val < val) {

            return searchBST(root.right , val);
        }

        return root;
    }

    public TreeNode searchBSTIterative(TreeNode root, int val) {

        while(root != null)
        {
            if (root.val == val) {

                return root;
            } else if (root.val > val) {

                root =  root.left;
            }

            else if (root.val < val) {

                root = root.right ;
            }
        }


        return root;
    }



}
