package arrays;

import java.util.Arrays;

public class SortArrayByPairty {

    //Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
    /*
    Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
     */

    private static int [] sortPairty(int A[]){
        int[] arr = new int[A.length];
        int index=0;
        for(int i=0; i<A.length;i++){
            if(A[i]%2==0) {
                arr[index++] = A[i];
            }
        }
        for(int i=0; i<A.length;i++){
            if(A[i]%2!=0) {
                arr[index++]=A[i];
            }
        }

  System.out.println("Arr  " + Arrays.toString(arr)) ;
     return arr;
    }

    public static void main(String args[]){
        int arr[] = {3,1,2,4} ;
        sortPairty(arr);
    }
}
