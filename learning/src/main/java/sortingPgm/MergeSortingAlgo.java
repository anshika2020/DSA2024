package sortingPgm;

import java.util.Arrays;

public class MergeSortingAlgo {

    /*
    Divide and conquer : divide one big array to multiple sub problems then joining them together after sorting
     */
    // recursively
    private static int[] mergeSort(int arr[], int len){
        if(len<2){
            return arr;
        }
        int mid = len/2;
        int[] lArray = new int[mid]; // create array to store first half subarray
        int[] rArray = new int[len - mid]; // create array to store second half subarray

        //O(n)
        for (int i = 0; i < mid; i++) { // iterate from 0 to mid of the array length
            lArray[i] = arr[i]; // store ith till mid in empty lArray[]
        }
        //O(n)
        for (int i = mid; i < len; i++) {// iterate from mid to lenght of the array
            rArray[i - mid] = arr[i]; // store ith from i-mid in empty rArray[]
        }
        //O(n)
        mergeSort(lArray, mid); // recursive call to sort left sub array
        //O(n)
        mergeSort(rArray, len - mid); // recursive call to sort right subarray

        //O(n)
        mergeBothSubArray(arr, lArray, rArray, mid, len - mid); // now after sorting combine or merge both arrays
       return arr;
    }

    private static void mergeBothSubArray(int[] arr, int[] lArray, int[] rArray, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) { // loop till i and j are     less than left and right
            if (lArray[i] <= rArray[j]) { // check if
                arr[k++] = lArray[i++];
            }
            else {
                arr[k++] = rArray[j++];
            }
        }
        while (i < left) {
            arr[k++] = lArray[i++];
        }
        while (j < right) {
            arr[k++] = rArray[j++];
        }
    }

    public static void main(String[] args) {
        int[] actual = { 5, 1, 6, 2, 3, 4 };
        int[] expected = { 1, 2, 3, 4, 5, 6 };

        System.out.println(Arrays.toString(mergeSort(actual,actual.length)));

    }
}
