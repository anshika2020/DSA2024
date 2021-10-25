package dd_15Nov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindNearestPointXnYCor {

    public static int nearestValidPoint1(int x, int y, int[][] points) {
       if(points.length<1)return -1;
        int dist =-1; int index = -1;
        // create a 2D array to store valid point
       List<List<Integer>> validPoints = new ArrayList<>();

        // iterate through the array
        for(int[] num:points){
            List<Integer> temp = new ArrayList<>();
            if(num[0]==x||num[1]==y){
              //  System.out.println("x: "+ x + " y :" +y);
             //   System.out.println("\n num value in if :" + num[0]+","+num[1]);
              temp.add(num[0]);
              temp.add(num[1]);
              validPoints.add(temp);
            }

        }
        System.out.println("values in list of list :" + validPoints);
        // calculate the smallest distance
        for(List<Integer> list : validPoints ){

           // System.out.println("list : list.get(0)"+ list);
            int mandist = Math.abs(x-list.get(0))+Math.abs(y-list.get(1));
            if(dist==-1){
                dist = mandist;
                index = getIndex(points,list);
                System.out.println("value of dist : "+ dist);
            }
            if(mandist<dist){
                dist = mandist;
                index = getIndex(points,list);
                System.out.println("value of dist : "+ dist);
            }
        }
       return index;
    }


    // another approach without using the extra memory

    public static int nearestValidPoint2(int x, int y, int[][] points ){
        // check base case
        if(points.length==0) return -1;
        int dist=-1;
        int index =-1;
        // iterate through the array
        for(int i=0; i<points.length;i++) {
            if (x == points[i][0] || y == points[i][1]) {
                if (x == points[i][0] && y == points[i][1]) {
                    return i; // this one just check if both x and y matches with given points
                }

                int temp = Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]);
                if (dist ==-1) {
                    dist = temp;
                    index = i;
                }else {
                    if (dist > temp) {
                        dist = temp;
                        index = i;
                    }
                }

            }
        }
        return index;
    }
    private static int getIndex(int[][] arr, List<Integer> list){
        int index = -1;
        for(int i=0; i<arr.length;i++){
            if(arr[i][0]==list.get(0)&&arr[i][1]==list.get(1)){
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
       int [][] point = {{1,1},{1,1}};//{{1,2},{3,1},{2,4},{2,3},{4,4}};
       for(int[] num : point) {
           System.out.print(Arrays.toString(num));
       }
       // System.out.println(nearestValidPoint1(1, 1, point));

        System.out.println();
        System.out.println(nearestValidPoint2(1,1,point));
    }
}
