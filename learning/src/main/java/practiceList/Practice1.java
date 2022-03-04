package practiceList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Practice1 {
    public static int[] moveZeros(int[] arr){
        Queue<Integer> q= new LinkedList<>();
        int[] newArr=new int[arr.length];
        int len= newArr.length-1;
        // iterate through the array
        for(int i=0;i<arr.length;i++){
            // if (ith is 0) then add in queue
            if(arr[i]==0){
                q.add(arr[i]);
                newArr[i] = q.remove();
                i++;

            }else{
                newArr[len] = arr[i];

            }

        }

        return newArr;
    }
    public static void main(String[] args) {
        int[] num ={1,0,3,5,0,-1}; //[0,0,0,1,3,5,-1];
        System.out.println(Arrays.toString(moveZeros(num)));
    }
}
