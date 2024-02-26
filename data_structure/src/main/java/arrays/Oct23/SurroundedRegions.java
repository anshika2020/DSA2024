package arrays.Oct23;

import java.util.Arrays;

public class SurroundedRegions {

    /*
    130. Surrounded Regions
Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
Explanation: Notice that an 'O' should not be flipped if:
- It is on the border, or
- It is adjacent to an 'O' that should not be flipped.
The bottom 'O' is on the border, so it is not flipped.
The other three 'O' form a surrounded region, so they are flipped.

     */

    public static  void  surroundedRegion(char board[][]){
        // check edge case
        if(board.length<2) return;
        //now get total rows and columns
        int m = board.length;
        int n= board[0].length;

        // now get al edges of the board
        /*
        check if : 1) board[r][c] has 'O' and  either condition true in any corner r==0, c==0 and r==m-1, c= n-1(This will check all corners of the boars)
        also put # for all zero which can be changed to X
       */
        for(int r=0; r<m;r++){
            for(int c=0; c<n;c++) {
                if (board[r][c] == 'O' && (r == 0 || c == 0 || r == m - 1 || c == n - 1)) {
                    dfs(board, r, c, m, n);
                }
            }
        }

        // now flip O's if not at the edge of the board
        for(int r=0; r<m;r++) {
            for (int c = 0; c < n; c++) {
                if(board[r][c]=='O'){
                    board[r][c] = 'X';
                }else if(board[r][c]=='#'){
                    board[r][c] = 'O';
                }
            }
        }
        System.out.println("Converted one :\n" + Arrays.deepToString(board));
    }

    static void dfs(char board[][], int r, int c, int m, int n){
        // base case
        if(r<0||c<0||r>m-1||c>n-1||board[r][c]!='O') {
            return;
        }
            board[r][c] = '#';
            dfs(board, r+1, c, m, n);
            dfs(board, r-1, c, m, n);
            dfs(board, r, c+1, m, n);
            dfs(board, r, c-1, m, n);

        }

    public static void main(String[] args) {
        char [][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        surroundedRegion(board);

    }
}
