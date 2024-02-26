package matrix;

import java.util.Arrays;

public class transpose {
    /*
    m  * n ; m = n = 3;
A= [1 2 3      [00 01 10
    4 5 6       10 11 12
    7 8 9]       20 21 22 ]

A' = [1 4 7
      2 5 8
      3 6 9]

      // dfs , return 2d array,

    /*
     * To execute Java, please define "static void main" on a class
     * named Solution.
     *
     * If you need more classes, simply define them inline.
     */


        public static int[][] transpose(int [][] matrix){
            int [][] newMatrix = new int[matrix[0].length][matrix.length];
            // base condition
            if(matrix.length==0) return matrix;
            for(int i=0; i<matrix.length;i++){
                for(int j=0; j<matrix[i].length; j++){
                   newMatrix[j][i] =matrix[i][j];
                }
            }
            return newMatrix;
        }

        // if m*n are equal
        public int[][] transpose1(int[][] matrix) {
            if(matrix.length==0) return matrix;

            for(int row=0; row<matrix.length;++row){
                for(int col=row; col<matrix[row].length;++col){
                    int temp = matrix[col][row];
                    matrix[col][row] = matrix[row][col];
                    matrix[row][col]=temp;
                }

            }
            return matrix;
        }

        public static void main(String[] args) {
      int [][] num ={{1,2,3},{4,5,6}};//{{1,2,3},{4,5,6},{7,8,9}};
            for(int[] n:transpose(num)){
                System.out.println(Arrays.toString(n));
            }
        }

}
