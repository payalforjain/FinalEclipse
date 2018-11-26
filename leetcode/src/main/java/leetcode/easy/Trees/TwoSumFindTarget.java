package leetcode.easy.Trees;
import java.util.*;

public class TwoSumFindTarget {
  /*  Input:
            5
            / \
            3   6
            / \   \
            2   4   7

    Target = 9
*/
    public boolean findTargethash(TreeNode root, int k) {
        Set < Integer > set = new HashSet();
        Queue < TreeNode > queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            if (queue.peek() != null) {
                TreeNode node = queue.remove();
                if (set.contains(k - node.val))
                    return true;
                set.add(node.val);
                queue.add(node.right);
                queue.add(node.left);
            } else
                queue.remove();
        }
        return false;
    }
    /*
    Complexity Analysis

Time complexity : O(n) We need to traverse over the whole tree once to do the inorder traversal. Here, nn refers to the number of nodes in the given tree.

Space complexity : O(n)). The sorted listlist will contain nn elements.
     */

    public boolean findTarget(TreeNode root, int k) {
        Set < Integer > set = new HashSet();
        return find(root, k, set);
    }
    public boolean find(TreeNode root, int k, Set < Integer > set) {
        if (root == null)
            return false;
        if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }

    /*
    Complexity Analysis

Time complexity : O(n)O(n). The entire tree is traversed only once in the worst case. Here, nn refers to the number of nodes in the given tree.

Space complexity : O(n)O(n). The size of the setset can grow upto nn in the worst case.
     */
}
