package arrays;

import java.lang.reflect.Array;
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

    // time complexity is O(n^2) because first it williterate n times till array length then if find zero then iterate from last index to greater than ith index.
public static int[] dupZeros(int[] arr){
    if(arr.length==0){
        return null;
    }
    // find zeros in the array
    for(int i=0; i<arr.length; i++){
        if(arr[i]==0){
            for(int j=arr.length-1;j>i;j--){
                System.out.println("i: "+ i +" j : "+j + " arr[j] "+ arr[j]+"  j-1: "+arr[j-1]);
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

           queue.add(arr[i]);// add ith element in the queue
         //  System.out.println("values in queue : "+ queue);
           if(arr[i]==0) { // check ifith is zero then add extra zero in the queue
               queue.add(0);
           }
              // System.out.println("values in queue after arr[0] check: "+ queue);
               arr[i] = queue.remove(); // it will remove the element which came first because queue work FIFO , after adding additional zero we can then move the extra zero to ith index in array
               System.out.println("value of arr[i] :" + arr[i]);
           System.out.println("values in arr: "+ Arrays.toString(arr));

       }
       return arr;
   }

    public static void main(String[] args) {
        int arr[]= {1,0,2,3,0,4,5,0};
        System.out.println(Arrays.toString(dupZeros(arr)));
     //   // using queue
       System.out.println(Arrays.toString(duplicateZeros(arr)));
    }
}
