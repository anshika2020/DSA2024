package recusions;

import java.util.ArrayList;
import java.util.List;
public class AllSubsetI {

    private static List<ArrayList<Integer>> getSubSets(List<Integer> input){
        List<ArrayList<Integer>> result = new ArrayList<>();
        helper(input,0, new ArrayList<Integer>(), result );
        return result;
    }

    /*
    input: orginal input, index: to check teh progress , slate : store the possible results, result : collector for results
     */
    private static void helper(List<Integer>input, int index, ArrayList<Integer> slate, List<ArrayList<Integer>> result) {
        if(index>=input.size()){
            int target = -12;
            result.add(new ArrayList<Integer>(slate));
            int sum = 0;
            for(int i=0; i<slate.size();i++){
                sum += slate.get(i);
            }
            if(sum ==target){
                System.out.println( "sum" +slate);
            }
            return;
        }
        Integer num = input.get(index);
        slate.add(num);
        // include call
        helper(input,index+1, slate, result);
        slate.remove(slate.size()-1); // remove the last element from slate i.e element added two nums above
        // exclude call
        helper(input,index+1, slate, result);
    }



    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(2);
        list.add(3);
        // number are disctint
        Integer[] num = {5,-3,-3,-3,-3};
        System.out.println(getSubSets(list));
        // if number are not distinct
        // if interview ask that if i give 1,2,2 then use DS which does not allow duplicates like HashSet
        /*
        sort input
        exclude the duplicate
         */
      //  System.out.println(getSubSets(Arrays.asList(num)));


    }
}
