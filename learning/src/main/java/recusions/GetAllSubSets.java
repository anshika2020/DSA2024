package recusions;

import java.util.Arrays;

public class GetAllSubSets {
    
    private static int[] getSubset(int[] arr){
        int[] subset = new int[arr.length];
        helperSubset(arr, 0, subset);
        return subset;

    }


    private static void helperSubset(int[] arr, int index, int[] subset) {

        //base case
       if(index>=arr.length){
           System.out.printf(Arrays.toString(subset));
       }else{ // logic for recursiv call

           subset[index] = 0;
           helperSubset(arr, index+1, subset);
           subset[index] = arr[index];
           helperSubset(arr, index+1, subset);
       }


    }

    public static void main(String[] args) {
        int num[] = {2,4,8};
        getSubset(num);

     //   generate_all_subsets("xy");
    }


}
