package arrays.day1;

import java.util.*;

public class AttendMeetings {
    /*
    Attend Meetings

Given a list of meeting intervals where each interval consists of a start and an end time,
check if a person can attend all the given meetings such that only one meeting can be attended at a time.
Example One
Input = [[1, 5], [5, 8], [10, 15]]

Output = 1

As the above intervals are non-overlapping intervals, it means a person can attend all these meetings.
     */

    public static boolean canAttendMeetings(int[][] intervals) {
        // sort the arrays by start time
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        printArr(intervals);
        for(int i=0;i<intervals.length-1;i++){
            if(intervals[i][1]>intervals[i+1][0]){
                return false;
            }
        }
        return true;
    }

    static void printArr(int[][]arr){
        for(int[] num: arr){
            System.out.println(Arrays.toString(num));
        }
    }

    // using list of list
    public static int can_attend_all_meetings(List<List<Integer>> intervals) {
        intervals.sort(Comparator.comparing(x -> x.get(1)));
        int count=0;

        for(int i=0; i<intervals.size()-1;i++){

            if(intervals.get(i).get(1)>intervals.get(i+1).get(0)){
                System.out.println("intervals.get(i).get(1) :" + intervals.get(i).get(1) +" intervals.get(i+1).get(0) :" + intervals.get(i+1).get(0));
                count+=1;
            }else{
                count--;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        int [][] intervals = {{1, 5}, {5, 8}, {10, 15}};
        List<Integer> num1 = Arrays.asList(new Integer[]{1, 5});
        List<Integer> num2 = Arrays.asList(new Integer[]{5, 8});
        List<Integer> num3 = Arrays.asList(new Integer[]{10, 15});

        List<List<Integer>> num = new ArrayList<List<Integer>>(){{
                                            add(num1);
                                            add(num2);
                                            add(num3);}};

        List<List<Integer>> num4 = new ArrayList<List<Integer>>(
                        Arrays.asList(Arrays.asList(new Integer[]{1, 5}),
                        Arrays.asList(new Integer[]{5, 8}),
                        Arrays.asList(new Integer[]{10, 15})));

        System.out.println(can_attend_all_meetings(num4));
    }
}

