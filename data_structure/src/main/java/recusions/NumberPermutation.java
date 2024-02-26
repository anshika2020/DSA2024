package recusions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumberPermutation {

    private static List<List<Integer>> getAllPermutation(List<Integer> number){
        List<List<Integer>> results = new ArrayList<>();
        helper(number, 0, results); // this helper will take input list , int index from where we want to start, list of list to store results
        return results;

    }
    static void helper(List<Integer> number, int index, List<List<Integer>> result){

        //base case
        if(index>=number.size()){ // have base case to check or terminate the call if index is greater than or equal to input list size
            result.add(new ArrayList<>(number)); // finally add the given number list to result list  once condition matches
            return;

        }
        // logic for recursive
        for(int i=index; i<number.size();i++){ // start iteration from index through size of list
            Collections.swap(number,i,index); // swap the i with index
            helper(number,i+1,result); // call helper to perform recusrive call which will take the input list and start adding next number next from ith index  and add to result.
            Collections.swap(number,index,i); // swap back to riginal to reset the ith and index values position
        }
    }

    public static void main(String[] args) {
        Integer num[] = {1,2,3};
        System.out.println(getAllPermutation(Arrays.asList(num)));
    }
}
