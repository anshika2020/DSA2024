package arrays;

import java.util.Arrays;

public class MoveOddTORIghtAndLeftEven {

    // simply swap value base on even and dd
    public static void evenToRighAndOddToLeft(int[] arr){
        for(int i=0; i<arr.length-1;i++){
            if(arr[i]%2!=0) {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }else{
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
public static void evenToRighAndOddToLeft1(int arr[]){
        int start = 0; int end = arr.length-1;
        while(start<end){
            if(arr[start]%2==0&&arr[end]%2!=0) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }else{
                if(arr[start]%2==0){
                    start++;
                }else{
                    end--;
                }
            }
        }
    System.out.println(Arrays.toString(arr));

}

    public static void main(String[] args) {
        int num1[] = {2,5,7,6,8};
          evenToRighAndOddToLeft(num1);
        evenToRighAndOddToLeft1(num1);
    }

}
