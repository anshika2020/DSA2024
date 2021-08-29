package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxAreadOfIland {

    public static int max_island_size(List<List<Integer>> grid) {
        // Write your code here
        if(grid.size()==0) return 0;
        int max = 0;
        for(int i=0;i<grid.size();i++){ // go through row
            for(int j =0; j<grid.get(i).size();j++){
                if(grid.get(i).get(j)==1){
                    int numberOfIland = getSizeOfIland(grid, i, j);
                    max = Math.max(numberOfIland,max);
                }

            }
        }
        return max;

    }

    static int getSizeOfIland(List<List<Integer>> grid, int i, int j){
        // base case
        /*
        1. check i>0
        2. check j>0
        3. grid.get(i).get(j) ==0
        4. j>grid.get(i).length-1
        */
        if(i<0||j<0||i>grid.size()-1||j>grid.get(i).size()-1||grid.get(i).get(j)!=1){
            return 0;
        }

        int count = 1;
        grid.get(i).set(j, 0); // resetting the valuues to ensure that visited are removed

        count+=getSizeOfIland(grid, i+1, j);
        count+=getSizeOfIland(grid, i-1, j);
        count+=getSizeOfIland(grid, i, j+1);
        count+=getSizeOfIland(grid, i, j-1);
        return count;

    }

    public static void main(String[] args) {
        Integer num[][] = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        List<List<Integer>> grid = new ArrayList<>();
        for (Integer[] n : num) {
            grid.add(Arrays.asList(n));
        }
        System.out.println(max_island_size(grid));
    }

}
