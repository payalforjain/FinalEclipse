package leetcode.medium.arrays;
import java.util.*;
public class Island {

/*
Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
 */
    public int numIslandsBFS(char[][] grid)
    {
        if (grid == null || grid.length == 0)
        {
            return 0;
        }

        int maxRow = grid.length;
        int maxCol = grid[0].length;

        int result = 0;
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        Queue<int[]> neighbors = new LinkedList<>();

        for (int i = 0; i < maxRow; i++)
        {
            for (int j = 0; j < maxCol; j++)
            {
                if (grid[i][j] == '1')
                {
                    result++;
                    grid[i][j] = '0';
                    neighbors.add(new int[]{i, j});

                    while (!neighbors.isEmpty())
                    {
                        int[] s = neighbors.remove();
                        int row = s[0];
                        int col= s[1];
                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
                            neighbors.add( new int[] {row-1 , col });
                            grid[row-1][col] = '0';
                        }
                        if (row + 1 < maxRow && grid[row+1][col] == '1') {
                            neighbors.add( new int[] {row+1 , col });
                            grid[row+1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
                            neighbors.add( new int[] {row , col -1});
                            grid[row][col-1] = '0';
                        }
                        if (col + 1 < maxCol && grid[row][col+1] == '1') {
                            neighbors.add( new int[] {row , col +1});
                            grid[row][col+1] = '0';
                        }

                    }
                }
            }
        }
        return result;

    }

    public int numIslandsBFSBeter(char[][] grid)
    {
        if (grid == null || grid.length == 0)
        {
            return 0;
        }

        int maxRow = grid.length;
        int maxCol = grid[0].length;

        int result = 0;
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        Queue<int[]> neighbors = new LinkedList<>();

        for (int i = 0; i < maxRow; i++)
        {
            for (int j = 0; j < maxCol; j++)
            {
                if (grid[i][j] == '1')
                {
                    result++;
                    grid[i][j] = '0';
                    neighbors.add(new int[]{i, j});

                    while (!neighbors.isEmpty())
                    {
                        int[] s = neighbors.remove();
                        int row = s[0];
                        int col= s[1];
                        for(int[] dir : dirs)
                        {
                            int r = row + dir[0];
                            int c = col + dir[1];
                            if (r < 0 || c < 0 || r >= maxRow || c >= maxCol || grid[r][c] == '0') {
                                continue;
                            }
                            grid[r][c] = '0';
                            neighbors.add(new int[] { r, c });
                        }

                    }
                }
            }
        }
        return result;
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int maxRow = grid.length;
        int maxCol = grid[0].length;

        int result = 0;

        for(int i = 0 ;i < maxRow ; i++)
        {
            for(int j =0 ; j< maxCol ; j++)
            {
                if(grid[i][j] == '1')
                {
                    result++;
                    dfs(grid , i , j );
                }
            }
        }
        return result;

    }

    public void dfs(char[][] grid , int i , int j)
    {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length  || grid[i][j] == '0' )
            return ;

        grid[i][j] = '0';

        dfs(grid , i +1  , j);
        dfs(grid , i -1  , j);
        dfs(grid , i   , j+ 1);
        dfs(grid , i   , j -1);

    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int maxRow = grid.length;
        int maxCol = grid[0].length;

        int result = 0;

        for(int i = 0 ;i < maxRow ; i++)
        {
            for(int j =0 ; j< maxCol ; j++)
            {
                if(grid[i][j] == 1)
                {

                    result = Math.max(result, dfs(grid , i , j ) );
                }
            }
        }
        return result;

    }

    public int dfs(int[][] grid , int i , int j)
    {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length  || grid[i][j] == 0 )
            return 0;

        grid[i][j] = 0;

        return 1 + dfs(grid , i +1  , j) + dfs(grid , i -1  , j) + dfs(grid , i   , j+ 1) + dfs(grid , i   , j -1);

    }
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, "start:");
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }

    private void dfs(int[][] grid, int i, int j, StringBuilder sb, String dir) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == 0) return;
        sb.append(dir);
        grid[i][j] = 0;
        dfs(grid, i-1, j, sb, "d");
        dfs(grid, i+1, j, sb, "u");
        dfs(grid, i, j-1, sb, "l");
        dfs(grid, i, j+1, sb, "r");
        sb.append("#");
    }

    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int GATE = 0;
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if (m == 0) return;
        int n = rooms[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0;i< m; i++) {
            for (int j= 0; j < n; j++) {
                if (rooms[i][j] == GATE) {
                    q.add(new int[] { i, j });

                }

            }
        }

        while (!q.isEmpty()) {
            int[] point = q.poll();
            int row = point[0];
            int col = point[1];
            for (int[] direction :dirs) {
                int r = row + direction[0];
                int c = col + direction[1];
                if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY) {
                    continue;
                }
                rooms[r][c] = rooms[row][col] + 1;
                q.add(new int[] { r, c });
            }
        }
    }
/*
Time complexity : O(mn)O(mn).

If you are having difficulty to derive the time complexity, start simple.

Let us start with the case with only one gate. The breadth-first search takes at most m \times nm×n steps to reach all rooms, therefore the time complexity is O(mn)O(mn). But what if you are doing breadth-first search from kk gates?

Once we set a room's distance, we are basically marking it as visited, which means each room is visited at most once. Therefore, the time complexity does not depend on the number of gates and is O(mn)O(mn).

Space complexity : O(mn)O(mn). The space complexity depends on the queue's size. We insert at most m \times nm×n points into the queue.
 */
}
