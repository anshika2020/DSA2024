package sorting;

import java.util.ArrayList;

public class MergeTowSortedArrays {
    static ArrayList<Integer> merge_one_into_another(ArrayList<Integer> first, ArrayList<Integer> second) {
        if(second.size()<1) return second;
        int j=0;int i=0;int maxSize =second.size();

        while(i<first.size()){
            if(first.get(i)<second.get(j)||second.get(j)==0){
                second.add(j, first.get(i));
                second.remove(second.size()-1);
                i++;
            }
            j++;
        }

        return second;
    }

    static ArrayList<Integer> merge_one_into_another1(ArrayList<Integer> first, ArrayList<Integer> second) {
        int k = second.size() - 1;

        int i = first.size() - 1;
        int j =i; // same number of entries in both array are populated //but in the second array-- last non zero in second aray


        while (k >= 0 && i >= 0) {

            if (j >= 0 && second.get(j) >= first.get(i)) {
                second.set(k, second.get(j));
                j--;
            } else {
                second.set(k, first.get(i));
                i--;
            }
            k--;
        }

        return second;
    }

}
