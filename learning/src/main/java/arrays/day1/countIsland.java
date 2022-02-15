package arrays.day1;

public class countIsland {
    /*
    Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

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

    public static int countIsland(char[][] num){
        if(num.length==0) return 0;
        int count=0;
        for(int row=0; row<num.length;row++){
            for(int col=0; col<num[row].length;col++){
                if(num[row][col]=='1'){
                    count+=dfs(num,row, col);
                }
            }
        }
        return count;
    }

    // dfs toget all connected 1s
    public static int dfs(char[][]num, int row,int col){
        // base case
        if(row<0||row>num.length||col<0||col>num[row].length||num[row][col]=='0'){
            return 0;
        }
        int count =1;
        num[row][col] = '0';
       dfs(num, row+1,col);
        dfs(num, row-1,col);
       dfs(num, row,col+1);
        dfs(num, row,col-1);
        return count;
    }

    public static void main(String[] args) {
        char[][] num= {{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}};
        System.out.println(countIsland(num));
    }
}
