package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloodFill {
    /*
    Flood Fill
One pixel on a grayscale image changes color. Recolor all the adjacent pixels of the same color to the same new color.
Grayscale colors are simply numbers.
Example One
{
"pixel_row": 0,
"pixel_column": 1,
"new_color": 2,
"image": [
[0, 1, 3],
[1, 1, 1],
[1, 5, 4]
]
}
I.e. the pixel at row 0 and column 1 changes to color 2.
Output:
[
[0, 2, 3],
[2, 2, 2],
[2, 5, 4]
]
Example Two
{
"pixel_row": 1,
"pixel_column": 0,
"new_color": 9,
"image": [
[0, 2, 1],
[1, 1, 2],
[2, 5, 4]
]
}
I.e. the pixel at row 1 and column 0 changes to color 9.
Output:
[
[0, 2, 1],
[9, 9, 2],
[2, 5, 4]
]
Notes
Two pixels are considered adjacent if they share a side; sharing a diagonal is not enough.
Constraints:
1 <= image width <= 1000
1 <= image height <= 1000
0 <= pixel color <= 1000
     */

    static List<List<Integer>> flood_fill(Integer pixel_row, Integer pixel_column, Integer new_color, List<List<Integer>> image) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int color = image.get(pixel_row).get(pixel_column);
      // write the base case first
      if(pixel_row<0||pixel_column<0||image.size()<0){
          return new ArrayList<>();
      }
      // functional
        if(color!=new_color){
            dfs(pixel_row,pixel_column,new_color,color,image);
        }
        return image;
    }

    private static int dfs(Integer pixel_row, Integer pixel_column, Integer new_color, int color, List<List<Integer>> image) {

        // Base cases
        if (pixel_row < 0 || pixel_row >image.size()-1 || pixel_column < 0 || pixel_column > image.get(pixel_row).size() - 1 || image.get(pixel_row).get(pixel_column) != color) {
            return 0;
        }
        int count =1;
        image.get(pixel_row).set(pixel_column, new_color);
        count +=dfs(pixel_row + 1, pixel_column, new_color, color, image);
        count +=dfs(pixel_row - 1, pixel_column, new_color, color, image);
        count +=dfs(pixel_row, pixel_column + 1, new_color, color, image);
        count += dfs(pixel_row, pixel_column - 1, new_color, color, image);
        return count;
    }


    // Leetcode

    public static void main(String[] args) {
        Integer num[][] = {{0, 1, 3}, {1, 1, 1}, {1, 5, 4}};
        List<List<Integer>> image = new ArrayList<>();
        for (Integer[] n : num) {
            image.add(Arrays.asList(n));
        }

       // System.out.println(flood_fill(0, 1, 2, image));
        /*
        [[1,1,1],[1,1,0],[1,0,1]]
1
1
2
         */
        int [][] nums = {{1,1,1},{1,1,0},{1,0,1}};
        System.out.println(Arrays.deepToString(floodFill(nums, 1, 1, 2)));

    }
/*
output:
[
[0, 2, 3],
[2, 2, 2],
[2, 5, 4]
]
 */

    // leetcode#733
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if(color !=newColor){
            dfs1(image, sr, sc, color, newColor);
        }
        return image;
    }

    private static int dfs1(int[][] grid, int sr, int sc, int color, int newColor){
        // check base case
        if(sr<0||sc<0||sr>grid.length-1||sc>grid[sr].length-1||grid[sr][sc]!=color){
            return 0;
        }

        int count =1;
        grid[sr][sc] = newColor;
        count += dfs1(grid, sr+1, sc, color, newColor);
        count += dfs1(grid, sr-1, sc, color, newColor);
        count += dfs1(grid, sr, sc+1, color, newColor);
        count +=dfs1(grid, sr, sc-1, color, newColor);
        return count;
    }

}
