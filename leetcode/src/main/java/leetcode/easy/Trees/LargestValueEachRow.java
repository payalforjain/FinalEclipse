package leetcode.easy.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValueEachRow {

    public List<Integer> largestValuesBFS(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                max = Math.max(cur.val, max);
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
            res.add(max);
        }
        return res;
    }

    int level = 0;
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        else {
            largestLevel(0, root, list);
            return list;
        }
    }
    public void largestLevel(int level, TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;
        if (level >= list.size()) list.add(root.val);
        list.set(level, Math.max(list.get(level), root.val));
        largestLevel(level+1, root.left, list);
        largestLevel(level+1, root.right, list);
    }
}
