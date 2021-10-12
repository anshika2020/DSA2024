package arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DuplicateZeros {
     /*
    Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.

Note that elements beyond the length of the original array are not written.

Do the above modifications to the input array in place, do not return anything from your function.
Example 1:
Input: [1,0,2,3,0,4,5,0]
Output: null
Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
*/

public static int[] dupZeros(int[] arr){
    if(arr.length==0){
        return null;
    }
    // find zeros in the array
    for(int i=0; i<arr.length; i++){
        if(arr[i]==0){
            for(int j=arr.length-1;j>i;j--){
                arr[j] = arr[j-1];
            }
            i++;
        }
    }
    return arr;
}

// using Queue
   public static int[] duplicateZeros(int [] arr){
    // create a queue
       Queue<Integer> queue = new LinkedList<>();
       for(int i=0; i< arr.length;i++){
           queue.add(arr[i]);
           if(arr[i]==0){
               queue.add(0);
               arr[i] = queue.remove();
           }
       }
       return arr;
   }

    public static void main(String[] args) {
        int arr[]= {1,0,2,3,0,4,5,0};
        System.out.println(Arrays.toString(dupZeros(arr)));
        // using queue
        System.out.println(Arrays.toString(duplicateZeros(arr)));
    }
}
