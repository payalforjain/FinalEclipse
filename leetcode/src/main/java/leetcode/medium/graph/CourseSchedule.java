package leetcode.medium.graph;
import java.util.*;
public class CourseSchedule {


    /*
    There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

Example 1:

Input: 2, [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
             course 0. So the correct course order is [0,1] .
Example 2:

Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
     */
    public int[] findOrderBFS(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new HashSet<>());
        }
        int[] inDegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
            inDegree[edge[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int index = 0;
        int[] order = new int[numCourses];
        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[index] = course;
            index++;
            for (int neighbor : graph.get(course)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return index == numCourses ? order : new int[0];
    }


    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numCourses; i++) {
            boolean[] onPath = new boolean[numCourses];
            if (!visited[i] && !dfs(i, graph, onPath, visited, stack)) {
                return new int[0];
            }
        }

        int[] order = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            order[i] = stack.pop();
        }
        return order;
    }

    private boolean dfs(int source, Map<Integer, Set<Integer>> graph, boolean[] onPath, boolean[] visited, Stack<Integer> stack) {
        onPath[source] = true;
        visited[source] = true;

        for (int neighbor : graph.get(source)) {
            if (onPath[neighbor]) {
                return false;
            }
            if (!visited[neighbor] && !dfs(neighbor, graph, onPath, visited, stack)) {
                return false;
            }
        }
        onPath[source] = false;
        stack.push(source);
        return true;
    }


    /*
    207. Course Schedule
Medium

1309

65

Favorite

Share
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0. So it is possible.
     */  // apply DFS from top
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new HashSet<>());
        }
        int[] inDegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
            inDegree[edge[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int index = 0;
        int[] order = new int[numCourses];
        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[index] = course;
            index++;
            for (int neighbor : graph.get(course)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return index == numCourses ;
    }
        public static void  main(String[] args)
    {
        CourseSchedule c = new CourseSchedule();
        c.findOrder(4, new int[][] {{1,0},{2,0},{3,1},{3,2}});
    }
}
