package arrays.day1;

import java.util.Arrays;

public class RemoveElementFromArray {
    /*
    27. Remove Element
    Example 1:

Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 2.
It does not matter what you leave beyond the returned k (hence they are underscores).
     */

    public static int removeElement(int arr[], int val){
        int occur =0;
        int k=0;
        for(int i=0; i<arr.length;i++){
            if(arr[i]==val){
                occur++;
            }else{
                arr[k] = arr[i];
                k++;
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr.length-occur;
    }

    public static void main(String[] args) {
        int[] num ={3,2,2,3};
        System.out.println(removeElement(num,3));
    }
}

