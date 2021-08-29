package sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GroupNumbers {
    /*
    you are given an int arr of size n , group and rearrange them in way that all even goes to left and odds goes to right. The operation should be in-place.
    Algo:
    1.
     */
    private static int [] groupNumbers(int [] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {

            if (arr[start] % 2 == 0) {
                start++;
            }
            else if (arr[end] % 2 == 1) {
                end--;
            }
            else {
                // this is a condition where elemment at start index %2 is greater than end index %2
                //  if((arr[start]%2)>arr[end]%2){
                swap(arr, start, end);
                start++;
                end--;
                //  }
            }

        }
        return arr;
    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    public static void main(String[] args) {
        int arr[] ={3,5,4,7,9,8, 2, 4};
        System.out.println(Arrays.toString(groupNumbers(arr)));
    }
}
