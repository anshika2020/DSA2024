package patterns.slidingWindow_pattern;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubarraysFromArray {
    // print all subarray from array
    /*
    Input [] = {1, 2, 3, 4}
Output: [ 1 ] [ 1 2 ] [ 1 2 3 ] [ 1 2 3 4 ] [ 2 ] [ 2 3 ] [ 2 3 4 ] [ 3 ] [ 3 4 ] [ 4 ]
     */

    public static List<List<Integer>> subarraySum(int[] nums) {
        List<List<Integer>> result =new ArrayList<>();
        for(int i=1;i<=nums.length;i++){
            result.add(getcountsubarray(nums,i));
        }

        return result;
    }

    public static List getcountsubarray(int[]array, int size){
        int cnt =0; List<Integer> list=new ArrayList<>();
        for(int i=0;i<=array.length-size;i++){ // This is to get 1st element of a subarray // i=0//i=1
            int sum =0;

            for(int j=i;j<i+size;j++){ // This is to get all elements of the subarray starting i//j=0,. j<0+2// j=1,i<2

                list.add(array[j]);
                sum+=array[j];// [1] //1+[2] ==3
            }

//            if(sum==k){
//                cnt++;
//            }
        }
        return list;
    }
    // appraoch 1 to use three nestedloop
    public static List<List<Integer>> printSubArray(int [] input, int currIndex){
        List<List<Integer>> results = new ArrayList<>();
        helper(input,currIndex, results);

        return results;
    }
    public static void helper(int [] input, int currIndex, List<List<Integer>> results){
       ArrayList<Integer> temp = new ArrayList<>();
        if(currIndex==input.length)
            return;
        for (int i = currIndex; i <input.length ; i++) {
            temp.add(input[i]);

            results.add(new ArrayList<>(temp));
        }
        helper(input, currIndex+1, results);
    }

    public static void main(String[] args) {
        int [] arrA = {1,2,3,4};
        System.out.println(new PrintAllSubarraysFromArray().printSubArray(arrA,0));
       // System.out.println(subarraySum(arrA));
    }

}
