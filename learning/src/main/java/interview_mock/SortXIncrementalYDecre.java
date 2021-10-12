package interview_mock;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class SortXIncrementalYDecre {
    //[[1,2],[2,3],[1,4]]
//[[1,4],[1,3],[1,2]]
// x inc
// y dec if x is the same
//output: [[1,4],[1,3],[1,2],[3,4],[3,3],[3,2]]

    public static int[][] sortXandYInArray(int[][] arr) {
        Arrays.sort(arr, new Comparator<int[]>() { // sort the array using comparator
            @Override
            public int compare(int[] o1, int[] o2){
               if(o1[0]==o2[0]){// if x is the same
                  return o2[0]-o1[0];
               }else {
                   return o1[0]-o2[0];
               }
            }


        });
        return arr;
    }

    public static void main(String[] args) {
        int nums[][] = {
                {1,2},{2,3},{1,4}};
        for(int num[] : sortXandYInArray(nums)) {
            System.out.print(Arrays.toString(num));
        }
    }


}