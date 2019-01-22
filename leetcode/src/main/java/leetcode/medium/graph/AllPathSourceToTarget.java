package leetcode.medium.graph;

import java.util.ArrayList;
import java.util.List;

public class AllPathSourceToTarget {

    public List<Integer> column;
/*
Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.

The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.

Example:
Input: [[1,2], [3], [3], []]
Output: [[0,1,3],[0,2,3]]
Explanation: The graph looks like this:
0--->1
|    |
v    v
2--->3
There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        path.add(0);
        dfs(graph,0,result,path);
        return result;
    }

    public void dfs(int[][] graph, Integer node, List<List<Integer>> result, List<Integer> path){
        if(node==graph.length-1){
            result.add(new ArrayList<Integer>(path));
            return;
        }

        for(int nextNode:graph[node]){
            path.add(nextNode);
            dfs(graph, nextNode, result, path);
            path.remove(path.size()-1);
        }
    }
}
