package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    /*
    Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
     */

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b)-> a[0]-b[0]);

        int firstStart=intervals[0][0];
        int firstEnd=intervals[0][1];

        List<List<Integer>> res= new ArrayList<>();
        List<Integer> list= new ArrayList<>();

        for(int i=1;i<intervals.length;i++){
            int currentStart=intervals[i][0];
            int currentEnd=intervals[i][1];

            if(currentStart<=firstEnd){
                if(firstEnd<currentEnd){
                    firstEnd=currentEnd;
                }
            }else{
                list.add(firstStart);
                list.add(firstEnd);
                res.add(list);
                list= new ArrayList<>();
                firstStart=currentStart;
                firstEnd=currentEnd;
            }
        }
        List<Integer> mergedInterval= new ArrayList<>();
        mergedInterval.add(firstStart);
        mergedInterval.add(firstEnd);
        res.add(mergedInterval);
        int i=0;
        int[][] result= new int[res.size()][2];
        for(List<Integer> values: res){
            result[i][0]=values.get(0);
            result[i][1]=values.get(1);
            i++;
        }

        return result;

    }
}
