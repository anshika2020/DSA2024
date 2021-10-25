package arrays;

import java.util.Arrays;

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
    public static void main(String[] args) {
        int num[] = {1,0,3,5,0,-1};
        System.out.println(Arrays.toString(moveZerosTpoLeft(num)));
    }
}
