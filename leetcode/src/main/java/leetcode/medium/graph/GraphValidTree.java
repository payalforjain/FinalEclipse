package leetcode.medium.graph;

import java.util.ArrayList;
import java.util.*;

public class GraphValidTree {
/*
Example 1:

Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
Output: true
Example 2:

Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
Output: false
 */
//bfs
    public boolean validTreebfs(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for(int i=0; i<n; i++){
            ArrayList<Integer> list = new ArrayList<Integer>();
            map.put(i, list);
        }

        for(int[] edge: edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        while(!queue.isEmpty()){
            int top = queue.poll();
            if(visited[top])
                return false;

            visited[top]=true;

            for(int i: map.get(top)){
                if(!visited[i])
                    queue.offer(i);
            }
        }

        for(boolean b: visited){
            if(!b)
                return false;
        }

        return true;
    }

    //dfs
    public boolean validTree(int n, int[][] edges) {

        Map<Integer, List<Integer>> map  = new HashMap<>();

        for(int i = 0 ; i < n ; i++)
        {
            map.put(i , new ArrayList<Integer>());
        }


        for(int edge[] : edges)
        {

            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        if(!dfs(-1 , 0 , map, visited ))
            return false;

        for(boolean b: visited){
            if(!b)
                return false;
        }

        return true;
    }


    private boolean dfs(int parent , int current, Map<Integer, List<Integer>> map, boolean[] visited  )
    {
        if(visited[current] == true)
            return false;

        visited[current] = true;

        for(int i: map.get(current)){

            if(i != parent   && !dfs(current, i , map, visited  ) )
            {
                return false;
            }

        }
        return true;
    }


    public static void main(String[] args)
    {
        GraphValidTree g = new GraphValidTree();
        int[][] edges = {{0,1}, {0,2}, {0,3}, {1,4}};
        g.validTreebfs(5, edges);
    }
}
