package arrays.day1;

import java.util.LinkedList;
import java.util.Queue;

public class CountIslandsBFS {

     /*
    Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
Example 1:

Input: grid = [
  ['1','1','1','1','0'],
  ['1','1','0','1','0'],
  ['1','1','0','0','0'],
  ['0','0','0','0','0']
]
Output: 1
     */


    public static int numIslands(char[][] grid) {

        // get the total number of rows
        int n = grid.length;
        // get the total number of cols
        int m = grid[0].length;
        int count=0;

        // visited array to store all visited cells
        int vis[][] = new int[n][m];
        // iterate through each cell to see if there is island
        for(int r =0; r<n;r++){
            for(int c=0; c<m;c++){
                // check if the cell is visited and is island
                if(vis[r][c]==0 && grid[r][c]=='1'){
                    count++;
                    bfs(r, c, vis, grid);
                }
            }
        }

        return count;
    }

    private static void bfs(int r, int c, int[][] vis, char[][] grid) {

        // now assume we already visited one
         vis[r][c] =1;
         // now create Queue data structure with Pair
        Queue<Pair> q =  new LinkedList<Pair>();
        q.add(new Pair(r, c));

        int n = grid.length;
        int m = grid[0].length;

        while(!q.isEmpty()){
            // peek first and second
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            // traverse in the neighbours and mark them if its a land
            for(int delrow = -1; delrow<=1;delrow++) {
                for(int delcol = -1; delcol <= 1; delcol++) {
                    int nrow = row + delrow;
                    int ncol = col + delcol;
                    // check if neighbour row and column is valid, and is an unvisited land
                    if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                            && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0) {
                        vis[nrow][ncol] = 1;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
        }

    }
    static class Pair
    {
        int first, second;
        public Pair(int first, int second)
        {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        char[][] num= {{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}};
        System.out.println(numIslands(num));
    }
}
