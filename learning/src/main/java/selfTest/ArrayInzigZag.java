package selfTest;

import java.util.Arrays;

public class ArrayInzigZag {

    /*
    input = [4,3,7,8,6,2,1]
    output = [3,7,4,8,2,6,1]
     */

    // simple apporach is to keep on swapping the element with the next one whether it is greater or less than. To keep track of already swapped we can use boolean flag to do
    public static int[] zigzag(int [] arr){
        //  first check the base case
        if(arr.length<=2){
            return null;
        }
        boolean flag =true;
        // iterate the arr to swap
        for(int i=0; i<arr.length-1;i++){
            if(flag){
                if(arr[i]<arr[i+1]){
                    swap(arr,i,i+1);
                }
                if(arr[i]>arr[i+1]){
                    swap(arr,i,i+1);
                }
            }
            flag =!flag;
        }
     return  arr;
    }

    public static void swap(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] =temp;
    }

    public static void main(String[] args) {
        int num[] = {4,3,7,8,6,2,1};
        System.out.println(Arrays.toString(zigzag(num)));
    }
}
