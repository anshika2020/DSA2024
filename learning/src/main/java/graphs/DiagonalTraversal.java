package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DiagonalTraversal {
    public static int[] findDiagonalOrder(int[][] matrix) {

        // Check for empty matrices
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        // Variables to track the size of the matrix
        int row = matrix.length;
        int col = matrix[0].length;

        // The two arrays as explained in the algorithm
        int[] result = new int[row*col];
        int k = 0;
        ArrayList<Integer> intermediate = new ArrayList<Integer>();

        // We have to go over all the elements in the first
        // row and the last column to cover all possible diagonals
        for (int i = 0; i < row + col - 1; i++) {

            // Clear the intermediate array every time we start
            // to process another diagonal
            intermediate.clear();

            // We need to figure out the "head" of this diagonal
            // The elements in the first row and the last column
            // are the respective heads.
            int r = 0;
            int c=0;
            if(i<col){
                r=0;
                c=i;
            }else{
                r= i-col+1;
                c=col-1;
            }

            // Iterate until one of the indices goes out of scope
            // Take note of the index math to go down the diagonal
            while (r < row && c > -1) {

                intermediate.add(matrix[r][c]);
                r++;
                c--;
            }

            // Reverse even numbered diagonals. The
            // article says we have to reverse odd
            // numbered articles but here, the numbering
            // is starting from 0 :P
            if (i % 2 == 0) {
                Collections.reverse(intermediate);
            }

            for (int j = 0; j < intermediate.size(); j++) {
                result[k++] = intermediate.get(j);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int num[][] = {{1,2,3},{4,5,6},{7,8,9}};
//        List<List<Integer>> image = new ArrayList<>();
//        for (Integer[] n : num) {
//            image.add(Arrays.asList(n));
//        }
        System.out.println(Arrays.toString(findDiagonalOrder(num)));
    }
}
