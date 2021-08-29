package recusions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.swap;

public class AllPermutation {
    // variation of subset permutation, the main idea to combine  slates and used elements
    /*
    input is : [1,2,3]
    output = [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 2, 1], [3, 1, 2]]

    TC: Best case: O(N!*N)=
    SC: O(N!*N) =
     */
    private static List<ArrayList<Integer>> allPermutation(List<Integer> input){
        List<ArrayList<Integer>> result = new ArrayList<>();
        helper(new ArrayList<Integer>(input),0,result);
        return result;
    }

    private static void helper(ArrayList<Integer> slate, int placed, List<ArrayList<Integer>> result) {
        if(placed>=slate.size()){
            result.add(new ArrayList<>(slate));
            return;
        }

        for(int i=placed; i<slate.size();i++){
            swap(slate, i, placed);
            helper(slate, placed+1, result);
            swap(slate, placed,i);
        }
    }

//    private void swap(ArrayList<Integer> slate, int i, int placed) {
//        int temp = slate.get(i);
//        slate.get(i)= slate.get(placed);
//
//    }
//
// backtracking helper
    /*
    How much faster if the back tracking solution? The saving can be exponential but the worst case time wdoes not change
     */
    void helperBacktracking(List<Integer> input, int k, int index, List<Integer> slate, List<ArrayList<Integer>> results){
        if (slate.size()>k){ // base case backtracking
            return;
        }
        if (index == input.size()) { // base case
            if (slate.size() == k) {
                results.add(new ArrayList<>(slate));
            }
            return;
        }
        //recursive calls happens here
        Integer num = input.get(index);
        slate.add(num);
        helperBacktracking(input, k, index, slate, results);
        slate.remove(slate.size()-1);
        helperBacktracking(input, k, index, slate, results);
    }

    public static void main(String[] args) {
        Integer num[] ={1,2,3};
        System.out.println(allPermutation(Arrays.asList(num)));
    }
}
