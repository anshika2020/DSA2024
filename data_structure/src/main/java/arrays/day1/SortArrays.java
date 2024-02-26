package arrays.day1;

import java.util.Arrays;

public class SortArrays {
    /*
    sort the arrays
    input = [5,2,3,1]
    output = [1,2,3,5]
     */
    /*
    Approaches would depend on how big or small the array is
    if there are just 5 to 10 then I would simple use bubblle sort
    if big then I would either use merge sort but cons is extra memory, if I use quick sort then it would in place.
     */
 // merge sort using recursion


    public static int[] sortArray(int[] nums) {
        if(nums.length<2) {
            return nums;
        }

        merge(nums);
        System.out.println(Arrays.toString(nums));
        return nums;
    }

    public static void merge(int[] nums){
        int mid = nums.length/2; // get the mid element
        // create two arrays to store left and right halves
        int []left= new int[mid];
        int [] right = new int [nums.length-mid];
        // need to copy half of the array in both arrays
        for(int i=0; i<mid;i++){
            left[i] = nums[i];
        }
        System.out.println("left arr : "+ Arrays.toString(left));

        for(int j=mid;j< nums.length;j++){
            right[j-mid] = nums[j];
        }
        if(nums.length<2){
            return;
        }
           merge(left);
           merge(right);
        mergBothArrays(nums,left, right);

    }

    public static void mergBothArrays(int nums[], int[]left, int[]right){
        int i=0; // for left half
        int j=0; // for second half
        int k=0; // for the actual array
        // put all the small element of left and right array in the main array
        while(i<left.length&&j<right.length){
            if(left[i]<=right[j]){
                nums[k] = left[i];
                i++;
                k++;
            }else{
                nums[k] = right[j];
                j++;
                k++;
            }
        }

        // now put all remaining element from left arr to main array
        while(i<left.length){
            nums[k]= left[i];
            i++;
            k++;
        }
        //put all remaining fromright half to main array
        while(j<right.length){
            nums[k] = right[j];
            k++;
            j++;
        }

    }
    // quick sort

    public static void main(String[] args) {
        int[] arr = {6,3,5,1};
        System.out.println(Arrays.toString(sortArray(arr)));
    }

}
