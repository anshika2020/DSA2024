package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountIslands {
    /*Count Islands

Given a two-dimensional boolean matrix, find the number of islands.
An island is a group of connected 1s or a standalone 1. A cell in the matrix can be connected to up to 8 neighbors: 2 vertical, 2 horizontal and 4 diagonal.
Example
Input:
[
    [1, 1, 0, 0, 0],
    [0, 1, 0, 0, 1],
    [1, 0, 0, 1, 1],
    [0, 0, 0, 0, 0],
    [1, 0, 1, 0, 1]
]

Output: 5
(0 0), (0 1), (1 1) and (2 0) make an island.
(1 4), (2 4) and (2 3) make an island.
(4 0) makes an island.
(4 2) makes an island.
(4 4) makes an island.
Notes
Input Format: Function has one argument, a two-dimensional integer matrix. All the values in the matrix are either 0 or 1.
Output Format: Return an integer, the number of islands of 1s.
Constraints:

1 <= rows <= 450
1 <= columns <= 450
Values in the matrix are either 0 or 1.
Use as little extra memory as possible.

Solve the problem without allocating a “visited” matrix.*/


    public static int count_islands(List<List<Integer>> matrix) {
        int count = 0;
        if (matrix.size() == 0) {
            return 0;
        }
        for (int i = 0; i < matrix.size(); i++) { // this one to iterate throogh the row
            for (int j = 0; j < matrix.get(i).size(); j++) { // coulm
                if (matrix.get(i).get(j) == 1) {
                    count++;
                    getNumberOfIlands(matrix, i, j);
                }
            }
        }
        return count;
    }

    private static int getNumberOfIlands(List<List<Integer>> matrix, int i, int j) {
        // base case

        if (i < 0 || j < 0 || i > matrix.size() - 1 || j > matrix.get(0).size() - 1 || matrix.get(i).get(j) != 1) {
            return 0;
        }
        int count = 1;
        matrix.get(i).set(j, 0);

        count += getNumberOfIlands(matrix, i + 1, j);
        count += getNumberOfIlands(matrix, i - 1, j);
        count += getNumberOfIlands(matrix, i, j + 1);
        count += getNumberOfIlands(matrix, i, j - 1);
        // handling diagonal
        count += getNumberOfIlands(matrix, i-1, j +1);
        count += getNumberOfIlands(matrix, i-1, j - 1);
        count += getNumberOfIlands(matrix, i+1, j - 1);
        count += getNumberOfIlands(matrix, i+1, j + 1);

        // d 1: i-1 and j+1 , i-1,j-1, i+1,j-1, i+1,j+1


        return count;

    }

    public static void main(String[] args) {
        Integer num[][] = {{1, 1, 0, 0, 0}, {0, 1, 0, 0, 1}, {1, 0, 0, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 1, 0, 1}};
        List<List<Integer>> matrix = new ArrayList<>();
        for (Integer[] n : num) {
            matrix.add(Arrays.asList(n));
        }
        System.out.println(count_islands(matrix));
    }
}
