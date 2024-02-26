package arrays;

import java.util.Arrays;

public class ArraysInZigzag {

    /*
    Given an array of DISTINCT elements, rearrange the elements of array in zig-zag fashion in O(n) time. The converted array should be in form a < b > c < d > e < f.
    Input: arr[] = {4, 3, 7, 8, 6, 2, 1}
    Output: arr[] = {3, 7, 4, 8, 2, 6, 1}
     */

    // simple solution is to just keep on swaping with next number whether less than previous element or greater than previous,
    // keep on tracking with flag to see if the number already have been swapped
    public static int[] getZigzag(int num[]){
        if(num.length<=1){
            return null;
        }
        boolean flag = true;// Flag true indicates relation "<" is expected,else ">" is expected. The first expected relation is "<"
        // iterate through the array
        for(int i=0; i<num.length-1;i++){
            if(flag) {
                if (num[i] > num[i + 1]) {
                    int temp = num[i];
                    num[i] = num[i + 1];
                    num[i + 1] = temp;

                }
            }else{
                    if(num[i]<num[i+1]){
                        int temp = num[i];
                        num[i] = num[i+1];
                        num[i+1] = temp;
                    }
                }
            flag = !flag; // ressetting the flag


        }
        return num;
    }

    public static void main(String[] args) {
        int num [] = {4, 3, 7, 8, 6, 2, 1};
     //    int num [] = {4, 3};
        System.out.println(Arrays.toString(getZigzag(num)));
    }
}
