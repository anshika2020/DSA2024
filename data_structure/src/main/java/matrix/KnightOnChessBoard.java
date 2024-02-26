package matrix;


public class KnightOnChessBoard {
    /*
    MY SCHEDULE
 GRAPHS PRACTICE - PROBLEM SET 1
KNIGHTS TOUR ON A CHESS BOARD
Knights Tour On A Chess Board

You are given a rows * cols chessboard and a knight that moves like in normal chess. Currently knight is at starting position denoted by start_row th row and start_col th col, and want to reach at ending position denoted by end_row th row and end_col th col.  The goal is to calculate the minimum number of moves that the knight needs to take to get from starting position to ending position.
start_row, start_col, end_row and end_col are 0-indexed.
Example
Input:
rows = 5
cols = 5
start_row = 0
start_col = 0
end_row = 4
end_col = 1
Output: 3
3 moves to reach from (0, 0) to (4, 1):
(0, 0) -> (1, 2) -> (3, 3) -> (4, 1).
Notes
Input Parameters:
There are six arguments. First is an integer denoting rows, second is an integer denoting cols, third is an integer denoting start_row, fourth is an integer denoting start_col, fifth is an integer denoting end_row and sixth is an integer denoting end_col.
Output: Return an integer.
If it is possible to reach from starting position to ending position then return the minimum number of moves that the knight needs to take to get from starting position to ending position.
If it is not possible to reach from starting position to ending position then return -1.
     */

    static int find_minimum_number_of_moves(int rows, int cols, int start_row, int start_col, int end_row, int end_col) {
        // create a list to store the moves
        int result = Integer.MAX_VALUE;
        int[][] chess = new int[rows][cols];
        boolean[][] visited= new boolean[rows][cols];
        int res=dfs(chess,  rows,  cols,start_row , start_col , end_row , end_col , 0, result,visited);
        if(res==Integer.MAX_VALUE){
            return -1;
        }
        else {
            return res;
        }
    }
    private static int dfs(int[][] chess, int rows,  int cols, int start_row, int start_col, int end_row, int end_col, int currentMove, int result,boolean[][] visited) {

        //if(start_row<0||start_col<0||start_row>=rows||start_col>=cols||chess[start_row][start_col]<=currentMove){
        if(start_row<0||start_col<0||start_row>=rows||start_col>=cols|| visited[start_row][start_col]){
            return result;
        }

        if(start_row==end_row && start_col==end_col){
            result = Math.min(result,currentMove);
            return result;
        }


        visited[start_row][start_col]=true;
        // moving 2 steps in start_row and one step in coloumn  both sides up and down

        //i+2 --> j+1 and j-1
        int res=dfs(chess,  rows,  cols, start_row + 2, start_col + 1, end_row, end_col, currentMove+1,result,visited);
        res=dfs(chess,  rows,  cols,start_row + 2, start_col - 1, end_row, end_col, currentMove+1,res,visited);
        //  i-2  --> j+1 and j-
        res= dfs(chess,  rows,  cols,start_row - 2, start_col + 1, end_row, end_col, currentMove+1,res,visited);
        res= dfs(chess,  rows,  cols,start_row - 2, start_col - 1, end_row, end_col,currentMove+1,res,visited);

        //  j+2  --> i+1 and i-1
        res= dfs(chess,  rows,  cols,start_row + 1, start_col + 2, end_row, end_col,currentMove+1,res,visited);
        res= dfs(chess,  rows,  cols,start_row - 1, start_col + 2, end_row, end_col,currentMove+1,res,visited);

        //  j-2  --> i+1 and i-1
        res=dfs(chess,  rows,  cols,start_row + 1, start_col - 2, end_row, end_col,currentMove+1,res,visited);
        res=dfs(chess,  rows,  cols,start_row - 1, start_col - 2, end_row, end_col,currentMove+1,res,visited);

        visited[start_row][start_col]=false;

        return res;
    }

    public static void main(String[] args) {

       // System.out.println(find_minimum_number_of_moves(5,5,0,0,4,1));
        System.out.println(find_minimum_number_of_moves(33333,3,333,0,33332, 2));
    }
}