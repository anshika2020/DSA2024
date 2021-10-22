package sortingPgm;

import java.util.Arrays;

public class RotateArrays {

    /*
    Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].

     Return the array in the form [x1,y1,x2,y2,...,xn,yn].
     Input: nums = [2,5,1,3,4,7], n = 3
Output: [2,3,5,4,1,7]
     */

    private static void rotateArrays(int [] arr, int n){
    // take an array
        //get an int from where to rotate
        //
        for(int num: arr){
            System.out.print(num + " ");
        }

        //rotate the given array by n times towards right
        for(int i=0; i<n;i++){
            int j, last;
            //store the last element in array
            last = arr[arr.length-1];
            for( j=arr.length-1;j>0;j--){
                //Shift element by array by 1
                arr[j] = arr[j-1];
            }
            arr[0] = last;// last element of the array would be added to start of the array.
        }

        System.out.println("Print rotated arrays: "+ Arrays.toString(arr));
    }

    public static void main(String[] str){
        int arr[] = {1,2,3,6,4,2,5};
        int num =3;
        rotateArrays(arr,num);
    }

    /*
    To Do: rotate a big arrays, create the test scenario
    t1: [2,2,4,5,7,0,0];
    t2: {1,2,3,6,4,2,5};
    t3: num is non negative
    t4: Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?
     */
}
