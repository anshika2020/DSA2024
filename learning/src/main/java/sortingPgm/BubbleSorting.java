package sortingPgm;

import java.util.Arrays;

public class BubbleSorting {

    /*
    Bubble sort compares the elements current with next one if greater then swap ; Time complexity would be O(n^2),
    same as selection sort , only the issue we can not know how many times swapping will happpen but even in any case it would be n(n-1)/2
     */

    public static void main(String args[]) {
        System.out.println("Sorted arrays: " + Arrays.toString(sortIntArray()));
        System.out.println("Sorted arrays String: " + Arrays.toString(sortStrArray()));
    }

    private static int[] sortIntArray(){
        int num [] ={2,1,4,3,2,9};
        for(int i=0;i<num.length-1;i++){ //
            for(int j =i+1;j<num.length;j++){
                if(num[i]>num[j]){
                    int temp = num[i];
                    num[i] = num[j];
                    num[j]=temp;
                }
            }
        }
       // System.out.println("Sorted arrays: " + Arrays.toString(num));
    return num;
    }

    private static String[] sortStrArray(){
        String num [] ={"anshika","Belle"," ","Doll","Boby","Avni"};
        for(int i=0;i<num.length;i++){
            for(int j =i+1;j<num.length;j++){
                if(num[i].compareTo(num[j])>0){
                    String temp = num[i];
                    num[i] = num[j];
                    num[j]=temp;
                }
            }
        }
        // System.out.println("Sorted arrays: " + Arrays.toString(num));
        return num;
    }

}
