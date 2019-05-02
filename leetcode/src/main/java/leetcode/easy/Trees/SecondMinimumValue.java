package leetcode.easy.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class SecondMinimumValue {

    private int minVal = Integer.MAX_VALUE;
    private int secVal = Integer.MAX_VALUE;
    private void dfs(TreeNode node){
        if(node==null){ return ; }
        if(node.val < minVal){
            secVal = minVal;
            minVal = node.val;
        }
        if(minVal < node.val && node.val < secVal){
            secVal = node.val;
        }
        dfs(node.left);
        dfs(node.right);
    }
    public int findSecondMinimumValue(TreeNode root) {
        dfs(root);
        return secVal < Integer.MAX_VALUE ? secVal : -1;
    }

    /*
    Time Complexity: O(N)O(N), where NN is the total number of nodes in the given tree. We visit each node at most once.

Space Complexity: O(N)O(N). The information stored in \text{ans}ans and \text{min1}min1 is O(1)O(1), but our depth-first search may store up to O(h) = O(N)O(h)=O(N) information in the call stack, where hh is the height of the tree.*/

    public int findSecondMinimumValueBFS(TreeNode root) {

        int minVal = Integer.MAX_VALUE;
        int secVal = Integer.MAX_VALUE;
        if(root == null) return -1;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();

                if(cur.val < minVal){
                    secVal = minVal;
                    minVal = cur.val;
                }
                if(minVal < cur.val && cur.val < secVal){
                    secVal = cur.val;
                }


                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }

        }
        return secVal < Integer.MAX_VALUE ? secVal : -1;
    }

}
