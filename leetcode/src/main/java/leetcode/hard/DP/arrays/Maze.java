package leetcode.hard.DP.arrays;
import  java.util.*;
public class Maze {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        // note: for (x,y), we use (start[0], start[1]), so int[] start

        // Using "BFS" (important)

        // new boolean[][] visited (with the same size as the maze)
        boolean[][] visited = new boolean[maze.length][maze[0].length];

        // four directions
        int[][] dirs={{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        // new a "queue" to process "points", so Queue< int[] >
        Queue < int[] > queue = new LinkedList < > ();

        // put the start point into the queue
        queue.add(start);

        // initial: the start point is "visited"
        visited[start[0]][start[1]] = true;

        // process the "points" (by using BFS)
        while (!queue.isEmpty()) {

            // pop a point (from the queue)
            int[] s = queue.remove();

            // if the point is the destination, then return true
            if (s[0] == destination[0] && s[1] == destination[1])
                return true;

            // otherwise, for each "direction"
            for (int[] dir: dirs) {

                // the next point (x,y)
                int x = s[0] + dir[0];
                int y = s[1] + dir[1];

                // check if the next point (x, y) is valid or not
                // note: using "while loop", so it can keep rolling
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    // keep rolling
                    x += dir[0];
                    y += dir[1];
                }

                // note: after while loop, the stop point is "{x - dir[0], y - dir[1]})"
                // check if the stop point is visited or not

                 int xStopPoint = x - dir[0];
                 int yStopPoint = y - dir[1];
                 if (!visited[xStopPoint ][yStopPoint ]) {
                    // add the stop point into the "queue" (next start point)
                    queue.add(new int[] {xStopPoint, yStopPoint });
                    // update
                    visited[xStopPoint][yStopPoint ] = true;
                }
            }
        }

        // if not return inside the while loop (i.e.,BFS), then return false
        // cannot reach the destination
        return false;
    }

    public static void main (String[] args)
    {
        int[][] matrix = {{0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        Maze m = new Maze();
        m.hasPath(matrix, new int[]{0,4} , new int[]{4,4});

    }
}
