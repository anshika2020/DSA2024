package arrays;

import java.util.Arrays;

public class ShuffleArray {
    /*
    Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
    Return the array in the form [x1,y1,x2,y2,...,xn,yn].
    Input: nums = [2,5,1,3,4,7], n = 3
    Output: [2,3,5,4,1,7]

    Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
     */


    private static  int[] suffleArrays(int [] arr, int n){
        int [] newArr = new int[2*n]; // n is always going to be totalLength/2
        if(arr.length!=n*2){
            System.out.println("Size greater than n*2");
            return null;

        }
        int x =0;
        int y=n;
        int index =0;
        while(x<n){
            newArr[index++] = arr[x++];
            newArr[index++] = arr[y++];
        }

        System.out.println(Arrays.toString(newArr));
        return newArr;

    }

    public static void main(String str[]){
        int arr[] ={2,5,1,3,4,7}; int n = 3;
        suffleArrays(arr,n);
    }

}
