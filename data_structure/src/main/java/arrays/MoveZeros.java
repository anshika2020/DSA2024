package arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MoveZeros {

    /*
    input = [1,0,3,5,0,-1]
    output = [0,0,1,3,5,-1]
   constrain: 0s sould bemoved to left and non zero to right side but they should no change the sequence
     */
    public static int[] moveZerosTpoLeft(int[] arr){
        if(arr.length<=1) return new int[0];

        int nonZeroIndex=0; // take  a temp position to store next element of ith.
        for(int i=0; i<arr.length-1;i++){
            if(arr[i]==0){// index 1,
                shiftNonZeroElement(arr, nonZeroIndex,i);
                nonZeroIndex++; // after swapping need to increment by one the nonZeroIndex elem
            }
            System.out.println("Arr : " + Arrays.toString(arr) + " : nozeroIndex : "+nonZeroIndex);
        }
        return arr;
    }

    public static void shiftNonZeroElement( int[] arr,int moveToIndex, int moveFromIndex){
         int temp = arr[moveFromIndex];// get move from index element and store into temp
        //now shift elements from movFromIndex-1 to moveToIndex to its +1 position
        // then put temp into the moveToIndex
        for(int i=moveFromIndex; i>moveToIndex;i--){
           arr[i]= arr[i-1];
        }
        arr[moveToIndex] =temp;

    }
    // two pointer approach for move all zero to left

    public static void moveZerosToLeft1(int[] arr, int n)
    {
        int count=arr.length-1;
        // iterate from last index to 0
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]!=0){
                arr[count] = arr[i];
                count--;
            }
        }

        while(count>=0){
            arr[count] =0;
            count--;
        }
    }

    // linear
    public static void moveZeros3(int[] arr){
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<arr.length-1;i++){
            q.add(arr[i]);
            if(arr[i]==0){
              q.add(arr[i]);
            }
            arr[i] =q.remove();

        }
        System.out.println(Arrays.toString(arr));
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    // two pointer approach for move all zero to right
    public static int[] moveZerosToRt1(int[] arr){

        int count =0;
        // Traverse the array. If element encountered is
        // non-zero, then replace the element at index 'count'
        // with this element
        for(int i=0;i<arr.length;i++){

            if(arr[i]!=0){
                arr[count] = arr[i];
                count++;
            }
        }
// Now all non-zero elements have been shifted to
        // front and 'count' is set as index of first 0.
        // Make all elements 0 from count to end.
        while(count<arr.length){
            arr[count] =0;
            count++;
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static void moveZerosToRt2(int arr[]){
        int j=0;
        for(int i=0; i< arr.length;i++){
            if(arr[i]!=0){ // to move left just arr[i]==0
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int num[] = {1,0,3,5,0,-1};

        //System.out.println(Arrays.toString(moveZerosTpoLeft(num)));
      //  System.out.println(Arrays.toString(moveZeros1(num)));

       // moveZeros3(num);
        moveZerosToRt1(num);
       moveZerosToRt2(num);
    }
}
