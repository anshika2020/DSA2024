package graphs;

import java.util.Arrays;

public class SurroundedRegions {
    /*
    Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.
Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
Explanation: Surrounded regions should not be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
     */

    // dfs apporach
    /*
    Algorithm:
    1. Traverse all four edges and call dfs util which take board , row and col to set the Os with #. if the cell on the border happens to be O then check all four directions to ensure that it has x before setting to #. if it is not then convert all Os to #
    2. if we check all edges and all four direction cells then we don't need to worry about connected or single Os which are surround by X in all direction.
     */
    public static void surroundedRegionV1(char [][] board){
        int row = board.length; // get the total rows
        int col = board[0].length; // get all columns
        // check base case
        if(board.length==0)return;
       printBoard(board);
        System.out.println("above is example board");
        // check  first row for all columns
        for(int i=0; i<row;i++){
            for(int j=0; j<col;j++){
                // check condition if it does not go to edge
                if(board[i][j]=='O'&&(i==0||i==row-1||j==0||j==col-1)){ // check if the value in the cell is O then call dfs to set Os value to # so that we can check
                    // later whether it needs to converted to X if the connected to regions
                    dfs(board,i,j); // set all edge O to # if they are surrounded by X
                }
            }
        }
        printBoard(board);
        System.out.println("above is the board after setting the O to # ");
        for(int i=0;i<row; i++){
            for(int j=0; j<col;j++){
                if(board[i][j]=='#') { // setting back to O now because they are not part of eligible surround by X criteria
                    board[i][j] = 'O';
                }else if(board[i][j]=='O'){ // if there O then set to X
                   board[i][j] ='X';
                }

            }
        }
        printBoard(board);

    }

    static void printBoard(char[][] board){
        for(char[] ch:board) {
            System.out.println(Arrays.toString(ch));
        }
    }
    private static void dfs(char[][] board, int i, int j) {

        if(i<0 || i>board.length-1||j<0||j>=board[i].length||board[i][j]!='O'){
          return;
        }

        board[i][j] ='#'; // setting all Os to #
        dfs(board,i+1, j);
        dfs(board,i-1, j);
        dfs(board,i, j+1);
        dfs(board,i, j-1);
    }

    public static void main(String[] args) {
        char[][]  board = {{'X','X','O','O'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        surroundedRegionV1(board);
    }
}
